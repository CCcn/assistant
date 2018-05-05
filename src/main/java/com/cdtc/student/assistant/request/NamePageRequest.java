package com.cdtc.student.assistant.request;

/**
 * 适用于用户搜索：buy、find
 * Create by pcc on 2018/5/6.
 */
public class NamePageRequest extends BasePageRequest {
    /**
     * 搜索的关键字
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NamePageRequest{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}
