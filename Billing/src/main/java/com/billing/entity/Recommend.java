package com.billing.entity;

import java.math.BigDecimal;

public class Recommend {
    private Long rId;

    private String rType;

    private String rBrand;

    private String rName;

    private String rLike;

    private Integer rBuynum;

    private BigDecimal rPrice;

    private String rImg;

    private String rDesription;

    private String rReason;

    private Integer rState;

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    public String getrType() {
        return rType;
    }

    public void setrType(String rType) {
        this.rType = rType == null ? null : rType.trim();
    }

    public String getrBrand() {
        return rBrand;
    }

    public void setrBrand(String rBrand) {
        this.rBrand = rBrand == null ? null : rBrand.trim();
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }

    public String getrLike() {
        return rLike;
    }

    public void setrLike(String rLike) {
        this.rLike = rLike == null ? null : rLike.trim();
    }

    public Integer getrBuynum() {
        return rBuynum;
    }

    public void setrBuynum(Integer rBuynum) {
        this.rBuynum = rBuynum;
    }

    public BigDecimal getrPrice() {
        return rPrice;
    }

    public void setrPrice(BigDecimal rPrice) {
        this.rPrice = rPrice;
    }

    public String getrImg() {
        return rImg;
    }

    public void setrImg(String rImg) {
        this.rImg = rImg == null ? null : rImg.trim();
    }

    public String getrDesription() {
        return rDesription;
    }

    public void setrDesription(String rDesription) {
        this.rDesription = rDesription == null ? null : rDesription.trim();
    }

    public String getrReason() {
        return rReason;
    }

    public void setrReason(String rReason) {
        this.rReason = rReason == null ? null : rReason.trim();
    }

    public Integer getrState() {
        return rState;
    }

    public void setrState(Integer rState) {
        this.rState = rState;
    }
}