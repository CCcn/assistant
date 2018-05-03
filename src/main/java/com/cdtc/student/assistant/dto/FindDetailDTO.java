package com.cdtc.student.assistant.dto;

import java.util.List;

/**
 * Create by pcc on 2018/4/29.
 */
public class FindDetailDTO {
    /**
     * 物品名称
     */
    private String name;

    /**
     * 联系人
     */
    private String contactPerson;

    /**
     * 丢失/拾得时间
     */
    private String lostDate;

    /**
     * 丢失/拾得地点
     */
    private String lostPlace;

    /**
     * 描述
     */
    private String description;

    /**
     * 是否已找到
     *  0:未完成（未找到）
     *  1:已完成（已找到）
     */
    private Integer finished;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getLostDate() {
        return lostDate;
    }

    public void setLostDate(String lostDate) {
        this.lostDate = lostDate;
    }

    public String getLostPlace() {
        return lostPlace;
    }

    public void setLostPlace(String lostPlace) {
        this.lostPlace = lostPlace;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getFinished() {
        return finished;
    }

    public void setFinished(Integer finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "FindDetailDTO{" +
                "name='" + name + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", lostDate='" + lostDate + '\'' +
                ", lostPlace='" + lostPlace + '\'' +
                ", description='" + description + '\'' +
                ", finished=" + finished +
                '}';
    }
}
