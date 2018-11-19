package com.billing.entity;

import java.math.BigDecimal;

public class Good {
    private Integer gId;

    private String gType;

    private String gName;

    private String gDetail;

    private Integer gSellNum;

    private BigDecimal gAveprice;

    private Integer gGoodComment;

    private String gSellPercent;

    private String gPricePercent;

    private String gCommentPercent;

    private String gMultiplePercent;

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public String getgType() {
        return gType;
    }

    public void setgType(String gType) {
        this.gType = gType == null ? null : gType.trim();
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName == null ? null : gName.trim();
    }

    public String getgDetail() {
        return gDetail;
    }

    public void setgDetail(String gDetail) {
        this.gDetail = gDetail == null ? null : gDetail.trim();
    }

    public Integer getgSellNum() {
        return gSellNum;
    }

    public void setgSellNum(Integer gSellNum) {
        this.gSellNum = gSellNum;
    }

    public BigDecimal getgAveprice() {
        return gAveprice;
    }

    public void setgAveprice(BigDecimal gAveprice) {
        this.gAveprice = gAveprice;
    }

    public Integer getgGoodComment() {
        return gGoodComment;
    }

    public void setgGoodComment(Integer gGoodComment) {
        this.gGoodComment = gGoodComment;
    }

    public String getgSellPercent() {
        return gSellPercent;
    }

    public void setgSellPercent(String gSellPercent) {
        this.gSellPercent = gSellPercent == null ? null : gSellPercent.trim();
    }

    public String getgPricePercent() {
        return gPricePercent;
    }

    public void setgPricePercent(String gPricePercent) {
        this.gPricePercent = gPricePercent == null ? null : gPricePercent.trim();
    }

    public String getgCommentPercent() {
        return gCommentPercent;
    }

    public void setgCommentPercent(String gCommentPercent) {
        this.gCommentPercent = gCommentPercent == null ? null : gCommentPercent.trim();
    }

    public String getgMultiplePercent() {
        return gMultiplePercent;
    }

    public void setgMultiplePercent(String gMultiplePercent) {
        this.gMultiplePercent = gMultiplePercent == null ? null : gMultiplePercent.trim();
    }
}