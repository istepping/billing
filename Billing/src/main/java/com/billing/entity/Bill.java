package com.billing.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Bill {
    private Long bId;

    private Long uId;

    private Date saveTime;

    private String bType;

    private BigDecimal money;

    private String gTypeid;

    private String gType;

    private Long gType2id;

    private String gType2;

    private Long gType3id;

    private String gType3;

    private Long gType4id;

    private String gType4;

    private String gDetail;

    private String location;

    private String extraInfo;

    private Integer state;
    public Bill() {
    }

    public Bill(Long bId, Long uId, Date saveTime, String bType, BigDecimal money, String gDetail, String location, String extraInfo) {
        this.bId = bId;
        this.uId = uId;
        this.saveTime = saveTime;
        this.bType = bType;
        this.money = money;
        this.gDetail = gDetail;
        this.location = location;
        this.extraInfo = extraInfo;
    }

    public Bill(Long uId, Date saveTime, String bType, BigDecimal money, String gType, String gType2, String gType3, String gType4, String gDetail, String location, String extraInfo) {
        this.uId = uId;
        this.saveTime = saveTime;
        this.bType = bType;
        this.money = money;
        this.gType = gType;
        this.gType2 = gType2;
        this.gType3 = gType3;
        this.gType4 = gType4;
        this.gDetail = gDetail;
        this.location = location;
        this.extraInfo = extraInfo;
    }

    public Bill(Long bId, Long uId, Date saveTime, String bType, BigDecimal money, String gTypeid, String gType, Long gType2id, String gType2, Long gType3id, String gType3, Long gType4id, String gType4, String gDetail, String location, String extraInfo, Integer state) {
        this.bId = bId;
        this.uId = uId;
        this.saveTime = saveTime;
        this.bType = bType;
        this.money = money;
        this.gTypeid = gTypeid;
        this.gType = gType;
        this.gType2id = gType2id;
        this.gType2 = gType2;
        this.gType3id = gType3id;
        this.gType3 = gType3;
        this.gType4id = gType4id;
        this.gType4 = gType4;
        this.gDetail = gDetail;
        this.location = location;
        this.extraInfo = extraInfo;
        this.state = state;
    }


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

    public String getgTypeid() {
        return gTypeid;
    }

    public void setgTypeid(String gTypeid) {
        this.gTypeid = gTypeid == null ? null : gTypeid.trim();
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