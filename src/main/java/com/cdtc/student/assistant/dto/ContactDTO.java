package com.cdtc.student.assistant.dto;

/**
 * 联系方式
 * Create by pcc on 2018/4/29.
 */
public class ContactDTO {

    /**
     * 联系方式类别
     *  wx
     *  qq
     *  mobile
     */
    private String contactType;

    /**
     * 号码
     */
    private String number;

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ContactDTO{" +
                "contactType='" + contactType + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
