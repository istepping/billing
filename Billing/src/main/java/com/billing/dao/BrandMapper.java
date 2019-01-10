package com.billing.dao;

import com.billing.entity.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
    List<Brand> selectByType(@Param("type1") String type1, @Param("type2") String type2, @Param("type3") String type3);

    List<Brand> selectAll();

    int deleteByPrimaryKey(Long bId);

    int insert(Brand record);

    int insertSelective(Brand record);

    Brand selectByPrimaryKey(Long bId);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);
}