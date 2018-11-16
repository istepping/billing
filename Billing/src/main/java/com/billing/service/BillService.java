package com.billing.service;

import com.billing.entity.Bill;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BillService {
    List<Bill> getBillList();
    Bill getBillByBId(long bId);
    int addBillByUId(Bill bill);
}
