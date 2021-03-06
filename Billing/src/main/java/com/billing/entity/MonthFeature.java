package com.billing.entity;

public class MonthFeature {
    private Long fId;

    private Long uId;

    private String fYear;

    private String fMonth;

    private String fParam1;

    private String fParam2;

    private String fParam3;

    private String fParam4;

    private String fParam5;

    private String fParam6;

    private Integer fState;

    public MonthFeature() {
    }

    public MonthFeature(Long uId, String fYear, String fMonth, String fParam1, String fParam2, String fParam3, String fParam4, String fParam5, String fParam6) {
        this.uId = uId;
        this.fYear = fYear;
        this.fMonth = fMonth;
        this.fParam1 = fParam1;
        this.fParam2 = fParam2;
        this.fParam3 = fParam3;
        this.fParam4 = fParam4;
        this.fParam5 = fParam5;
        this.fParam6 = fParam6;
    }

    public MonthFeature(Long fId, Long uId, String fYear, String fMonth, String fParam1, String fParam2, String fParam3, String fParam4, String fParam5, String fParam6) {
        this.fId = fId;
        this.uId = uId;
        this.fYear = fYear;
        this.fMonth = fMonth;
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

    public String getfYear() {
        return fYear;
    }

    public void setfYear(String fYear) {
        this.fYear = fYear == null ? null : fYear.trim();
    }

    public String getfMonth() {
        return fMonth;
    }

    public void setfMonth(String fMonth) {
        this.fMonth = fMonth == null ? null : fMonth.trim();
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

    public Integer getfState() {
        return fState;
    }

    public void setfState(Integer fState) {
        this.fState = fState;
    }
}