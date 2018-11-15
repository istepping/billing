package com.billing.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Bill {
    private Long bId;

    private Long uId;

    private Date saveTime;

    private String bType;

    private BigDecimal money;

    private String gType;

    private String gDetail;

    private String location;

    private String extraInfo;

    private Integer state;

    public Long getbId() {
        return bId;
    }

    public void setbId(Long bId) {
        this.bId = bId;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Date getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(Date saveTime) {
        this.saveTime = saveTime;
    }

    public String getbType() {
        return bType;
    }

    public void setbType(String bType) {
        this.bType = bType == null ? null : bType.trim();
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getgType() {
        return gType;
    }

    public void setgType(String gType) {
        this.gType = gType == null ? null : gType.trim();
    }

    public String getgDetail() {
        return gDetail;
    }

    public void setgDetail(String gDetail) {
        this.gDetail = gDetail == null ? null : gDetail.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo == null ? null : extraInfo.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}