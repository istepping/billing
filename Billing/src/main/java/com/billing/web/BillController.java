package com.billing.web;

import com.billing.entity.Bill;
import com.billing.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author sunLei on 2018/11/14 20:18
 * @version 1.0
 */
@Controller
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private BillService billService;
    //添加账单
    public Bill getUserBill(long bId){
        return billService.getBillByBId(bId);
    }
    //获取账单列表
    @RequestMapping("/getBillList")
    @ResponseBody
    public List<Bill> getBillList(){
        return billService.getBillList();
    }
}
