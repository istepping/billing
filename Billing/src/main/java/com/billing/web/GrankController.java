package com.billing.web;

import com.billing.base.BaseController;
import com.billing.base.BaseService;
import com.billing.service.GrankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sunLei on 2018/11/22 19:31
 * @version 1.0
 * @apiNote
 */
@Controller
@RequestMapping("/grank")
public class GrankController extends BaseController {
    @Autowired
    GrankService grankService;
    //获取年纪排名
    @RequestMapping("/getGrank")
    @ResponseBody
    public Result getGrank(String year,String month){
        BaseService.ServiceResult result=grankService.getGrank(year,month);
        if(result.isSuccess()){
            return successResponse(result.getData());
        }else{
            return failResponse(result.getInfo());
        }
    }
}
