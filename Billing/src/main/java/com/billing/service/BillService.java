package com.billing.service;

import com.billing.base.BaseService;
import com.billing.entity.Bill;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BillService {
    BaseService.ServiceResult deleteBill(Long bId, Long uId);
    List<Bill> getBillList(Long uId);
    Bill getBillByBId(long bId);
    BaseService.ServiceResult addBillByUId(Bill bill);
}
