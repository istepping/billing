package com.billing.service;

import com.billing.base.BaseService;
import com.billing.dto.MonthExposeCountDto;
import com.billing.entity.Bill;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BillService {
    BaseService.ServiceResult addExtra(Long bId, Long uId, String extraInfo);

    BaseService.ServiceResult deleteBill(Long bId, Long uId);

    List<Bill> getBillList(Long uId);

    BaseService.ServiceResult getChildBills(Long uId);

    Bill getBillByBId(long bId);

    BaseService.ServiceResult addBillByUId(Bill bill);

    BaseService.ServiceResult getTypeBill(Long uId, String year, String month);

    BaseService.ServiceResult getDayBillByMonth(Long uId, String year, String month);

    BaseService.ServiceResult getBillsByMonth(String year, String month, String level, String type);

    BaseService.ServiceResult getMonthSumByYear(Long uId, String year);

    BaseService.ServiceResult getTypeSumByYear(Long uId, String year);

    //帮助行为分析获取月支出和信息
    List<MonthExposeCountDto> getMonthExposeForAction(Long uId);
}
