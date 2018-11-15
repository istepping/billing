package com.billing.dao;

import com.billing.entity.Bill;

import java.util.List;

public interface BillMapper {
    int deleteByPrimaryKey(Long bId);

    int insert(Bill record);

    int insertSelective(Bill record);

    Bill selectByPrimaryKey(Long bId);

    int updateByPrimaryKeySelective(Bill record);

    int updateByPrimaryKey(Bill record);

    List<Bill> getBillList();
}