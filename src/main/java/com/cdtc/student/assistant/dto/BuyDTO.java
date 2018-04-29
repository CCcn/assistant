package com.cdtc.student.assistant.dto;

/**
 * 跳蚤商品传输对象
 * Create by pcc on 2018/4/29.
 */
public class BuyDTO {

    /**
     * id,用于详细页面的请求
     */
    private Integer id;

    /**
     * 展示的图片
     */
    private String img;

    /**
     * 描述信息
     */
    private String title;

    /**
     * 售价
     */
    private String price;

    /**
     * 是否完成交易
     */
    private Integer finished;

    public Integer  getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getFinished() {
        return finished;
    }

    public void setFinished(Integer finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "BuyDTO{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", finished=" + finished +
                '}';
    }
}
