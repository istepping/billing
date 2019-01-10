package com.billing.entity;

public class Brand {
    private Long bId;

    private String bName;

    private String gType1;

    private String gType2;

    private String gType3;

    private String gType4;

    public Long getbId() {
        return bId;
    }

    public void setbId(Long bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName == null ? null : bName.trim();
    }

    public String getgType1() {
        return gType1;
    }

    public void setgType1(String gType1) {
        this.gType1 = gType1 == null ? null : gType1.trim();
    }

    public String getgType2() {
        return gType2;
    }

    public void setgType2(String gType2) {
        this.gType2 = gType2 == null ? null : gType2.trim();
    }

    public String getgType3() {
        return gType3;
    }

    public void setgType3(String gType3) {
        this.gType3 = gType3 == null ? null : gType3.trim();
    }

    public String getgType4() {
        return gType4;
    }

    public void setgType4(String gType4) {
        this.gType4 = gType4 == null ? null : gType4.trim();
    }
}