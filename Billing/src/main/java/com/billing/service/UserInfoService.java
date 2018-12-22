package com.billing.service;

import com.billing.base.BaseService;
import com.billing.entity.UserInfo;
import org.springframework.stereotype.Service;

/**
 * @author sunLei on 2018/11/28 20:46
 * @version 1.0
 * @apiNote
 */
@Service
public interface UserInfoService {
    //插入
    BaseService.ServiceResult addUserInfo(UserInfo userInfo);
    //查询
    BaseService.ServiceResult getUserInfo(Long uId);
}
