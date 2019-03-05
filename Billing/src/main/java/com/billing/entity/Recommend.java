package com.billing.entity;

import java.math.BigDecimal;

public class Recommend {
    private Long rId;

    private String rName;

    private String rImg;

    private String rDescription;

    private BigDecimal rPrice;

    private String rBuyUrl;

    private String rReason;

    private String rType1;

    private String rType2;

    private Integer rState;

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }

    public String getrImg() {
        return rImg;
    }

    public void setrImg(String rImg) {
        this.rImg = rImg == null ? null : rImg.trim();
    }

    public String getrDescription() {
        return rDescription;
    }

    public void setrDescription(String rDescription) {
        this.rDescription = rDescription == null ? null : rDescription.trim();
    }

    public BigDecimal getrPrice() {
        return rPrice;
    }

    public void setrPrice(BigDecimal rPrice) {
        this.rPrice = rPrice;
    }

    public String getrBuyUrl() {
        return rBuyUrl;
    }

    public void setrBuyUrl(String rBuyUrl) {
        this.rBuyUrl = rBuyUrl == null ? null : rBuyUrl.trim();
    }

    public String getrReason() {
        return rReason;
    }

    public void setrReason(String rReason) {
        this.rReason = rReason == null ? null : rReason.trim();
    }

    public String getrType1() {
        return rType1;
    }

    public void setrType1(String rType1) {
        this.rType1 = rType1 == null ? null : rType1.trim();
    }

    public String getrType2() {
        return rType2;
    }

    public void setrType2(String rType2) {
        this.rType2 = rType2 == null ? null : rType2.trim();
    }

    public Integer getrState() {
        return rState;
    }

    public void setrState(Integer rState) {
        this.rState = rState;
    }
}