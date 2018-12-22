package com.billing.dao;

import com.billing.entity.Grank;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GrankMapper {
    List<Grank> selectByMonth(@Param("rYear") String rYear, @Param("rMonth") String rMonth);

    int deleteByPrimaryKey(Long rId);

    int insert(Grank record);

    int insertSelective(Grank record);

    Grank selectByPrimaryKey(Long rId);

    int updateByPrimaryKeySelective(Grank record);

    int updateByPrimaryKey(Grank record);
}