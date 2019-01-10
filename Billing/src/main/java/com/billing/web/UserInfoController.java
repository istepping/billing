package com.billing.web;

import com.billing.base.BaseController;
import com.billing.base.BaseService;
import com.billing.entity.UserInfo;
import com.billing.manager.UserMgr;
import com.billing.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sunLei on 2018/11/28 20:52
 * @version 1.0
 * @apiNote
 */
@Controller
@RequestMapping("/userInfo")
public class UserInfoController extends BaseController {
    @Autowired
    UserInfoService userInfoService;
    @RequestMapping("/addUserInfo")
    @ResponseBody
    public Result addUserInfo(String avatarUrl,String city,String country,String gender,String language,String nickName,String province){
        Long uId = UserMgr.getUId(getRequest().getHeader("authorization"));
        BaseService.ServiceResult result=userInfoService.addUserInfo(new UserInfo(uId,avatarUrl,city,country,gender,language,nickName,province));
        if(result.isSuccess()){
            return successResponse();
        }else{
            return failResponse(result.getInfo());
        }
    }
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public Result getUserInfo(){
        Long uId = UserMgr.getUId(getRequest().getHeader("authorization"));
        BaseService.ServiceResult result=userInfoService.getUserInfo(uId);
        if(result.isSuccess()){
            return successResponse(result.getData());
        }else{
            return failResponse(result.getInfo());
        }
    }
}
