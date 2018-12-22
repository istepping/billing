package com.billing.dao;

import com.billing.entity.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Long uId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long uId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}