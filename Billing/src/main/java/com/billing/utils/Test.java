package com.billing.utils;

import com.billing.service.ActionService;
import com.billing.service.impl.ActionServiceImpl;

import java.util.Calendar;

import static com.billing.utils.Assist.print;

/**
 * @author sunLei on 2018/12/1 16:50
 * @version 1.0
 * @apiNote
 */
public class Test {
    public static void main(String[] args){
//        Calendar calendar=Calendar.getInstance();
//        print(calendar.get(Calendar.MONTH));
//        calendar.set(Calendar.DATE,1);
//        print(calendar.get(Calendar.MONTH));
//        calendar.roll(Calendar.DATE,-1);
//        int days=calendar.get(Calendar.DATE);
//        print(days);
//        print(calendar.get(Calendar.MONTH));
        Calendar calendar=Calendar.getInstance();
        print(calendar.get(Calendar.MONTH));
    }
}
