package com.billing.entity;

public class User {
    private Long uId;

    private String wxId;

    private String uName;

    private String uGender;

    private String uPhone;

    private String uEmail;

    private String uCity;

    private String uSchool;

    private String uNo;

    private String uGrade;

    private String uClass;

    private String uLocation;

    private String uExtra;

    private Integer uState;
    public User() {
    }

    public User(String wxId) {
        this.wxId = wxId;
    }

    public User(Long uId, String uName, String uGender, String uPhone, String uEmail, String uCity, String uSchool, String uNo, String uGrade, String uClass, String uLocation) {
        this.uId = uId;
        this.uName = uName;
        this.uGender = uGender;
        this.uPhone = uPhone;
        this.uEmail = uEmail;
        this.uCity = uCity;
        this.uSchool = uSchool;
        this.uNo = uNo;
        this.uGrade = uGrade;
        this.uClass = uClass;
        this.uLocation = uLocation;
    }

    public User(Long uId, String wxId, String uName, String uGender, String uPhone, String uEmail, String uCity, String uSchool, String uNo, String uGrade, String uClass, String uLocation, String uExtra, Integer uState) {
        this.uId = uId;
        this.wxId = wxId;
        this.uName = uName;
        this.uGender = uGender;
        this.uPhone = uPhone;
        this.uEmail = uEmail;
        this.uCity = uCity;
        this.uSchool = uSchool;
        this.uNo = uNo;
        this.uGrade = uGrade;
        this.uClass = uClass;
        this.uLocation = uLocation;
        this.uExtra = uExtra;
        this.uState = uState;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getWxId() {
        return wxId;
    }

    public void setWxId(String wxId) {
        this.wxId = wxId == null ? null : wxId.trim();
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getuGender() {
        return uGender;
    }

    public void setuGender(String uGender) {
        this.uGender = uGender == null ? null : uGender.trim();
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone == null ? null : uPhone.trim();
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail == null ? null : uEmail.trim();
    }

    public String getuCity() {
        return uCity;
    }

    public void setuCity(String uCity) {
        this.uCity = uCity == null ? null : uCity.trim();
    }

    public String getuSchool() {
        return uSchool;
    }

    public void setuSchool(String uSchool) {
        this.uSchool = uSchool == null ? null : uSchool.trim();
    }

    public String getuNo() {
        return uNo;
    }

    public void setuNo(String uNo) {
        this.uNo = uNo == null ? null : uNo.trim();
    }

    public String getuGrade() {
        return uGrade;
    }

    public void setuGrade(String uGrade) {
        this.uGrade = uGrade == null ? null : uGrade.trim();
    }

    public String getuClass() {
        return uClass;
    }

    public void setuClass(String uClass) {
        this.uClass = uClass == null ? null : uClass.trim();
    }

    public String getuLocation() {
        return uLocation;
    }

    public void setuLocation(String uLocation) {
        this.uLocation = uLocation == null ? null : uLocation.trim();
    }

    public String getuExtra() {
        return uExtra;
    }

    public void setuExtra(String uExtra) {
        this.uExtra = uExtra == null ? null : uExtra.trim();
    }

    public Integer getuState() {
        return uState;
    }

    public void setuState(Integer uState) {
        this.uState = uState;
    }
}