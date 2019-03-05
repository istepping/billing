package com.billing.dao;

import com.billing.entity.Recommend;

import java.util.List;

public interface RecommendMapper {
    List<Recommend> selectList();

    int deleteByPrimaryKey(Long rId);

    int insert(Recommend record);

    int insertSelective(Recommend record);

    Recommend selectByPrimaryKey(Long rId);

    int updateByPrimaryKeySelective(Recommend record);

    int updateByPrimaryKey(Recommend record);
}