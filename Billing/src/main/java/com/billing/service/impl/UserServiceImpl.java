package com.billing.service.impl;

import com.billing.service.UserService;
import com.billing.utils.API;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.billing.utils.Assist.print;
import static com.billing.utils.Config.AppID;
import static com.billing.utils.Config.AppSecret;

/**
 * @author sunLei on 2018/11/17 15:19
 * @version 1.0
 * @apiNote
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Override
    public boolean login(String code) {
        String grant_type="authorization_code";
        String url="https://api.weixin.qq.com/sns/jscode2session?" + "appid=" + AppID + "&secret=" + AppSecret
                + "&js_code=" + code + "&grant_type=" + grant_type;
        print("url="+url);
        JSONObject response= JSONObject.fromObject(API.INSTANCE.request(url));
        String session_key=(String) response.get("session_key");
        String openid=(String)response.get("openid");
        print("session_key="+session_key);
        return false;
    }
}
