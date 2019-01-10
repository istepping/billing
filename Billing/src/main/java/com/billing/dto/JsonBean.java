package com.billing.dto;

/**
 * @author sunLei on 2018/12/22 16:10
 * @version 1.0
 * @apiNote
 */
public class JsonBean {
    private String aReason;
    private String aImpluse;
    private String aRandom;
    private String aHabit;
    private String aCollection;
    private String aImagine;

    public JsonBean() {
    }

    public JsonBean(String aReason, String aImpluse, String aRandom, String aHabit, String aCollection, String aImagine) {
        this.aReason = aReason;
        this.aImpluse = aImpluse;
        this.aRandom = aRandom;
        this.aHabit = aHabit;
        this.aCollection = aCollection;
        this.aImagine = aImagine;
    }

    public String getaReason() {
        return aReason;
    }

    public void setaReason(String aReason) {
        this.aReason = aReason;
    }

    public String getaImpluse() {
        return aImpluse;
    }

    public void setaImpluse(String aImpluse) {
        this.aImpluse = aImpluse;
    }

    public String getaRandom() {
        return aRandom;
    }

    public void setaRandom(String aRandom) {
        this.aRandom = aRandom;
    }

    public String getaHabit() {
        return aHabit;
    }

    public void setaHabit(String aHabit) {
        this.aHabit = aHabit;
    }

    public String getaCollection() {
        return aCollection;
    }

    public void setaCollection(String aCollection) {
        this.aCollection = aCollection;
    }

    public String getaImagine() {
        return aImagine;
    }

    public void setaImagine(String aImagine) {
        this.aImagine = aImagine;
    }
}
