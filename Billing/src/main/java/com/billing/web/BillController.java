package com.billing.web;

import com.billing.base.BaseController;
import com.billing.base.BaseService;
import com.billing.entity.Bill;
import com.billing.manager.UserMgr;
import com.billing.service.BillService;
import com.billing.utils.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.billing.utils.Assist.logger;
import static com.billing.utils.Assist.print;


/**
 * @author sunLei on 2018/11/14 20:18
 * @version 1.0
 * @note 信息查询与录入
 */
@Controller
@RequestMapping("/bill")
public class BillController extends BaseController {
    @Autowired
    private BillService billService;
    //更新账单
    @RequestMapping("/updateBillById")
    @ResponseBody
    public Result updateBillById(String bId,String saveTime, String bType, String money, String gDetail, String location, String extraInfo){
        Long uId = UserMgr.getUId(getRequest().getHeader("authorization"));
        if(!Auth.isNumber(bId)){
            return failResponse("账单号不正确!");
        }
        Bill bill = new Bill();
        bill.setbId(Long.valueOf(bId));
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (saveTime != null) {
            try {
                Date date = format.parse(saveTime);
                bill.setSaveTime(date);
            } catch (Exception e) {
                e.printStackTrace();
                return failResponse("时间格式不正确!");
            }
        }
        if(bType!=null){
            bill.setbType(bType);
        }
        if(money!=null){
             bill.setMoney(new BigDecimal(money));
        }
        if(gDetail!=null){
            bill.setgDetail(gDetail);
        }
        if(location!=null){
            bill.setLocation(location);
        }
        if(extraInfo!=null){
            bill.setExtraInfo(extraInfo);
        }
        BaseService.ServiceResult result = billService.updateBillByBId(bill);
        if (result.isSuccess()) {
            return successResponse();
        } else {
            return failResponse(result.getInfo());
        }
    }
    //获取孩子账单
    //按年获取分类统计
    @RequestMapping("/getChildBills")
    @ResponseBody
    public Result getChildBills() {
        Long uId = UserMgr.getUId(getRequest().getHeader("authorization"));
        BaseService.ServiceResult result = billService.getChildBills(uId);
        if (result.isSuccess()) {
            return successResponse(result.getData());
        } else {
            return failResponse(result.getInfo());
        }
    }

    //按年获取分类统计
    @RequestMapping("/getTypeSumByYear")
    @ResponseBody
    public Result getTypeSumByYear(String year) {
        Long uId = UserMgr.getUId(getRequest().getHeader("authorization"));
        BaseService.ServiceResult result = billService.getTypeSumByYear(uId, year);
        if (result.isSuccess()) {
            return successResponse(result.getData());
        } else {
            return failResponse(result.getInfo());
        }
    }

    //按年获取每月统计
    @RequestMapping("/getMonthSumByYear")
    @ResponseBody
    public Result getMonthSumByYear(String year) {
        Long uId = UserMgr.getUId(getRequest().getHeader("authorization"));
        BaseService.ServiceResult result = billService.getMonthSumByYear(uId, year);
        if (result.isSuccess()) {
            return successResponse(result.getData());
        } else {
            return failResponse(result.getInfo());
        }
    }

    //获取月每天账单统计
    @RequestMapping("/getBillsByMonth")
    @ResponseBody
    public Result getBillsByMonth(String year, String month, String level, String type) {
        BaseService.ServiceResult result = billService.getBillsByMonth(year, month, level, type);
        if (result.isSuccess()) {
            return successResponse(result.getData());
        } else {
            return failResponse(result.getInfo());
        }
    }

    //获取月每天账单统计
    @RequestMapping("/getDayBillWithMonth")
    @ResponseBody
    public Result getDayBillWithMonth(String year, String month) {
        Long uId = UserMgr.getUId(getRequest().getHeader("authorization"));
        BaseService.ServiceResult result = billService.getDayBillByMonth(uId, year, month);
        if (result.isSuccess()) {
            return successResponse(result.getData());
        } else {
            return failResponse(result.getInfo());
        }
    }

