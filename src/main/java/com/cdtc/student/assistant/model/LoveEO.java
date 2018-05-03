package com.cdtc.student.assistant.model;

/**
 * 表白墙
 * Create by pcc on 2018/4/29.
 */
public class LoveEO {

    /**
     * id
     */
    private Integer id;

    /**
     * 关联的用户id
     */
    private Integer userId;

    /**
     * 标题
     */
    private String title;

    /**
     * 点赞人数
     */
    private Integer likes;

    /**
     * 表白内容
     */
    private String content;

    /**
     * 评论数
     */
    private Integer comment;

    /**
     * 此商品状态
     *  标记删除：
     *  0:已删除；
     *  1：未删除
     */
    private Integer status;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
