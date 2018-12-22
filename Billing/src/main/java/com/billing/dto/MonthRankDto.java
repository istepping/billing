package com.billing.dto;

/**
 * @author sunLei on 2018/11/29 18:39
 * @version 1.0
 * @apiNote
 */
public class MonthRankDto {
    private String year;
    private String month;
    private String isRankUp;//知否上升,1是,0,否
    private Integer rankUpNum;//上升名次,>0上升,<0下降
    private Integer rank;//排名
    private String isHasRank;//该月是否存在排名,1是，0否
    public MonthRankDto() {
    }

    public MonthRankDto(String year, String month, String isRankUp, Integer rankUpNum, Integer rank) {
        this.year = year;
        this.month = month;
        this.isRankUp = isRankUp;
        this.rankUpNum = rankUpNum;
        this.rank = rank;
    }

    public MonthRankDto(String year, String month, String isRankUp, Integer rankUpNum, Integer rank, String isHasRank) {
        this.year = year;
        this.month = month;
        this.isRankUp = isRankUp;
        this.rankUpNum = rankUpNum;
        this.rank = rank;
        this.isHasRank = isHasRank;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getIsRankUp() {
        return isRankUp;
    }

    public void setIsRankUp(String isRankUp) {
        this.isRankUp = isRankUp;
    }

    public Integer getRankUpNum() {
        return rankUpNum;
    }

    public void setRankUpNum(Integer rankUpNum) {
        this.rankUpNum = rankUpNum;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getIsHasRank() {
        return isHasRank;
    }

    public void setIsHasRank(String isHasRank) {
        this.isHasRank = isHasRank;
    }
}
