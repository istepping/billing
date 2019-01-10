package com.billing.dto;

/**
 * @author sunLei on 2018/12/21 15:47
 * @version 1.0
 * @apiNote
 */
public class TypeCountDto {
    private Long typeId;
    private String type;
    private Integer count;
    public TypeCountDto() {
    }

    public TypeCountDto(Long typeId, String type, Integer count) {
        this.typeId = typeId;
        this.type = type;
        this.count = count;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
