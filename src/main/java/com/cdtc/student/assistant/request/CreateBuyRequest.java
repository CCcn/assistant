package com.cdtc.student.assistant.request;

import com.cdtc.student.assistant.model.BuyEO;
import com.cdtc.student.assistant.model.ContactEO;

import java.util.List;

/**
 * Create by pcc on 2018/5/3.
 */
public class CreateBuyRequest {

    private BuyEO buy;

    /**
     * 联系方式
     */
    private List<ContactEO> contacts;

    public BuyEO getBuy() {
        return buy;
    }

    public List<String> imgs;

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }

    public void setBuy(BuyEO buy) {
        this.buy = buy;
    }

    public List<ContactEO> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactEO> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "CreateBuyRequest{" +
                "buy=" + buy +
                ", contacts=" + contacts +
                ", imgs=" + imgs +
                '}';
    }
}
