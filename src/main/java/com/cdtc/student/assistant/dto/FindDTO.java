package com.cdtc.student.assistant.dto;

/**
 * Create by pcc on 2018/4/29.
 */
public class FindDTO {
    /**
     * id
     *
     */
    private String id;

    /**
     * 图片
     */
    private String img;

    /**
     * 标题
     */
    private String title;

    /**
     * 地点
     */
    private String place;

    /**
     * 是否已找到
     *  0:未完成（未找到）
     *  1:已完成（已找到）
     */
    private Integer finished;

    /**
     * 时间
     */
    private String date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getFinished() {
        return finished;
    }

    public void setFinished(Integer finished) {
        this.finished = finished;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "FindDTO{" +
                "id='" + id + '\'' +
                ", img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", place='" + place + '\'' +
                ", finished=" + finished +
                ", date='" + date + '\'' +
                '}';
    }
}
