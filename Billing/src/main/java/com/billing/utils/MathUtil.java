package com.billing.utils;

/**
 * @author sunLei on 2018/12/22 20:55
 * @version 1.0
 * @apiNote
 */
public enum MathUtil {
    INSTANCE;
    public Float getScore(String feature, float keyValue) {
        float temp = Math.abs(Float.valueOf(feature) - keyValue);
        return Float.valueOf(String.valueOf(100 - temp * 100));
    }
}
