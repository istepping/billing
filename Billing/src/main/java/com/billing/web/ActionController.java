package com.billing.web;

import com.billing.base.BaseController;
import com.billing.base.BaseService;
import com.billing.manager.UserMgr;
import com.billing.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sunLei on 2018/11/21 11:37
 * @version 1.0
 * @apiNote 信息查询
 */
@Controller
@RequestMapping("/action")
public class ActionController extends BaseController {
    @Autowired
    private ActionService actionService;
    //查询用户行为
    @RequestMapping("/getAction")
    @ResponseBody
    public Result getAction(){
        Long uId = UserMgr.getUId(getRequest().getHeader("authorization"));
        BaseService.ServiceResult result=actionService.getActionWithAlgo(uId);
        if(result.isSuccess()){
            return successResponse(result.getData());
        }else{
            return failResponse(result.getInfo());
        }
    }
}
