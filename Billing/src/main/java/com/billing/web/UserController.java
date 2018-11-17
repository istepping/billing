package com.billing.web;

import com.billing.base.BaseControl;
import com.billing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        if(userService.login(code)){
            return successResponse();
        }else{
            return failResponse("登陆失败");
        }
    }
}
