package com.billing.service.impl;

import com.billing.base.BaseService;
import com.billing.dao.UserMapper;
import com.billing.entity.User;
import com.billing.manager.UserMgr;
import com.billing.service.UserService;
import com.billing.utils.API;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserServiceImpl extends BaseService implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public ServiceResult login(String code) {
        String grant_type="authorization_code";
        String url="https://api.weixin.qq.com/sns/jscode2session?" + "appid=" + AppID + "&secret=" + AppSecret
                + "&js_code=" + code + "&grant_type=" + grant_type;
        print("url="+url);
        JSONObject response= JSONObject.fromObject(API.INSTANCE.request(url));
        String session_key=(String) response.get("session_key");
        String openid=(String)response.get("openid");
        print("session_key="+session_key);
        print("openid="+openid);
        if(session_key ==null || openid == null){
            return fail("session未空");
        }
        //是否存在账户
        User user=userMapper.selectByWxId(openid);
        if(user==null){
            //创建新用户
            int result=userMapper.insertSelective(new User(openid));
            if (result<=0){
                return fail("新建账号失败");
            }else{
                user=userMapper.selectByWxId(openid);
            }
        }
        String token=UserMgr.login(user.getuId(),session_key,openid);
        return success();
    }
}
