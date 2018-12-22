package com.billing.dto;

import java.math.BigDecimal;

/**
 * @author sunLei on 2018/12/1 16:44
 * @version 1.0
 * @apiNote
 */
public class DayExposeCountDto {
    private String year;
    private String month;
    private String day;
    private BigDecimal sumMoney;

    public DayExposeCountDto() {
    }

    public DayExposeCountDto(String year, String month, String day, BigDecimal sumMoney) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.sumMoney = sumMoney;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public BigDecimal getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(BigDecimal sumMoney) {
        this.sumMoney = sumMoney;
    }
}
