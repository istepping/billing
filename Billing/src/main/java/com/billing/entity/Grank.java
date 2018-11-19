package com.billing.entity;

import java.util.Date;

public class Grank {
    private Long tId;

    private Integer tRank;

    private Integer tGradeno;

    private String tGrade;

    private Date tDate;

    public Long gettId() {
        return tId;
    }

    public void settId(Long tId) {
        this.tId = tId;
    }

    public Integer gettRank() {
        return tRank;
    }

    public void settRank(Integer tRank) {
        this.tRank = tRank;
    }

    public Integer gettGradeno() {
        return tGradeno;
    }

    public void settGradeno(Integer tGradeno) {
        this.tGradeno = tGradeno;
    }

    public String gettGrade() {
        return tGrade;
    }

    public void settGrade(String tGrade) {
        this.tGrade = tGrade == null ? null : tGrade.trim();
    }

    public Date gettDate() {
        return tDate;
    }

    public void settDate(Date tDate) {
        this.tDate = tDate;
    }
}