package com.billing.dao;

import com.billing.entity.Setting;

public interface SettingMapper {
    int deleteByPrimaryKey(Long sId);

    int insert(Setting record);

    int insertSelective(Setting record);

    Setting selectByPrimaryKey(Long sId);

    int updateByPrimaryKeySelective(Setting record);

    int updateByPrimaryKey(Setting record);
}