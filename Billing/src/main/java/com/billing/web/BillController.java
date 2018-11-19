package com.billing.web;

import com.billing.base.BaseControl;
import com.billing.entity.Bill;
import com.billing.manager.UserMgr;
import com.billing.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * @author sunLei on 2018/11/14 20:18
 * @version 1.0
 */
@Controller
@RequestMapping("/bill")
public class BillController extends BaseControl {
    @Autowired
    private BillService billService;

    //删除账单
    @RequestMapping("/deleteBill")
    @ResponseBody
    public Result deleteBill(){
        if(UserMgr.isLogin(getRequest().getHeader("authorization"))){
            Long bId=Long.valueOf(getRequest().getParameter("bId"));
            Long uId= UserMgr.getUId(getRequest().getHeader("authorization"));
            if(billService.deleteBill(bId,uId).isSuccess()){
                return successResponse();
            }else{
                return failResponse("操作失败");
            }
        }else{
            return failResponse("授权失败");
        }
    }
    //添加账单
    @RequestMapping("/addBill")
    @ResponseBody
    public Result addBill(String saveTime,String bType,String money,String gType,String gDetail,String location,String extraInfo){
        if(UserMgr.isLogin(getRequest().getHeader("authorization"))){
            Long uId= UserMgr.getUId(getRequest().getHeader("authorization"));
            Bill bill=new Bill();
            bill.setbType(bType);
            bill.setExtraInfo(extraInfo);
            bill.setgDetail(gDetail);
            bill.setLocation(location);
            DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try{
                bill.setSaveTime(dateFormat.parse(saveTime));
            }catch (Exception e){
                e.printStackTrace();
            }
            bill.setMoney(BigDecimal.valueOf(Integer.parseInt(money)));
            bill.setgType(gType);
            if(billService.addBillByUId(bill).isSuccess()){
                return successResponse();
            }else{
                return failResponse();
            }
        }else{
            return failResponse("授权失败");
        }
    }
    //获取账单列表
    @RequestMapping("/getBillList")
    @ResponseBody
    public Result getBillList(){
        String token=getRequest().getHeader("authorization");
        if (token==null){
            return failResponse("authorization不能为空");
        }
        if(UserMgr.isLogin(token)){
            Long uId= UserMgr.getUId(token);
            List<Bill> bills=billService.getBillList(uId);
            Map<String,Object> data=new HashMap<>();
            data.put("bill",bills);
            return successResponse(data);
        }else{
            return failResponse("授权失败");
        }
    }
}
