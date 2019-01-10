package com.billing.service.impl;

import com.billing.base.BaseService;
import com.billing.dao.GoodMapper;
import com.billing.entity.Good;
import com.billing.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunLei on 2018/11/21 13:52
 * @version 1.0
 * @apiNote
 */
@Service
public class GoodServiceImpl extends BaseService implements GoodService {
    @Autowired
    GoodMapper goodMapper;
    @Override
    public List<Good> getGoods(int level, Long typeId) {
        List<Good> goods=new ArrayList<>();
        switch(level){
            case 1:
                goods= goodMapper.selectByTypeId(typeId);
                break;
            case 2:
                goods= goodMapper.selectByType2Id(typeId);
                break;
            case 3:
                goods= goodMapper.selectByType3Id(typeId);
                break;
            case 4:
                goods= goodMapper.selectByType4Id(typeId);
                break;
            default:
                goods= goodMapper.selectByTypeId(typeId);
                break;
        }
        return goods;
    }
}
