package com.billing.web;

import com.billing.base.BaseControl;
import com.billing.base.BaseService;
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
 * @apiNote
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseControl {
    @Autowired
    UserService userService;
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
            return failResponse("登陆失败");
        }
    }
}
