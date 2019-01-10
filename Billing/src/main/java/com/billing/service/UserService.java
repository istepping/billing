package com.billing.service;

import com.billing.base.BaseService;
import com.billing.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author sunLei on 2018/11/17 15:19
 * @version 1.0
 * @apiNote
 */
@Service
public interface UserService {
    //登陆
    BaseService.ServiceResult login(String code);
    //添加信息
    BaseService.ServiceResult addInfo(User user);
    //获取用户信息
    BaseService.ServiceResult getUserInfo(Long uId);
}
