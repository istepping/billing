package com.billing.dao;

import com.billing.entity.Good;

import java.util.List;

public interface GoodMapper {
    List<Good> selectByType4Id(Long gType4id);
    List<Good> selectByType3Id(Long gType3id);
    List<Good> selectByType2Id(Long gType2id);
    List<Good> selectByTypeId(Long gTypeid);
    int deleteByPrimaryKey(Long gId);

    int insert(Good record);

    int insertSelective(Good record);

    Good selectByPrimaryKey(Long gId);

    int updateByPrimaryKeySelective(Good record);

    int updateByPrimaryKey(Good record);
}