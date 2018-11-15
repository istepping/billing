package com.billing.service.impl;

import com.billing.dao.BillMapper;
import com.billing.entity.Bill;
import com.billing.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sunLei on 2018/11/14 19:57
 * @version 1.0
 */
@Transactional
@Service
public class BillServiceImpl implements BillService {
    @Autowired
    BillMapper billMapper;

    @Override
    public Bill getBillByBId(long bId) {
        return billMapper.selectByPrimaryKey(bId);
    }

    @Override
    public List<Bill> getBillList() {
        return billMapper.getBillList();
    }
}
