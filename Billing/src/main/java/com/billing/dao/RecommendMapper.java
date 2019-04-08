package com.billing.dao;

import com.billing.entity.Recommend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecommendMapper {
    Recommend selectByTypeAndNameAndBrand(@Param("rType")String rType,@Param("rName")String name,@Param("rBrand")String rBrand);

    List<Recommend> selectByLikeName(@Param("rName")String rName);

    List<Recommend> selectByTypeAndBrand(@Param("rType")String rType,@Param("rBrand")String rBrand);

    List<Recommend> selectList();

    int deleteByPrimaryKey(Long rId);

    int insert(Recommend record);

    int insertSelective(Recommend record);

    Recommend selectByPrimaryKey(Long rId);

    int updateByPrimaryKeySelective(Recommend record);

    int updateByPrimaryKey(Recommend record);
}