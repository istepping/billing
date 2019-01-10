package com.billing.service;

import com.billing.base.BaseService;
import org.springframework.stereotype.Service;

/**
 * @author sunLei on 2018/11/22 16:08
 * @version 1.0
 * @apiNote
 */
@Service
public interface SettingService {
    //设置家校互通
    BaseService.ServiceResult setOpenFamily(Long uId, Integer content);
    BaseService.ServiceResult setBillPrivate(Long uId, Integer content);
    //设置账号
    BaseService.ServiceResult setParentId(Long uId, Integer flag, Long parentId);
    //查询设置信息
    BaseService.ServiceResult getSetting(Long uId);
}
