package com.billing.service.impl;

import com.billing.base.BaseService;
import com.billing.dao.*;
import com.billing.dto.DayExposeCountDto;
import com.billing.dto.ExposeCountDto;
import com.billing.dto.MonthExposeCountDto;
import com.billing.entity.*;
import com.billing.enums.FailInfoEnum;
import com.billing.manager.UserMgr;
import com.billing.service.BillService;
import com.billing.utils.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.*;

import static com.billing.utils.Assist.logger;
import static com.billing.utils.Assist.print;
import static com.billing.utils.Auth.isNumber;

/**
 * @author sunLei on 2018/11/14 19:57
 * @version 1.0
 */
@Transactional
@Service
public class BillServiceImpl extends BaseService implements BillService {
    @Autowired
    BillMapper billMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    GtypeMapper gtypeMapper;
    @Autowired
    SettingMapper settingMapper;
    @Autowired
    RecommendMapper recommendMapper;
    @Override
    public ServiceResult updateBillByBId(Bill bill) {
        int result=billMapper.updateByPrimaryKeySelective(bill);
        if (result>0){
            return success();
        }else{
            return failDataBase();
        }
    }

    @Override
    public ServiceResult addExtra(Long bId, Long uId, String extraInfo) {
        Bill bill = billMapper.selectByPrimaryKey(bId);
        if (bill.getuId().equals(uId)) {
            Bill bill2 = new Bill();
            bill2.setbId(bId);
            bill2.setExtraInfo(extraInfo);
            if (billMapper.updateByPrimaryKeySelective(bill2) > 0) {
                return success();
            } else {
                return fail("操作失败");
            }
        }
        return fail("账单ID不属于本人");
    }

    @Override
    public ServiceResult deleteBill(Long bId, Long uId) {
        Bill bill = billMapper.selectByPrimaryKey(bId);
        if (bill.getuId().equals(uId)) {
            if (billMapper.deleteByPrimaryKey(bId) > 0) {
                return success();
            }
        }
        return fail();
    }

    @Override
    public ServiceResult addBillByUId(Bill bill) {
        if (billMapper.insert(bill) > 0) {
            //跟新数据操作
            if(bill.getgType()!=null && bill.getgType2()!=null && bill.getgType4()!=null){
                Recommend recommend=recommendMapper.selectByTypeAndNameAndBrand(bill.getgType(),bill.getgType2(),bill.getgType4());
                //4id作为like
                if(bill.getgType4id()==null || bill.getgType4id()>=4){
                    recommend.setrLike(String.valueOf((Double.valueOf(recommend.getrLike())*recommend.getrBuynum()+1)/(recommend.getrBuynum()+1)).substring(0,4));
                    recommend.setrPrice(recommend.getrPrice().multiply(new BigDecimal(recommend.getrBuynum())).add(bill.getMoney()).divide(new BigDecimal(recommend.getrBuynum()+1),2, RoundingMode.HALF_UP));
                }
                recommend.setrBuynum(recommend.getrBuynum()+1);
                recommendMapper.updateByPrimaryKeySelective(recommend);
            }
            return success();
        } else {
            return fail();
        }
    }

    @Override
    public Bill getBillByBId(long bId) {
        return billMapper.selectByPrimaryKey(bId);
    }

    @Override
    public List<Bill> getBillList(Long uId) {
        return billMapper.selectByUId(uId);
    }

    @Override
    public ServiceResult getChildBills(Long uId) {
        List<Setting> settings = settingMapper.selectByMIdOrFId(uId);
        if (settings.size() <= 0) {
            return fail("无数据");
        }
        if (settings.get(0).getuOpenFamily() == 0) {
            return fail("用户未开启该功能");
        }
        List<Bill> bills = billMapper.selectByUId(settings.get(0).getuId());
        Map<String, Object> data = new HashMap<>();
        data.put("bills", bills);
        return success(data);
    }

