package com.billing.service.impl;

import com.billing.base.BaseService;
import com.billing.dao.BillMapper;
import com.billing.dao.UserMapper;
import com.billing.entity.Bill;
import com.billing.entity.User;
import com.billing.manager.UserMgr;
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
public class BillServiceImpl extends BaseService implements BillService {
    @Autowired
    BillMapper billMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public ServiceResult deleteBill(Long bId, Long uId) {
        Bill bill=billMapper.selectByPrimaryKey(bId);
        if (bill.getuId().equals(uId)){
            if (billMapper.deleteByPrimaryKey(bId)>0){
                return success();
            }
        }
        return fail();
    }

    @Override
    public ServiceResult addBillByUId(Bill bill) {
        if(billMapper.insert(bill)>0){
         return success();
        }else{
            return fail();
        }
    }

    @Override
    public Bill getBillByBId(long bId) {
        return billMapper.selectByPrimaryKey(bId);
    }

    @Override
    public List<Bill> getBillList(Long uId) {
        return billMapper.selectByUId(uId);
    }
}
