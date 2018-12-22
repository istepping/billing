package com.billing.service.impl;

import com.billing.base.BaseService;
import com.billing.dao.ActionMapper;
import com.billing.dao.BillMapper;
import com.billing.dao.FeatureMapper;
import com.billing.dao.GtypeMapper;
import com.billing.dto.JsonBean;
import com.billing.dto.MonthExposeCountDto;
import com.billing.dto.TypeCountDto;
import com.billing.entity.Action;
import com.billing.entity.Bill;
import com.billing.entity.Feature;
import com.billing.entity.Gtype;
import com.billing.service.ActionService;
import com.billing.service.BillService;
import com.billing.utils.API;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.billing.utils.Assist.print;


/**
 * @author sunLei on 2018/11/21 11:27
 * @version 1.0
 * @apiNote
 */
@Service
public class ActionServiceImpl extends BaseService implements ActionService {
    @Autowired
    private ActionMapper actionMapper;
    @Autowired
    private BillMapper billMapper;
    @Autowired
    private GtypeMapper gtypeMapper;
    @Autowired
    private BillService billService;
    @Autowired
    private FeatureMapper featureMapper;

    @Override
    public ServiceResult getAction(Long uId) {
        List<Action> action = actionMapper.selectByUId(uId);
        Map<String, Object> data = new HashMap<>();
        data.put("action", action);
        return success(data);
    }

    @Override
    public void calculateFeature(Long uId) {
        List<Bill> bills = billMapper.selectByUId(uId);
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
            //print(mMoney);
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
                for (TypeCountDto typeCountDto : typeCountDtos) {
                    if (gType.equals(typeCountDto.getType())) {
                        typeCountDto.setCount(typeCountDto.getCount() + 1);
                    }
                }
            }
        }
        //比零系数
        BigDecimal temp = R.subtract(L);
        print(sumMoney);
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
        Double D = sum / counts.size();//D
        BigDecimal param3 = new BigDecimal(D / C);
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
        Feature feature = featureMapper.selectByUId(uId);
        if (feature == null) {
            featureMapper.insert(new Feature(uId, param1.toString(), param2.toString(), param3.toString(), param4.toString(), param5.toString(), param6.toString()));
        } else {
            featureMapper.updateByPrimaryKeySelective(new Feature(feature.getfId(), uId, param1.toString(), param2.toString(), param3.toString(), param4.toString(), param5.toString(), param6.toString()));
        }
    }

    @Override
    public BaseService.ServiceResult getActionWithAlgo(Long uId) {
        calculateFeature(uId);
        Feature feature = featureMapper.selectByUId(uId);
        String response = API.INSTANCE.request("http://127.0.0.1:8000/get_action?param1=" + feature.getfParam1() + "&param2=" + feature.getfParam2() + "&param3=" + feature.getfParam3() + "&param4=" + feature.getfParam4() + "&param5=" + feature.getfParam5() + "&param6=" + feature.getfParam6());
        JSONObject jsonObject = JSONObject.fromObject(response);
        JsonBean jsonBean = (JsonBean) JSONObject.toBean(jsonObject, JsonBean.class);
        Action action = new Action();
        action.setuId(uId);
        action.setaReason(jsonBean.getaReason());
        action.setaImpluse(jsonBean.getaImpluse());
        action.setaHabit(jsonBean.getaHabit());
        action.setaRandom(jsonBean.getaRandom());
        action.setaCollection(jsonBean.getaCollection());
        action.setaImagine(jsonBean.getaImagine());
        Map<String, Object> data = new HashMap<>();
        List<Action> actions = new ArrayList<>();
        actions.add(action);
        data.put("action", actions);
        return success(data);
    }
}