    @Override
    public ServiceResult getTypeBill(Long uId, String year, String month) {
        if (!isNumber(year) || !isNumber(month)) {
            return fail(FailInfoEnum.fail1.getInfo());
        }
        String pattern = year + "-" + month + "%";
        List<Bill> bills = billMapper.selectByMonth(uId, pattern);
        //计算分类金额
        List<Gtype> gtypes = gtypeMapper.selectGtypes();
        List<Gtype> delgtypes = new ArrayList<>();
        for (Gtype gtype : gtypes) {
            if (gtype.gettBelong().equals("收入")) {
                delgtypes.add(gtype);
            }
        }
        gtypes.removeAll(delgtypes);
        List<ExposeCountDto> exposeCountDtos = new ArrayList<>();
        for (int i = 0; i < gtypes.size(); i++) {
            ExposeCountDto exposeCountDto = new ExposeCountDto();
            exposeCountDto.setYear(year);
            exposeCountDto.setMonth(month);
            exposeCountDto.setTypeId(gtypes.get(i).gettId());
            exposeCountDto.setType(gtypes.get(i).gettName());
            exposeCountDto.setSumMoney(new BigDecimal(0));
            exposeCountDtos.add(exposeCountDto);
        }
        for (int i = 0; i < bills.size(); i++) {
            String tType = bills.get(i).getgType();
            if (bills.get(i).getbType() != null && bills.get(i).getbType().equals("收入")) {
                //过滤掉
                continue;
            }
            if (tType != null) {
                for (ExposeCountDto exposeCountDto : exposeCountDtos) {
                    if (tType.equals(exposeCountDto.getType())) {
                        exposeCountDto.setSumMoney(exposeCountDto.getSumMoney().add(bills.get(i).getMoney()));
                    }
                }
            }
        }
        Map<String, Object> data = new HashMap<>();
        data.put("exposeCount", exposeCountDtos);
        return success(data);
    }

