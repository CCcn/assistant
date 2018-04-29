package com.cdtc.student.assistant.model;

/**
 * 联系方式实体
 * Create by pcc on 2018/4/29.
 */
public class ContactEO {

    /**
     * id
     */
    private Integer id;

    /**
     * 关联的用户id
     */
    private Integer userId;

    /**
     * 联系方式 u类型
     *   wx
     *   qq
     *   mobile
     */
    private String contactType;

    /**
     * 号码
     */
    private String number;

    /**
     * 类别：
     * 0:失物招领
     * 1:跳蚤商品；
     */
    private Integer type;

    /**
     *  跳蚤商品或者失物招领的id
     */
    private Integer goodsId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "ContactEO{" +
                "id=" + id +
                ", userId=" + userId +
                ", contactType='" + contactType + '\'' +
                ", number='" + number + '\'' +
                ", type=" + type +
                ", goodsId=" + goodsId +
                '}';
    }
}
