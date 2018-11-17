package com.billing.dao;

import com.billing.entity.User;

public interface UserMapper {
    User selectByWxId(String wxId);

    int deleteByPrimaryKey(Long uId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long uId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}