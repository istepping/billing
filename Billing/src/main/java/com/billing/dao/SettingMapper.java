package com.billing.dao;

import com.billing.entity.Setting;

import java.util.List;

public interface SettingMapper {

    List<Setting> selectByMIdOrFId(Long uId);

    Setting selectByUId(Long uId);

    int deleteByPrimaryKey(Long sId);

    int insert(Setting record);

    int insertSelective(Setting record);

    Setting selectByPrimaryKey(Long sId);

    int updateByPrimaryKeySelective(Setting record);

    int updateByPrimaryKey(Setting record);
}