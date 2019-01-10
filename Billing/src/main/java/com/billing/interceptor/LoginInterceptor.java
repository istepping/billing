package com.billing.interceptor;

import com.billing.base.BaseController;
import com.billing.manager.UserMgr;
import net.sf.json.JSONObject;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author sunLei on 2018/11/20 20:24
 * @version 1.0
 * @apiNote
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token=request.getHeader("authorization");
        if(UserMgr.isLogin(token)){
            return true;
        }else{
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out=response.getWriter();
            BaseController.Result responseResult=new BaseController.Result();
            responseResult.setStatusCode(0);
            responseResult.setMessage("unAuthorization");
            out.print(JSONObject.fromObject(responseResult));
            return false;
        }
    }
}
