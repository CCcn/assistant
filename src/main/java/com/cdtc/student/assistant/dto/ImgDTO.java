package com.cdtc.student.assistant.dto;

/**
 * Create by pcc on 2018/4/30.
 */
public class ImgDTO {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ImgDTO{" +
                "url='" + url + '\'' +
                '}';
    }
}
