package com.billing.dto;

import com.billing.entity.Action;

import java.util.List;

/**
 * @author sunLei on 2019/3/24 12:20
 * @version 1.0
 * @apiNote
 */
public class ActionDto {
    /**行为数据*/
    private List<Action> actions;
    /**描述数据*/
    private String reasonInfo;
    private String habitInfo;
    private String impluseInfo;
    private String randomInfo;
    private String economicInfo;
    private String attentionInfo;

    public ActionDto() {
    }

    public ActionDto(List<Action> actions, String reasonInfo, String habitInfo, String impluseInfo, String randomInfo, String economicInfo, String attentionInfo) {
        this.actions = actions;
        this.reasonInfo = reasonInfo;
        this.habitInfo = habitInfo;
        this.impluseInfo = impluseInfo;
        this.randomInfo = randomInfo;
        this.economicInfo = economicInfo;
        this.attentionInfo = attentionInfo;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public String getReasonInfo() {
        return reasonInfo;
    }

    public void setReasonInfo(String reasonInfo) {
        this.reasonInfo = reasonInfo;
    }

    public String getHabitInfo() {
        return habitInfo;
    }

    public void setHabitInfo(String habitInfo) {
        this.habitInfo = habitInfo;
    }

    public String getImpluseInfo() {
        return impluseInfo;
    }

    public void setImpluseInfo(String impluseInfo) {
        this.impluseInfo = impluseInfo;
    }

    public String getRandomInfo() {
        return randomInfo;
    }

    public void setRandomInfo(String randomInfo) {
        this.randomInfo = randomInfo;
    }

    public String getEconomicInfo() {
        return economicInfo;
    }

    public void setEconomicInfo(String economicInfo) {
        this.economicInfo = economicInfo;
    }

    public String getAttentionInfo() {
        return attentionInfo;
    }

    public void setAttentionInfo(String attentionInfo) {
        this.attentionInfo = attentionInfo;
    }
}
