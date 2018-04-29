package com.cdtc.student.assistant.model;

/**
 * Create by pcc on 2018/4/30.
 */
public class ImgEO {

    /**
     * id
     */
    private Integer id;

    /**
     * 路径
     */
    private String url;

    /**
     * 跳蚤或者失物招领id
     */
    private Integer goodsId;

    /**
     * 类型：失物招领或者跳蚤
     */
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ImgEO{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", goodsId=" + goodsId +
                ", type=" + type +
                '}';
    }
}
