package com.billing.service;

import com.billing.base.BaseService;
import org.springframework.stereotype.Service;

/**
 * @author sunLei on 2018/11/21 11:24
 * @version 1.0
 * @apiNote
 */
@Service
public interface ActionService {
    //查询
    BaseService.ServiceResult getAction(Long uId);

    BaseService.ServiceResult getActionWithAlgo(Long uId);

    //特征计算
    void calculateFeature(Long uId,String year,String month);
}
