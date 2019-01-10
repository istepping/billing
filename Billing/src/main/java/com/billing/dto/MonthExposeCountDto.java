package com.billing.dto;

import java.math.BigDecimal;

/**
 * @author sunLei on 2018/12/8 17:31
 * @version 1.0
 * @apiNote
 */
public class MonthExposeCountDto {
    private String year;
    private String month;
    private BigDecimal sumMoney;

    public MonthExposeCountDto() {
    }

    public MonthExposeCountDto(String year, String month, BigDecimal sumMoney) {
        this.year = year;
        this.month = month;
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

    public BigDecimal getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(BigDecimal sumMoney) {
        this.sumMoney = sumMoney;
    }
}
