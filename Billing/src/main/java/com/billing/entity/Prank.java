package com.billing.entity;

import java.util.Date;

public class Prank {
    private Long rId;

    private Date rDate;

    private String rYear;

    private String rMonth;

    private String rWeek;

    private String rDay;

    private Integer rRank;

    private Long uId;

    private Integer rScore;

    private String rExtra;

    private Integer rState;

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    public Date getrDate() {
        return rDate;
    }

    public void setrDate(Date rDate) {
        this.rDate = rDate;
    }

    public String getrYear() {
        return rYear;
    }

    public void setrYear(String rYear) {
        this.rYear = rYear == null ? null : rYear.trim();
    }

    public String getrMonth() {
        return rMonth;
    }

    public void setrMonth(String rMonth) {
        this.rMonth = rMonth == null ? null : rMonth.trim();
    }

    public String getrWeek() {
        return rWeek;
    }

    public void setrWeek(String rWeek) {
        this.rWeek = rWeek == null ? null : rWeek.trim();
    }

    public String getrDay() {
        return rDay;
    }

    public void setrDay(String rDay) {
        this.rDay = rDay == null ? null : rDay.trim();
    }

    public Integer getrRank() {
        return rRank;
    }

    public void setrRank(Integer rRank) {
        this.rRank = rRank;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Integer getrScore() {
        return rScore;
    }

    public void setrScore(Integer rScore) {
        this.rScore = rScore;
    }

    public String getrExtra() {
        return rExtra;
    }

    public void setrExtra(String rExtra) {
        this.rExtra = rExtra == null ? null : rExtra.trim();
    }

    public Integer getrState() {
        return rState;
    }

    public void setrState(Integer rState) {
        this.rState = rState;
    }
}