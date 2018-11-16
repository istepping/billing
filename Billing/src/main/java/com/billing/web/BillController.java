package com.billing.web;

import com.billing.base.BaseControl;
import com.billing.entity.Bill;
import com.billing.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.billing.utils.Assist.print;


/**
 * @author sunLei on 2018/11/14 20:18
 * @version 1.0
 */
@Controller
@RequestMapping("/bill")
public class BillController extends BaseControl {
    @Autowired
    private BillService billService;
    //添加账单
    @RequestMapping("/addBill")
    @ResponseBody
    public Result addBill(@RequestBody Bill bill){
        print(bill.getbType());
        return failResponse();
    }
    //获取账单列表
    @RequestMapping("/getBillList")
    @ResponseBody
    public Result getBillList(){
        Map<String,Object> data=new HashMap<>();
        data.put("billList",billService.getBillList());
        return successResponse(data);
    }
}
