package com.billing.manager;

/**
 * @author sunLei on 2018/11/17 18:33
 * @version 1.0
 * @apiNote
 */
public class LoginInfo {
    private Long uId;
    private Long loginTime;
    private String openid;
    private String sessionKey;
    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
}
