package com.billing.dto;

/**
 * @author sunLei on 2018/11/29 18:40
 * @version 1.0
 * @apiNote
 */
public class PersonRankDto {
    private Integer rank;//名次
    private String avatarUrl;//头像
    private String nickName;//呢称
    private String score;//评分

    public PersonRankDto() {
    }

    public PersonRankDto(Integer rank, String avatarUrl, String nickName, String score) {
        this.rank = rank;
        this.avatarUrl = avatarUrl;
        this.nickName = nickName;
        this.score = score;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
