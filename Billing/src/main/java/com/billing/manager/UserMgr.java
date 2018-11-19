package com.billing.manager;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunLei on 2018/11/17 18:24
 * @version 1.0
 * @apiNote
 */
public class UserMgr {
    /**<token,用户登陆信息>*/
    public static Map<String, LoginInfo> userMap=new HashMap<>();
    /**token有效时间*/
    public static final Long validTime=24*60*60*1000L;
    public static Long getUId(String token){
        //开发人员验证
        if (token.equals("8888")){
            return 1000L;
        }
        return userMap.get(token).getuId();
    }
    public static boolean isLogin(String token){
        //开发人员验证
        if (token.equals("8888")){
            return true;
        }
        //开发人员认证结束
        if(userMap.containsKey(token)){
            Long nowTime=new Date().getTime();
            Long loginTime=userMap.get(token).getLoginTime();
            if(nowTime-loginTime<validTime){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    public static String login(Long uId,String sessionKey,String openId){
        String token=String.valueOf(new Date().getTime());
        LoginInfo loginInfo=new LoginInfo();
        loginInfo.setuId(uId);
        loginInfo.setSessionKey(sessionKey);
        loginInfo.setOpenid(openId);
        loginInfo.setLoginTime(new Date().getTime());
        userMap.put(token,loginInfo);
        return token;
    }
}
