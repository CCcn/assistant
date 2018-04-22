package com.cdtc.student.assistant.model;

/**
 * 轮播图
 * Create by pcc on 2018/4/22.
 */
public class Banner {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 对应链接
     */
    private String url;

    /**
     * 轮播图片
     */
    private String img;

    /**
     * 轮播配文
     */
    private String tip;


    /**
     * 后面改用枚举
     *
     * 状态：
     *   0 ：有效
     *   1：无效
     */
    private Integer status = 0;

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", img='" + img + '\'' +
                ", tip='" + tip + '\'' +
                ", status=" + status +
                '}';
    }
}