    @Override
    public ServiceResult getDayBillByMonth(Long uId, String year, String month) {
        if (!isNumber(year) || !isNumber(month)) {
            return fail(FailInfoEnum.fail1.getInfo());
        }
        String pattern = year + "-" + month + "%";
        List<Bill> bills = billMapper.selectByMonth(uId, pattern);
        List<DayExposeCountDto> dayExposeCountDtos = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, Integer.parseInt(month) - 1);
        calendar.set(Calendar.DATE, 1);
        calendar.roll(Calendar.DATE, -1);
        int days = calendar.get(Calendar.DATE);
        for (int i = 0; i < days; i++) {
            DayExposeCountDto dayExposeCountDto = new DayExposeCountDto();
            dayExposeCountDto.setYear(year);
            dayExposeCountDto.setMonth(month);
            dayExposeCountDto.setDay(String.valueOf(i + 1));
            dayExposeCountDto.setSumMoney(new BigDecimal(0));
            dayExposeCountDtos.add(dayExposeCountDto);
        }
        for (int i = 0; i < bills.size(); i++) {
            Bill bill = bills.get(i);
            if (bill.getbType() != null && bill.getbType().equals("收入")) {
                //过滤掉
                continue;
            }
            Date date = bill.getSaveTime();
            BigDecimal money = bill.getMoney();
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(date);
            int day = calendar1.get(Calendar.DAY_OF_MONTH);
            dayExposeCountDtos.get(day - 1).setSumMoney(money.add(dayExposeCountDtos.get(day - 1).getSumMoney()));
        }
        Map<String, Object> data = new HashMap<>();
        data.put("dayExposeCount", dayExposeCountDtos);
        return success(data);
    }

    @Override
    public ServiceResult getBillsByMonth(String year, String month, String level, String type) {
        if (!isNumber(year) || !isNumber(month) || !isNumber(level)) {
            return fail(FailInfoEnum.fail1.getInfo());
        }
        int typeLevel = Integer.parseInt(level);
        if (typeLevel < 0 || typeLevel > 4) {
            return failInput();
        }
        List<Bill> bills = new ArrayList<>();
        String pattern = year + "-" + month + "%";
        switch (typeLevel) {
            case 1:
                bills = billMapper.selectByType(pattern, type);
                break;
            case 2:
                bills = billMapper.selectByType2(pattern, type);
                break;
            case 3:
                bills = billMapper.selectByType3(pattern, type);
                break;
            case 4:
                bills = billMapper.selectByType4(pattern, type);
                break;
            default:
                break;
        }

        ExposeCountDto exposeCountDto = new ExposeCountDto();
        exposeCountDto.setYear(year);
        exposeCountDto.setMonth(month);
        exposeCountDto.setType(type);
        exposeCountDto.setSumMoney(new BigDecimal(0));
        for (int i = 0; i < bills.size(); i++) {
            if (bills.get(i).getbType() != null && bills.get(i).getbType().equals("收入")) {
                //过滤掉
                continue;
            }
            exposeCountDto.setSumMoney(exposeCountDto.getSumMoney().add(bills.get(i).getMoney()));
        }
        Map<String, Object> data = new HashMap<>();
        data.put("expose", exposeCountDto);
        return success(data);
    }

    @Override
    public ServiceResult getMonthSumByYear(Long uId, String year) {
        if (!isNumber(year)) {
            return fail(FailInfoEnum.fail1.getInfo());
        }
        //获取账单
        String pattern = year + "%";
        List<Bill> bills = billMapper.selectByMonth(uId, pattern);
        //数据处理
        List<MonthExposeCountDto> monthExposeCountDtos = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            MonthExposeCountDto monthExposeCountDto = new MonthExposeCountDto(year, String.valueOf(i + 1), new BigDecimal(0));
            monthExposeCountDtos.add(monthExposeCountDto);
        }
        for (int i = 0; i < bills.size(); i++) {
            Bill bill = bills.get(i);
            if (bill.getbType() != null && bill.getbType().equals("收入")) {
                //过滤掉
                continue;
            }
            Date date = bill.getSaveTime();
            BigDecimal money = bill.getMoney();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int month = calendar.get(Calendar.MONTH);
            monthExposeCountDtos.get(month).setSumMoney(money.add(monthExposeCountDtos.get(month).getSumMoney()));
        }
        //返回数据
        Map<String, Object> data = new HashMap<>();
        data.put("monthExpose", monthExposeCountDtos);
        return success(data);
    }

    @Override
    public ServiceResult getTypeSumByYear(Long uId, String year) {
        if (!isNumber(year)) {
            return fail(FailInfoEnum.fail1.getInfo());
        }
        String pattern = year + "%";
        List<Bill> bills = billMapper.selectByMonth(uId, pattern);
        //计算分类金额
        List<Gtype> gtypes = gtypeMapper.selectGtypes();
        List<Gtype> delgtypes = new ArrayList<>();
        for (Gtype gtype : gtypes) {
            if (gtype.gettBelong().equals("收入")) {
                delgtypes.add(gtype);
            }
        }
        gtypes.removeAll(delgtypes);
        List<ExposeCountDto> exposeCountDtos = new ArrayList<>();
        for (int i = 0; i < gtypes.size(); i++) {
            ExposeCountDto exposeCountDto = new ExposeCountDto(year, gtypes.get(i).gettId(), gtypes.get(i).gettName(), new BigDecimal(0));
            exposeCountDtos.add(exposeCountDto);
        }
        for (int i = 0; i < bills.size(); i++) {
            if (bills.get(i).getbType() != null && bills.get(i).getbType().equals("收入")) {
                //过滤掉
                continue;
            }
            String tType = bills.get(i).getgType();
            if (tType == null) {
                logger.debug("没有类型");
            } else {
                for (ExposeCountDto exposeCountDto : exposeCountDtos) {
                    if (tType.equals(exposeCountDto.getType())) {
                        exposeCountDto.setSumMoney(exposeCountDto.getSumMoney().add(bills.get(i).getMoney()));
                    }
                }
            }
        }
        Map<String, Object> data = new HashMap<>();
        data.put("exposeCount", exposeCountDtos);
        return success(data);
    }

    @Override
    public List<MonthExposeCountDto> getMonthExposeForAction(Long uId) {
        List<Bill> bills = billMapper.selectByUId(uId);
        List<MonthExposeCountDto> monthExposeCountDtos = new ArrayList<>();
        for (Bill bill : bills) {
            String gType = bill.getgType();
            BigDecimal mMoney = bill.getMoney();
            Date date = bill.getSaveTime();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            boolean hasExpose = false;
            if (gType != null && gType.equals("支出")) {
                for (MonthExposeCountDto monthExposeCountDto : monthExposeCountDtos) {
                    if (monthExposeCountDto.getYear().equals(String.valueOf(year)) && monthExposeCountDto.getMonth().equals(String.valueOf(month))) {
                        monthExposeCountDto.setSumMoney(monthExposeCountDto.getSumMoney().add(mMoney));
                        hasExpose = true;
                    }
                }
                if (!hasExpose) {
                    MonthExposeCountDto monthExposeCountDto=new MonthExposeCountDto(String.valueOf(year),String.valueOf(month),mMoney);
                    monthExposeCountDtos.add(monthExposeCountDto);
                }
            }
        }
        return monthExposeCountDtos;
    }
}
