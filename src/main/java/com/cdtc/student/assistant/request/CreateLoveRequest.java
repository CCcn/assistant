package com.cdtc.student.assistant.request;

import com.cdtc.student.assistant.model.LoveEO;

/**
 * Create by pcc on 2018/5/3.
 */
public class CreateLoveRequest {
    private LoveEO love;

    public LoveEO getLove() {
        return love;
    }

    public void setLove(LoveEO love) {
        this.love = love;
    }

    @Override
    public String toString() {
        return "CreateLoveRequest{" +
                "love=" + love +
                '}';
    }
}
