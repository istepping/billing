package com.billing.utils;

/**
 * @author sunLei on 2018/11/22 15:55
 * @version 1.0
 * @apiNote
 */
public class Auth {
    public static boolean isEmptyOrNull(String val){
        return val==null || val.equals("");
    }
    public static boolean isNumber(String val){
        if(val==null){
            return false;
        }
        return val.matches("^\\d+$");
    }
    //测试
    public static void main(String[] args){
        System.out.print(isNumber("123"));
    }
}
