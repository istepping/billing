package com.billing.dao;

import com.billing.entity.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillMapper {
    List<Bill> selectByType4(@Param("time")String time,@Param("type")String type);

    List<Bill> selectByType3(@Param("time")String time,@Param("type")String type);

    List<Bill> selectByType2(@Param("time")String time,@Param("type")String type);

    List<Bill> selectByType(@Param("time")String time,@Param("type")String type);

    List<Bill> selectByMonth(@Param("uId") Long uId,@Param("time") String time);

    List<Bill> selectByUId(Long uId);

    int deleteByPrimaryKey(Long bId);

    int insert(Bill record);

    int insertSelective(Bill record);

    Bill selectByPrimaryKey(Long bId);

    int updateByPrimaryKeySelective(Bill record);

    int updateByPrimaryKey(Bill record);
}