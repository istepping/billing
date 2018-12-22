package com.billing.service.impl;

import com.billing.base.BaseService;
import com.billing.dao.GrankMapper;
import com.billing.entity.Grank;
import com.billing.enums.FailInfoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.billing.utils.Auth.isNumber;

/**
 * @author sunLei on 2018/11/22 16:11
 * @version 1.0
 * @apiNote
 */
@Service
public class GrankServiceImpl extends BaseService implements com.billing.service.GrankService {
    @Autowired
    GrankMapper grankMapper;
    @Override
    public ServiceResult getGrank(String year, String month) {
        if(!isNumber(year) || !isNumber(month)){
            return fail(FailInfoEnum.fail1.getInfo());
        }
        List<Grank> granks=grankMapper.selectByMonth(year,month);
        Map<String,Object> data=new HashMap<>();
        data.put("granks",granks);
        return success(data);
    }
}
