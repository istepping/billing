package com.billing.service;

import com.billing.base.BaseService;
import org.springframework.stereotype.Service;

/**
 * @author sunLei on 2018/11/22 16:10
 * @version 1.0
 * @apiNote
 */
@Service
public interface GtypeService {
    //获取一级类型
    BaseService.ServiceResult getType();
    //获取下级类型
    BaseService.ServiceResult getChildType(Long pTypeId);
}
