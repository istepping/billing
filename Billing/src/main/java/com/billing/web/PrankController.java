package com.billing.web;

import com.billing.base.BaseController;
import com.billing.base.BaseService;
import com.billing.manager.UserMgr;
import com.billing.service.PrankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sunLei on 2018/11/22 19:36
 * @version 1.0
 * @apiNote
 */
@Controller
@RequestMapping("/prank")
public class PrankController extends BaseController {
    @Autowired
    PrankService prankService;
    //按月获取排名页面信息
    @RequestMapping("/getPrankByMonth")
    @ResponseBody
    public Result getPrankByMonth(String year,String month){
        Long uId = UserMgr.getUId(getRequest().getHeader("authorization"));
        BaseService.ServiceResult result=prankService.getPrankByMonth(year,month,uId);
        if(result.isSuccess()){
            return successResponse(result.getData());
        }else{
            return failResponse(result.getInfo());
        }
    }
    //获取个人排名
    @RequestMapping("/getPrank")
    @ResponseBody
    public Result getPrank(String year,String month){
        Long uId = UserMgr.getUId(getRequest().getHeader("authorization"));
        BaseService.ServiceResult result=prankService.getPrank(year,month,uId);
        if(result.isSuccess()){
            return successResponse(result.getData());
        }else{
            return failResponse(result.getInfo());
        }
    }
    //获取前10名
    @RequestMapping("/getPre10Ranks")
    @ResponseBody
    public Result getPre10Ranks(String year,String month){
        BaseService.ServiceResult result=prankService.getPre10Ranks(year,month);
        if(result.isSuccess()){
            return successResponse(result.getData());
        }else{
            return failResponse(result.getInfo());
        }
    }
    //获取排名变化
    @RequestMapping("/getRankChange")
    @ResponseBody
    public Result getRankChange(){
        Long uId = UserMgr.getUId(getRequest().getHeader("authorization"));
        BaseService.ServiceResult result=prankService.getRankChange(uId);
        if(result.isSuccess()){
            return successResponse(result.getData());
        }else{
            return failResponse(result.getInfo());
        }
    }
}
