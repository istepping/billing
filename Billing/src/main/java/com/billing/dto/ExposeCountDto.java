package com.billing.dto;

import java.math.BigDecimal;

/**
 * @author sunLei on 2018/12/1 16:08
 * @version 1.0
 * @apiNote
 */
public class ExposeCountDto {
    private String year;
    private String month;
    private Long typeId;
    private String type;
    private BigDecimal sumMoney;

    public ExposeCountDto() {
    }

    public ExposeCountDto(String year, Long typeId, String type, BigDecimal sumMoney) {
        this.year = year;
        this.typeId = typeId;
        this.type = type;
        this.sumMoney = sumMoney;
    }

    public ExposeCountDto(String year, String month, Long typeId, String type, BigDecimal sumMoney) {
        this.year = year;
        this.month = month;
        this.typeId = typeId;
        this.type = type;
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

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(BigDecimal sumMoney) {
        this.sumMoney = sumMoney;
    }
}
