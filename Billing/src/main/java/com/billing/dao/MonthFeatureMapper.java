package com.billing.dao;

import com.billing.entity.MonthFeature;
import org.apache.ibatis.annotations.Param;

public interface MonthFeatureMapper {
    MonthFeature selectByMonth(@Param("uId") Long uId, @Param("fYear") String fYear, @Param("fMonth") String fMonth);

    int deleteByPrimaryKey(Long fId);

    int insert(MonthFeature record);

    int insertSelective(MonthFeature record);

    MonthFeature selectByPrimaryKey(Long fId);

    int updateByPrimaryKeySelective(MonthFeature record);

    int updateByPrimaryKey(MonthFeature record);
}