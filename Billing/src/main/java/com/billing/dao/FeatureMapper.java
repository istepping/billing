package com.billing.dao;

import com.billing.entity.Feature;

public interface FeatureMapper {
    Feature selectByUId(Long uId);

    int deleteByPrimaryKey(Long fId);

    int insert(Feature record);

    int insertSelective(Feature record);

    Feature selectByPrimaryKey(Long fId);

    int updateByPrimaryKeySelective(Feature record);

    int updateByPrimaryKey(Feature record);
}