package com.billing.dao;

import com.billing.entity.Good;

public interface GoodMapper {
    int deleteByPrimaryKey(Integer gId);

    int insert(Good record);

    int insertSelective(Good record);

    Good selectByPrimaryKey(Integer gId);

    int updateByPrimaryKeySelective(Good record);

    int updateByPrimaryKey(Good record);
}