    //获取个人账单月统计
    @RequestMapping("/getTypeBill")
    @ResponseBody
    public Result getTypeBill(String year, String month) {
        Long uId = UserMgr.getUId(getRequest().getHeader("authorization"));
        BaseService.ServiceResult result = billService.getTypeBill(uId, year, month);
        if (result.isSuccess()) {
            return successResponse(result.getData());
        } else {
            return failResponse(result.getInfo());
        }
    }

    //删除账单
    @RequestMapping("/deleteBill")
    @ResponseBody
    public Result deleteBill() {
        Long bId = Long.valueOf(getRequest().getParameter("bId"));
        Long uId = UserMgr.getUId(getRequest().getHeader("authorization"));
        if (billService.deleteBill(bId, uId).isSuccess()) {
            return successResponse();
        } else {
            return failResponse("操作失败");
        }

    }

    //添加账单备注
    @RequestMapping("/addExtra")
    @ResponseBody
    public Result addExtra(String bId, String extraInfo) {
        Long uId = UserMgr.getUId(getRequest().getHeader("authorization"));
        print("extraoInfo" + extraInfo);
        BaseService.ServiceResult result = billService.addExtra(Long.valueOf(bId), uId, extraInfo);
        if (result.isSuccess()) {
            return successResponse();
        } else {
            return failResponse(result.getInfo());
        }
    }

    //添加账单(含详细类型)
    @RequestMapping("/addBillWithTypes")
    @ResponseBody
    public Result addBillWithTypes(String saveTime, String bType, String money, String gType, String gType2,   String gType3, String gType4, String gDetail, String location, String extraInfo) {
        Long uId = UserMgr.getUId(getRequest().getHeader("authorization"));
        Bill bill = new Bill(uId, new Date(), bType, BigDecimal.valueOf(Integer.parseInt(money)), gType, gType2, gType3, gType4, gDetail, location, extraInfo);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (saveTime == null) {
            Date time = new Date();
            bill.setSaveTime(time);
        } else {
            try {
                Date date = format.parse(saveTime);
                bill.setSaveTime(date);
            } catch (Exception e) {
                e.printStackTrace();
                return failResponse("时间格式不正确");
            }
        }
        BaseService.ServiceResult result = billService.addBillByUId(bill);
        if (result.isSuccess()) {
            return successResponse();
        } else {
            return failResponse(result.getInfo());
        }
    }

    //添加账单
    @RequestMapping("/addBill")
    @ResponseBody
    public Result addBill(String saveTime, String bType, String money, String gType, String gDetail, String location, String extraInfo) {
        Long uId = UserMgr.getUId(getRequest().getHeader("authorization"));
        Bill bill = new Bill();
        bill.setuId(uId);
        bill.setbType(bType);
        bill.setExtraInfo(extraInfo);
        bill.setgDetail(gDetail);
        bill.setLocation(location);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        print(saveTime);
        if (saveTime == null) {
            bill.setSaveTime(new Date());
        } else {
            try {
                Date date = format.parse(saveTime);
                logger.debug(date.toString());
                bill.setSaveTime(date);
            } catch (ParseException e) {
                e.printStackTrace();
                return failResponse("时间格式不正确");
            }
        }
        bill.setMoney(BigDecimal.valueOf(Integer.parseInt(money)));
        bill.setgType(gType);
        BaseService.ServiceResult result = billService.addBillByUId(bill);
        if (result.isSuccess()) {
            return successResponse();
        } else {
            return failResponse(result.getInfo());
        }
    }

    //获取账单列表
    @RequestMapping("/getBillList")
    @ResponseBody
    public Result getBillList() {
        Long uId = UserMgr.getUId(getRequest().getHeader("authorization"));
        List<Bill> bills = billService.getBillList(uId);
        Map<String, Object> data = new HashMap<>();
        data.put("bill", bills);
        return successResponse(data);
    }
}
