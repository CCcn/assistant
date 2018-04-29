package com.cdtc.student.assistant.dto;

/**
 * Create by pcc on 2018/4/29.
 */
public class LoveDTO {

    /**
     *标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "LoveDTO{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
