package com.billing.web;

import com.billing.base.BaseController;
import com.billing.base.BaseService;
import com.billing.entity.User;
import com.billing.manager.UserMgr;
import com.billing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunLei on 2018/11/17 15:26
 * @version 1.0
 * @apiNote 信息查询与录入
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    UserService userService;
    //获取用户信息
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public Result getUserInfo(){
        Long uId = UserMgr.getUId(getRequest().getHeader("authorization"));
        BaseService.ServiceResult result=userService.getUserInfo(uId);
        if(result.isSuccess()){
            return successResponse(result.getData());
        }else{
            return failResponse(result.getInfo());
        }
    }
    //修改用户信息
    @RequestMapping("/updateInfo")
    @ResponseBody
    public Result updateInfo(String uName,String uGender,String uPhone,String uEmail,String uCity,String uSchool,String uNo,String uGrade,String uClass,String uLocation){
        Long uId = UserMgr.getUId(getRequest().getHeader("authorization"));
        if (uId==null){
            return failResponse("未授权");
        }
        User user=new User(uId,uName,uGender,uPhone,uEmail,uCity,uSchool,uNo,uGrade,uClass,uLocation);
        BaseService.ServiceResult result=userService.addInfo(user);
        if(result.isSuccess()){
            return successResponse();
        }else{
            return failResponse(result.getInfo());
        }
    }
    //用户登陆
    @RequestMapping("/login")
    @ResponseBody
    public Result login(String code){
        if(code==null || code.length()==0) {
            return failResponse("code为空");
        }
        BaseService.ServiceResult result=userService.login(code);
        if(result.isSuccess()){
            Map<String,Object> token=new HashMap<>();
            token.put("token",result.getInfo());
            return successResponse(token);
        }else{
            return failResponse(result.getInfo());
        }
    }
}
