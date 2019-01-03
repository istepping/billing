package com.billing.dao;

import com.billing.entity.Feature;
import org.apache.ibatis.annotations.Param;

public interface FeatureMapper {
    Feature selectByMonth(@Param("uId") Long uId,@Param("fYear") String fYear,@Param("fMonth") String fMonth);

    int deleteByPrimaryKey(Long fId);

    int insert(Feature record);

    int insertSelective(Feature record);

    Feature selectByPrimaryKey(Long fId);

    int updateByPrimaryKeySelective(Feature record);

    int updateByPrimaryKey(Feature record);
}