package com.billing.service.impl;

import com.billing.base.BaseService;
import com.billing.dao.UserInfoMapper;
import com.billing.entity.UserInfo;
import com.billing.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunLei on 2018/11/28 20:47
 * @version 1.0
 * @apiNote
 */
@Service
public class UserInfoServiceImpl extends BaseService implements UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;
    @Override
    public ServiceResult addUserInfo(UserInfo userInfo) {
        if(userInfo.getuId()==null){
            return fail("用户不能为空");
        }
        UserInfo userInfo1=userInfoMapper.selectByPrimaryKey(userInfo.getuId());
        if(userInfo1==null){
            int result=userInfoMapper.insert(userInfo);
            if(result>0){
                return success();
            }else{
                return failDataBase();
            }
        }else{
            int result=userInfoMapper.updateByPrimaryKey(userInfo);
            if(result>0){
                return success();
            }else{
                return failDataBase();
            }
        }
    }

    @Override
    public ServiceResult getUserInfo(Long uId) {
        UserInfo userInfo=userInfoMapper.selectByPrimaryKey(uId);
        Map<String,Object> data=new HashMap<>();
        data.put("userInfo",userInfo);
        return success(data);
    }
}
