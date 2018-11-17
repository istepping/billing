package com.billing.service;

import org.springframework.stereotype.Service;

/**
 * @author sunLei on 2018/11/17 15:19
 * @version 1.0
 * @apiNote
 */
@Service
public interface UserService {
    //登陆
    boolean login(String code);
}
