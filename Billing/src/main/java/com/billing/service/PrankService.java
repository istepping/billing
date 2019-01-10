package com.billing.service;

import com.billing.base.BaseService;
import org.springframework.stereotype.Service;

/**
 * @author sunLei on 2018/11/22 17:03
 * @version 1.0
 * @apiNote
 */
@Service
public interface PrankService {
    //查询通过年月
    BaseService.ServiceResult getPrank(String year, String month, Long uId);

    //获取前10名
    BaseService.ServiceResult getPre10Ranks(String year, String month);

    //排名变动(前12个月)
    BaseService.ServiceResult getRankChange(Long uId);

    //[内部服务][月排名信息判断、计算、排名]
    BaseService.ServiceResult preHandle(String year, String month);
}
