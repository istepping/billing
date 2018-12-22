package com.billing.service.impl;

import com.billing.base.BaseService;
import com.billing.dao.SettingMapper;
import com.billing.entity.Setting;
import com.billing.entity.User;
import com.billing.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunLei on 2018/11/22 17:46
 * @version 1.0
 * @apiNote
 */
@Service
public class SettingServiceImpl extends BaseService implements SettingService {
    @Autowired
    SettingMapper settingMapper;
    @Override
    public ServiceResult setBillPrivate(Long uId, Integer content) {
        Setting setting =settingMapper.selectByUId(uId);
        Setting record=new Setting();
        record.setuPrivate(content);
        if(setting==null){
            //创建新设置表
            record.setuId(uId);
            int result=settingMapper.insert(record);
            if(result>0){
                return success();
            }else{
                return failDataBase();
            }
        }else{
            record.setsId(setting.getsId());
            int result2=settingMapper.updateByPrimaryKeySelective(record);
            if(result2>0){
                return success();
            }else{
                return failDataBase();
            }
        }
    }

    @Override
    public ServiceResult setOpenFamily(Long uId, Integer content) {
        Setting setting =settingMapper.selectByUId(uId);
        Setting record=new Setting();
        record.setuOpenFamily(content);
        if(setting==null){
            //创建新设置表
            record.setuId(uId);
            if(settingMapper.insert(record)>0){
                return success();
            }else{
                return failDataBase();
            }
        }else{
            record.setsId(setting.getsId());
            if(settingMapper.updateByPrimaryKeySelective(record)>0){
                return success();
            }else{
                return failDataBase();
            }
        }
    }

    @Override
    public ServiceResult setParentId(Long uId,Integer flag,Long parentId) {
        Setting setting=new Setting();
        setting.setuId(uId);
        if(flag==0){
            setting.setuMother(parentId);
        }else{
            setting.setuFather(parentId);
        }
        setting.setsId(settingMapper.selectByUId(uId).getsId());
        int result=settingMapper.updateByPrimaryKeySelective(setting);
        if(result>0){
            return success();
        }else{
            return failDataBase();
        }
    }

    @Override
    public ServiceResult getSetting(Long uId) {
        Setting setting=settingMapper.selectByUId(uId);
        Map<String,Object> data=new HashMap<>();
        data.put("setting",setting);
        return success(data);
    }
}
