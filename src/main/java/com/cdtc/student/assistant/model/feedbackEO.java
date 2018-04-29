package com.cdtc.student.assistant.model;

import java.util.Date;

/**
 * 用户反馈
 *
 * Create by pcc on 2018/4/29.
 */
public class feedbackEO {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户Id
     */
    private Integer userId;

    /**
     * 反馈内容
     */
    private String content;

    /**
     * 联系方式
     */
    private String contact;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     *  暂时没有处理枚举
     *
     * 0 : 未处理
     * 1 ：已处理
     */
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "feedbackEO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", contact='" + contact + '\'' +
                ", createDate=" + createDate +
                ", status=" + status +
                '}';
    }
}
