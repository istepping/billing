package com.billing.entity;

public class Feature {
    private Long fId;

    private Long uId;

    private String fParam1;

    private String fParam2;

    private String fParam3;

    private String fParam4;

    private String fParam5;

    private String fParam6;

    private String fParam7;

    private String fParam8;

    private String fParam9;

    private String fParam10;

    private String fParam11;

    public Feature() {
    }

    public Feature(Long fId, Long uId, String fParam1, String fParam2, String fParam3, String fParam4, String fParam5, String fParam6) {
        this.fId = fId;
        this.uId = uId;
        this.fParam1 = fParam1;
        this.fParam2 = fParam2;
        this.fParam3 = fParam3;
        this.fParam4 = fParam4;
        this.fParam5 = fParam5;
        this.fParam6 = fParam6;
    }

    public Feature(Long uId, String fParam1, String fParam2, String fParam3, String fParam4, String fParam5, String fParam6) {
        this.uId = uId;
        this.fParam1 = fParam1;
        this.fParam2 = fParam2;
        this.fParam3 = fParam3;
        this.fParam4 = fParam4;
        this.fParam5 = fParam5;
        this.fParam6 = fParam6;
    }

    public Long getfId() {
        return fId;
    }

    public void setfId(Long fId) {
        this.fId = fId;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getfParam1() {
        return fParam1;
    }

    public void setfParam1(String fParam1) {
        this.fParam1 = fParam1 == null ? null : fParam1.trim();
    }

    public String getfParam2() {
        return fParam2;
    }

    public void setfParam2(String fParam2) {
        this.fParam2 = fParam2 == null ? null : fParam2.trim();
    }

    public String getfParam3() {
        return fParam3;
    }

    public void setfParam3(String fParam3) {
        this.fParam3 = fParam3 == null ? null : fParam3.trim();
    }

    public String getfParam4() {
        return fParam4;
    }

    public void setfParam4(String fParam4) {
        this.fParam4 = fParam4 == null ? null : fParam4.trim();
    }

    public String getfParam5() {
        return fParam5;
    }

    public void setfParam5(String fParam5) {
        this.fParam5 = fParam5 == null ? null : fParam5.trim();
    }

    public String getfParam6() {
        return fParam6;
    }

    public void setfParam6(String fParam6) {
        this.fParam6 = fParam6 == null ? null : fParam6.trim();
    }

    public String getfParam7() {
        return fParam7;
    }

    public void setfParam7(String fParam7) {
        this.fParam7 = fParam7 == null ? null : fParam7.trim();
    }

    public String getfParam8() {
        return fParam8;
    }

    public void setfParam8(String fParam8) {
        this.fParam8 = fParam8 == null ? null : fParam8.trim();
    }

    public String getfParam9() {
        return fParam9;
    }

    public void setfParam9(String fParam9) {
        this.fParam9 = fParam9 == null ? null : fParam9.trim();
    }

    public String getfParam10() {
        return fParam10;
    }

    public void setfParam10(String fParam10) {
        this.fParam10 = fParam10 == null ? null : fParam10.trim();
    }

    public String getfParam11() {
        return fParam11;
    }

    public void setfParam11(String fParam11) {
        this.fParam11 = fParam11 == null ? null : fParam11.trim();
    }
}