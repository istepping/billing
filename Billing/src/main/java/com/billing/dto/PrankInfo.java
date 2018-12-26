package com.billing.dto;

import com.billing.entity.Prank;

/**
 * @author sunLei on 2018/12/26 11:13
 * @version 1.0
 * @apiNote 个人排名信息
 */
public class PrankInfo {
    private Prank prank;
    private String score;//总分
    private String score1;//分值一
    private String score2;//分值二
    private String score3;//分值三
    private String score4;//分值四
    private String score5;//分值五
    private String score6;//分值六

    public PrankInfo() {
    }

    public PrankInfo(Prank prank, String score, String score1, String score2, String score3, String score4, String score5, String score6) {
        this.prank = prank;
        this.score = score;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.score4 = score4;
        this.score5 = score5;
        this.score6 = score6;
    }

    public Prank getPrank() {
        return prank;
    }

    public void setPrank(Prank prank) {
        this.prank = prank;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getScore1() {
        return score1;
    }

    public void setScore1(String score1) {
        this.score1 = score1;
    }

    public String getScore2() {
        return score2;
    }

    public void setScore2(String score2) {
        this.score2 = score2;
    }

    public String getScore3() {
        return score3;
    }

    public void setScore3(String score3) {
        this.score3 = score3;
    }

    public String getScore4() {
        return score4;
    }

    public void setScore4(String score4) {
        this.score4 = score4;
    }

    public String getScore5() {
        return score5;
    }

    public void setScore5(String score5) {
        this.score5 = score5;
    }

    public String getScore6() {
        return score6;
    }

    public void setScore6(String score6) {
        this.score6 = score6;
    }
}
