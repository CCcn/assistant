package com.cdtc.student.assistant.request;

/**
 * 适用于查询个人的find、buy、love
 * Create by pcc on 2018/5/6.
 */
public class UserIdPageRequest extends BasePageRequest{
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserIdPageRequest{" +
                "userId=" + userId +
                "} " + super.toString();
    }
}
