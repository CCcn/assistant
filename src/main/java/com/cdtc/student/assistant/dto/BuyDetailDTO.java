package com.cdtc.student.assistant.dto;

import java.util.List;

/**
 * Create by pcc on 2018/4/29.
 */
public class BuyDetailDTO {
    /**
     * 商品名称
     */
    private String name;

    /**
     * 价格
     */
    private String price;

    /**
     * 描述
     */
    private String description;

    /**
     * 联系人
     */
    private String owner;

    /**
     * 交易是否完成
     */
    private Integer finished;

    private Integer hasImg;

    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getHasImg() {
        return hasImg;
    }

    public void setHasImg(Integer hasImg) {
        this.hasImg = hasImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getFinished() {
        return finished;
    }

    public void setFinished(Integer finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "BuyDetailDTO{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", owner='" + owner + '\'' +
                ", finished=" + finished +
                '}';
    }
}
