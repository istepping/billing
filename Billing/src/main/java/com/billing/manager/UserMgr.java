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
    /**<session,用户登陆信息>*/
    public static Map<String, LoginInfo> userMap=new HashMap<>();
    /**session有效时间*/
    public static final Long validTime=24*60*60*1000L;
    public static boolean isLogin(String session){
        if(userMap.containsKey(session)){
            Long nowTime=new Date().getTime();
            Long loginTime=userMap.get(session).getLoginTime();
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
        String session=String.valueOf(new Date().getTime());
        LoginInfo loginInfo=new LoginInfo();
        loginInfo.setuId(uId);
        loginInfo.setSessionKey(sessionKey);
        loginInfo.setOpenid(openId);
        loginInfo.setLoginTime(new Date().getTime());
        userMap.put(session,loginInfo);
        return session;
    }
}
