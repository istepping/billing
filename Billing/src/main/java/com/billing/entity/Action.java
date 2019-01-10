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

    private String aExtra;

    private Integer aState;
    public Action() {
    }

    public Action(Long uId, String aHabit, String aCollection, String aImagine, String aReason, String aImpluse, String aRandom) {
        this.uId = uId;
        this.aHabit = aHabit;
        this.aCollection = aCollection;
        this.aImagine = aImagine;
        this.aReason = aReason;
        this.aImpluse = aImpluse;
        this.aRandom = aRandom;
    }

    public Action(Long aId, Long uId, String aHabit, String aCollection, String aImagine, String aReason, String aImpluse, String aRandom, String aExtra, Integer aState) {
        this.aId = aId;
        this.uId = uId;
        this.aHabit = aHabit;
        this.aCollection = aCollection;
        this.aImagine = aImagine;
        this.aReason = aReason;
        this.aImpluse = aImpluse;
        this.aRandom = aRandom;
        this.aExtra = aExtra;
        this.aState = aState;
    }

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

    public String getaExtra() {
        return aExtra;
    }

    public void setaExtra(String aExtra) {
        this.aExtra = aExtra == null ? null : aExtra.trim();
    }

    public Integer getaState() {
        return aState;
    }

    public void setaState(Integer aState) {
        this.aState = aState;
    }
}