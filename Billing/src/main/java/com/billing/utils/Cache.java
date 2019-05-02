package com.billing.utils;

import com.billing.dto.PersonRankDto;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sunLei on 2019/5/2 23:17
 * @version 1.0
 */
public class Cache {
    public static Map<String, List<PersonRankDto>> personRankDtoMap=new ConcurrentHashMap<>();
}
