package com.billing.dao;

import com.billing.entity.Gtype;

import java.util.List;

public interface GtypeMapper {
    List<Gtype> selectByPTypeId(Long tPtypeid);

    //获取主分类
    List<Gtype> selectGtypes();

    int deleteByPrimaryKey(Long tId);

    int insert(Gtype record);

    int insertSelective(Gtype record);

    Gtype selectByPrimaryKey(Long tId);

    int updateByPrimaryKeySelective(Gtype record);

    int updateByPrimaryKey(Gtype record);
}