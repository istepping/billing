package com.billing.service;

import com.billing.entity.Recommend;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunLei on 2019/3/5 19:02
 * @version 1.0
 * @apiNote
 */
@Service
public interface RecommendService {
    //获取全部信息
    List<Recommend> getRecommend(Long uId);
    //分类获取,个性化推荐
    List<Recommend> getRecommendWithType(Long uId,String type);
    //搜索功能
    List<Recommend> searchByName(String name);
}
