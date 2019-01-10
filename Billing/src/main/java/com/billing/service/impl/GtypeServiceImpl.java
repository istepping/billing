package com.billing.service.impl;

import com.billing.base.BaseService;
import com.billing.dao.GtypeMapper;
import com.billing.entity.Gtype;
import com.billing.service.GtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunLei on 2018/11/22 18:47
 * @version 1.0
 * @apiNote
 */
@Service
public class GtypeServiceImpl extends BaseService implements GtypeService {
    @Autowired
    GtypeMapper gtypeMapper;
    @Override
    public ServiceResult getType() {
        List<Gtype> gtypes=gtypeMapper.selectGtypes();
        Map<String,Object> data=new HashMap<>();
        data.put("gtypes",gtypes);
        return success(data);
    }

    @Override
    public ServiceResult getChildType(Long pTypeId) {
        List<Gtype> gtypes=gtypeMapper.selectByPTypeId(pTypeId);
        Map<String,Object> data=new HashMap<>();
        data.put("gtypes",gtypes);
        return success(data);
    }
}
