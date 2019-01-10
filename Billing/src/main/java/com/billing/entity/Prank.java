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

    private Integer rScore1;

    private Integer rScore2;

    private Integer rScore3;

    private Integer rScore4;

    private Integer rScore5;

    private Integer rScore6;

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

    public Integer getrScore1() {
        return rScore1;
    }

    public void setrScore1(Integer rScore1) {
        this.rScore1 = rScore1;
    }

    public Integer getrScore2() {
        return rScore2;
    }

    public void setrScore2(Integer rScore2) {
        this.rScore2 = rScore2;
    }

    public Integer getrScore3() {
        return rScore3;
    }

    public void setrScore3(Integer rScore3) {
        this.rScore3 = rScore3;
    }

    public Integer getrScore4() {
        return rScore4;
    }

    public void setrScore4(Integer rScore4) {
        this.rScore4 = rScore4;
    }

    public Integer getrScore5() {
        return rScore5;
    }

    public void setrScore5(Integer rScore5) {
        this.rScore5 = rScore5;
    }

    public Integer getrScore6() {
        return rScore6;
    }

    public void setrScore6(Integer rScore6) {
        this.rScore6 = rScore6;
    }
}