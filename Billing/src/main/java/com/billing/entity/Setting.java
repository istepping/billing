package com.billing.entity;

public class Setting {

    private Long sId;

    private Long uId;

    private Integer uPrivate;

    private Long uFather;

    private Long uMother;

    private Integer uOpenFamily;

    private String sExtra;

    private Integer sState;
    public Setting() {
    }

    public Setting(Long sId, Long uId, Integer uPrivate, Long uFather, Long uMother, Integer uOpenFamily, String sExtra, Integer sState) {
        this.sId = sId;
        this.uId = uId;
        this.uPrivate = uPrivate;
        this.uFather = uFather;
        this.uMother = uMother;
        this.uOpenFamily = uOpenFamily;
        this.sExtra = sExtra;
        this.sState = sState;
    }

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Integer getuPrivate() {
        return uPrivate;
    }

    public void setuPrivate(Integer uPrivate) {
        this.uPrivate = uPrivate;
    }

    public Long getuFather() {
        return uFather;
    }

    public void setuFather(Long uFather) {
        this.uFather = uFather;
    }

    public Long getuMother() {
        return uMother;
    }

    public void setuMother(Long uMother) {
        this.uMother = uMother;
    }

    public Integer getuOpenFamily() {
        return uOpenFamily;
    }

    public void setuOpenFamily(Integer uOpenFamily) {
        this.uOpenFamily = uOpenFamily;
    }

    public String getsExtra() {
        return sExtra;
    }

    public void setsExtra(String sExtra) {
        this.sExtra = sExtra == null ? null : sExtra.trim();
    }

    public Integer getsState() {
        return sState;
    }

    public void setsState(Integer sState) {
        this.sState = sState;
    }
}