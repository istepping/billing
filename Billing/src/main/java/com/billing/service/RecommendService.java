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
    List<Recommend> getRecommend();
}
