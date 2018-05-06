package com.cdtc.student.assistant.response;

import java.util.List;

/**
 * Create by pcc on 2018/5/6.
 */
public class FileResponse {
    private List<String> urls;

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    @Override
    public String toString() {
        return "FileResponse{" +
                "urls=" + urls +
                '}';
    }
}
