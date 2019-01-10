package com.billing.dao;

import com.billing.entity.Prank;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrankMapper {
    List<Prank> selectAllByMonth(@Param("rYear")String rYear,@Param("rMonth")String rMonth);
    List<Prank> selectPre10(@Param("rYear") String rYear,@Param("rMonth") String rMonth);
    List<Prank> selectByMonth(@Param("rYear") String rYear,@Param("rMonth") String rMonth,@Param("uId")Long uId);
    int deleteByPrimaryKey(Long rId);
    int insert(Prank record);

    int insertSelective(Prank record);

    Prank selectByPrimaryKey(Long rId);

    int updateByPrimaryKeySelective(Prank record);

    int updateByPrimaryKey(Prank record);
}