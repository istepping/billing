package com.billing.dao;

import com.billing.entity.Grank;

public interface GrankMapper {
    int deleteByPrimaryKey(Long tId);

    int insert(Grank record);

    int insertSelective(Grank record);

    Grank selectByPrimaryKey(Long tId);

    int updateByPrimaryKeySelective(Grank record);

    int updateByPrimaryKey(Grank record);
}