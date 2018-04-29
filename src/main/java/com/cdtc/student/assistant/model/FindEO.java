package com.cdtc.student.assistant.model;

/**
 * 失物招领
 * Create by pcc on 2018/4/29.
 */
public class FindEO {

    /**
     * id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 图片
     */
    private String img;

    /**
     * 标题
     */
    private String title;

    /**
     * 相关地点
     */
    private String place;

    /**
     * 相关时间
     */
    private String date;

    /**
     * 联系人
     */
    private String contactPerson;

    /**
     * 物品描述信息
     */
    private String description;

    /**
     * 是否完成
     *    0：未找到
     *    1：已找到
     */
    private Integer finished;

    /**
     * 此商品状态
     *  标记删除：
     *  0:已删除；
     *  1：未删除
     */
    private Integer status;

    @Override
    public String toString() {
        return "FindEO{" +
                "id=" + id +
                ", userId=" + userId +
                ", img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", place='" + place + '\'' +
                ", date='" + date + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", description='" + description + '\'' +
                ", finished=" + finished +
                ", status=" + status +
                '}';
    }
}
