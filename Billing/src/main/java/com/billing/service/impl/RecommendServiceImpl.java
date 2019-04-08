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
    //用户个性化推荐
    @Override
    public List<Recommend> getRecommend(Long uId) {
        return recommendMapper.selectList();
    }

    @Override
    public List<Recommend> getRecommendWithType(Long uId, String type) {
        return null;
    }

    @Override
    public List<Recommend> searchByName(String name) {
        return null;
    }
}
