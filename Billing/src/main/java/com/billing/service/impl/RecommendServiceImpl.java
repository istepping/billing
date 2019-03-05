package com.billing.service.impl;

import com.billing.base.BaseService;
import com.billing.dao.RecommendMapper;
import com.billing.entity.Recommend;
import com.billing.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunLei on 2019/3/5 19:03
 * @version 1.0
 * @apiNote
 */
@Service
public class RecommendServiceImpl extends BaseService implements RecommendService {
    @Autowired
    private RecommendMapper recommendMapper;
    @Override
    public List<Recommend> getRecommend() {
        return recommendMapper.selectList();
    }
}
