package com.billing.service.impl;

import com.billing.base.BaseService;
import com.billing.dao.BillMapper;
import com.billing.dao.GtypeMapper;
import com.billing.dao.MonthFeatureMapper;
import com.billing.dto.MonthExposeCountDto;
import com.billing.dto.TypeCountDto;
import com.billing.entity.Bill;
import com.billing.entity.Feature;
import com.billing.entity.Gtype;
import com.billing.entity.MonthFeature;
import com.billing.service.BillService;
import com.billing.service.MonthFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static com.billing.utils.Assist.print;

/**
 * @author sunLei on 2019/1/3 14:35
 * @version 1.0
 * @apiNote
 */
@Service
public class MonthFeatureServiceImpl extends BaseService implements MonthFeatureService {
    @Autowired
    private MonthFeatureMapper monthFeatureMapper;
    @Autowired
    private BillMapper billMapper;
    @Autowired
    private GtypeMapper gtypeMapper;
    @Autowired
    private BillService billService;
    @Override
    public void calculateMonthFeature(Long uId, String year, String month) {
        String pattern;
        //不同月份结构适应
        if(month.length()==1){
            pattern=year + "-0" + month + "%";
        }else{
            pattern=year + "-" + month + "%";
        }
        List<Bill> bills = billMapper.selectByMonth(uId, pattern);
        BigDecimal moneyThan = new BigDecimal(0);//P
        BigDecimal sumMoney = new BigDecimal(0);//S
        BigDecimal L = new BigDecimal(0);//L
        BigDecimal R = new BigDecimal(0);//R
        BigDecimal N = new BigDecimal(0);//N
        double C = 0.0;//C
        List<Gtype> gtypes = gtypeMapper.selectGtypes();
        List<Gtype> delgtypes = new ArrayList<>();
        for (Gtype gtype : gtypes) {
            if (gtype.gettBelong().equals("收入")) {
                delgtypes.add(gtype);
            }
        }
        gtypes.removeAll(delgtypes);
        List<TypeCountDto> typeCountDtos = new ArrayList<>();
        for (Gtype gtype : gtypes) {
            TypeCountDto typeCountDto = new TypeCountDto(gtype.gettId(), gtype.gettName(), 0);
            typeCountDtos.add(typeCountDto);
        }
        for (Bill bill : bills) {
            BigDecimal mMoney = bill.getMoney();
            String gType = bill.getgType();
            if (gType != null && bill.getbType() != null && bill.getbType().equals("支出")) {
                sumMoney = sumMoney.add(mMoney);
                C++;
                if (bill.getMoney().compareTo(new BigDecimal("200")) > 0) {
                    moneyThan = moneyThan.add(mMoney);
                }
                if (bill.getMoney().compareTo(new BigDecimal("50")) < 0) {
                    N = N.add(mMoney);
                }
                if (gType.equals("餐饮") || gType.equals("饮食") || gType.equals("服饰") || gType.equals("学习")) {
                    L = L.add(mMoney);
                } else {
                    R = R.add(mMoney);
                }
                for (TypeCountDto typeCountDto : typeCountDtos)
                    if (gType.equals(typeCountDto.getType())) {
                        typeCountDto.setCount(typeCountDto.getCount() + 1);
                    }
            }
        }
        //比零系数
        BigDecimal temp = R.subtract(L);
        print(sumMoney);
        if(sumMoney.compareTo(new BigDecimal("1"))<0){
            sumMoney=new BigDecimal("1");
        }
        BigDecimal M = temp.abs().divide(sumMoney, 2, RoundingMode.HALF_UP);
        BigDecimal param1 = M.compareTo(new BigDecimal("0.5")) < 0 ? M.add(new BigDecimal("0.5")) : M.subtract(new BigDecimal("0.5"));
        //大额商品占比
        BigDecimal param2 = moneyThan.divide(sumMoney, 2, RoundingMode.HALF_UP);
        //购买率
        List<Integer> counts = new ArrayList<>();
        for (TypeCountDto typeCountDto : typeCountDtos) {
            if (typeCountDto.getCount() > 0) {
                counts.add(typeCountDto.getCount());
            }
        }
        Double sum = 0.0;
        for (Integer item : counts) {
            sum += Double.valueOf(item);
        }
        BigDecimal param3;
        if(C==0){
            param3 = new BigDecimal("0");
        }else{
            double D = sum / counts.size();//D
            param3 = new BigDecimal(D / C);
        }

        param3 = param3.setScale(2, RoundingMode.HALF_UP);
        //波动率
        List<MonthExposeCountDto> monthExposeCountDtos = billService.getMonthExposeForAction(uId);
        List<BigDecimal> moneys = new ArrayList<>();
        //计算波动量
        for (int i = 0; i < monthExposeCountDtos.size() - 1; i++) {
            BigDecimal subMoney = monthExposeCountDtos.get(i).getSumMoney().subtract(monthExposeCountDtos.get(i + 1).getSumMoney());
            moneys.add(subMoney);
        }
        //计算平均波动量
        BigDecimal minMoney = new BigDecimal("0");
        BigDecimal maxMoney = new BigDecimal("0");
        BigDecimal sumSubMoney = new BigDecimal("0");
        for (BigDecimal item : moneys) {
            sumSubMoney = sumSubMoney.add(item);
            if (item.compareTo(maxMoney) > 0) {
                maxMoney = item;
            }
            if (item.compareTo(minMoney) < 0) {
                minMoney = item;
            }
        }
        BigDecimal param4;
        if (moneys.size() <= 1) {
            param4 = new BigDecimal("0.5");
        } else {
            param4 = (sumSubMoney.divide(new BigDecimal(moneys.size()), 2, RoundingMode.HALF_UP).subtract(minMoney)).divide(maxMoney.subtract(minMoney), 2, RoundingMode.HALF_UP);
        }
        //经济率
        BigDecimal param5 = N.divide(sumMoney, 2, RoundingMode.HALF_UP);
        //常用商品比率
        BigDecimal param6 = L.divide(sumMoney, 2, RoundingMode.HALF_UP);
        MonthFeature feature = monthFeatureMapper.selectByMonth(uId, year, month);
        if (feature == null) {
            monthFeatureMapper.insert(new MonthFeature(uId, year, month, param1.toString(), param2.toString(), param3.toString(), param4.toString(), param5.toString(), param6.toString()));
        } else {
            monthFeatureMapper.updateByPrimaryKeySelective(new MonthFeature(feature.getfId(), uId, year, month, param1.toString(), param2.toString(), param3.toString(), param4.toString(), param5.toString(), param6.toString()));
        }
    }
}
