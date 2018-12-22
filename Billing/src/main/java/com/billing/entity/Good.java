package com.billing.entity;

import java.math.BigDecimal;

public class Good {
    private Long gId;

    private Long gTypeid;

    private String gType;

    private Long gType2id;

    private String gType2;

    private Long gType3id;

    private String gType3;

    private Long gType4id;

    private String gType4;

    private String gName;

    private String gDetail;

    private Integer gSellNum;

    private String gLocation;

    private BigDecimal gAveprice;

    private Integer gGoodComment;

    private String gSellPercent;

    private String gPricePercent;

    private String gCommentPercent;

    private String gMultiplePercent;

    private String gExtra;

    private Integer gState;

    public Long getgId() {
        return gId;
    }

    public void setgId(Long gId) {
        this.gId = gId;
    }

    public Long getgTypeid() {
        return gTypeid;
    }

    public void setgTypeid(Long gTypeid) {
        this.gTypeid = gTypeid;
    }

    public String getgType() {
        return gType;
    }

    public void setgType(String gType) {
        this.gType = gType == null ? null : gType.trim();
    }

    public Long getgType2id() {
        return gType2id;
    }

    public void setgType2id(Long gType2id) {
        this.gType2id = gType2id;
    }

    public String getgType2() {
        return gType2;
    }

    public void setgType2(String gType2) {
        this.gType2 = gType2 == null ? null : gType2.trim();
    }

    public Long getgType3id() {
        return gType3id;
    }

    public void setgType3id(Long gType3id) {
        this.gType3id = gType3id;
    }

    public String getgType3() {
        return gType3;
    }

    public void setgType3(String gType3) {
        this.gType3 = gType3 == null ? null : gType3.trim();
    }

    public Long getgType4id() {
        return gType4id;
    }

    public void setgType4id(Long gType4id) {
        this.gType4id = gType4id;
    }

    public String getgType4() {
        return gType4;
    }

    public void setgType4(String gType4) {
        this.gType4 = gType4 == null ? null : gType4.trim();
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

    public String getgLocation() {
        return gLocation;
    }

    public void setgLocation(String gLocation) {
        this.gLocation = gLocation == null ? null : gLocation.trim();
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

    public String getgExtra() {
        return gExtra;
    }

    public void setgExtra(String gExtra) {
        this.gExtra = gExtra == null ? null : gExtra.trim();
    }

    public Integer getgState() {
        return gState;
    }

    public void setgState(Integer gState) {
        this.gState = gState;
    }
}