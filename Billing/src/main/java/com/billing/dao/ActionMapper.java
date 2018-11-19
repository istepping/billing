package com.billing.dao;

import com.billing.entity.Action;

public interface ActionMapper {
    int deleteByPrimaryKey(Long aId);

    int insert(Action record);

    int insertSelective(Action record);

    Action selectByPrimaryKey(Long aId);

    int updateByPrimaryKeySelective(Action record);

    int updateByPrimaryKey(Action record);
}