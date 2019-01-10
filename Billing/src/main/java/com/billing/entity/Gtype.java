package com.billing.entity;

public class Gtype {
    private Long tId;

    private String tName;

    private Long tPtypeid;

    private String tPtypename;

    private String tBelong;

    private String tExtra;

    private Integer tState;

    public Long gettId() {
        return tId;
    }

    public void settId(Long tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName == null ? null : tName.trim();
    }

    public Long gettPtypeid() {
        return tPtypeid;
    }

    public void settPtypeid(Long tPtypeid) {
        this.tPtypeid = tPtypeid;
    }

    public String gettPtypename() {
        return tPtypename;
    }

    public void settPtypename(String tPtypename) {
        this.tPtypename = tPtypename == null ? null : tPtypename.trim();
    }

    public String gettBelong() {
        return tBelong;
    }

    public void settBelong(String tBelong) {
        this.tBelong = tBelong == null ? null : tBelong.trim();
    }

    public String gettExtra() {
        return tExtra;
    }

    public void settExtra(String tExtra) {
        this.tExtra = tExtra == null ? null : tExtra.trim();
    }

    public Integer gettState() {
        return tState;
    }

    public void settState(Integer tState) {
        this.tState = tState;
    }
}