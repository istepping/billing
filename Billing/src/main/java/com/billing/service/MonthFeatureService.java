package com.billing.service;

import org.springframework.stereotype.Service;

/**
 * @author sunLei on 2019/1/3 14:33
 * @version 1.0
 * @apiNote
 */
@Service
public interface MonthFeatureService {
    //计算月特征值,并保存
    void calculateMonthFeature(Long uId, String year, String month);
}
