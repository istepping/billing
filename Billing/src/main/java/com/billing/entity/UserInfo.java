package com.billing.entity;

public class UserInfo {
    private Long uId;

    private String uAvatarurl;

    private String uCity;

    private String uCountry;

    private String uGender;

    private String uLanguage;

    private String uNickname;

    private String uProvince;

    public UserInfo() {
    }

    public UserInfo(Long uId, String uAvatarurl, String uCity, String uCountry, String uGender, String uLanguage, String uNickname, String uProvince) {
        this.uId = uId;
        this.uAvatarurl = uAvatarurl;
        this.uCity = uCity;
        this.uCountry = uCountry;
        this.uGender = uGender;
        this.uLanguage = uLanguage;
        this.uNickname = uNickname;
        this.uProvince = uProvince;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getuAvatarurl() {
        return uAvatarurl;
    }

    public void setuAvatarurl(String uAvatarurl) {
        this.uAvatarurl = uAvatarurl == null ? null : uAvatarurl.trim();
    }

    public String getuCity() {
        return uCity;
    }

    public void setuCity(String uCity) {
        this.uCity = uCity == null ? null : uCity.trim();
    }

    public String getuCountry() {
        return uCountry;
    }

    public void setuCountry(String uCountry) {
        this.uCountry = uCountry == null ? null : uCountry.trim();
    }

    public String getuGender() {
        return uGender;
    }

    public void setuGender(String uGender) {
        this.uGender = uGender == null ? null : uGender.trim();
    }

    public String getuLanguage() {
        return uLanguage;
    }

    public void setuLanguage(String uLanguage) {
        this.uLanguage = uLanguage == null ? null : uLanguage.trim();
    }

    public String getuNickname() {
        return uNickname;
    }

    public void setuNickname(String uNickname) {
        this.uNickname = uNickname == null ? null : uNickname.trim();
    }

    public String getuProvince() {
        return uProvince;
    }

    public void setuProvince(String uProvince) {
        this.uProvince = uProvince == null ? null : uProvince.trim();
    }
}