package com.billing.dao;

import com.billing.entity.Action;

import java.util.List;

public interface ActionMapper {
    List<Action> selectByUId(Long uId);

    int deleteByPrimaryKey(Long aId);

    int insert(Action record);

    int insertSelective(Action record);

    Action selectByPrimaryKey(Long aId);

    int updateByPrimaryKeySelective(Action record);

    int updateByPrimaryKey(Action record);
}