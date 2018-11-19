package com.billing.entity;

public class Action {
    private Long aId;

    private Long uId;

    private String aHabit;

    private String aCollection;

    private String aImagine;

    private String aReason;

    private String aImpluse;

    private String aRandom;

    public Long getaId() {
        return aId;
    }

    public void setaId(Long aId) {
        this.aId = aId;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getaHabit() {
        return aHabit;
    }

    public void setaHabit(String aHabit) {
        this.aHabit = aHabit == null ? null : aHabit.trim();
    }

    public String getaCollection() {
        return aCollection;
    }

    public void setaCollection(String aCollection) {
        this.aCollection = aCollection == null ? null : aCollection.trim();
    }

    public String getaImagine() {
        return aImagine;
    }

    public void setaImagine(String aImagine) {
        this.aImagine = aImagine == null ? null : aImagine.trim();
    }

    public String getaReason() {
        return aReason;
    }

    public void setaReason(String aReason) {
        this.aReason = aReason == null ? null : aReason.trim();
    }

    public String getaImpluse() {
        return aImpluse;
    }

    public void setaImpluse(String aImpluse) {
        this.aImpluse = aImpluse == null ? null : aImpluse.trim();
    }

    public String getaRandom() {
        return aRandom;
    }

    public void setaRandom(String aRandom) {
        this.aRandom = aRandom == null ? null : aRandom.trim();
    }
}