package com.cdtc.student.assistant.request;

import com.cdtc.student.assistant.model.ContactEO;
import com.cdtc.student.assistant.model.FindEO;

import java.util.List;

/**
 * Create by pcc on 2018/5/3.
 */
public class CreateFindRequest {

    private FindEO find;

    private List<ContactEO> contacts;

    private List<String> imgs;

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }

    public FindEO getFind() {
        return find;
    }

    public void setFind(FindEO find) {
        this.find = find;
    }

    public List<ContactEO> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactEO> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "CreateFindRequest{" +
                "find=" + find +
                ", contacts=" + contacts +
                ", imgs=" + imgs +
                '}';
    }
}
