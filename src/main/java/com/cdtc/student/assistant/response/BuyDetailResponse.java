package com.cdtc.student.assistant.response;

import com.cdtc.student.assistant.dto.BuyDetailDTO;
import com.cdtc.student.assistant.dto.ContactDTO;
import com.cdtc.student.assistant.dto.ImgDTO;
import com.cdtc.student.assistant.model.ContactEO;

import java.util.List;

/**
 * Create by pcc on 2018/5/3.
 */
public class BuyDetailResponse {

    private BuyDetailDTO buyDetail;

    private List<ContactDTO> contacts;

    private List<String> imgs;

    public List<String > getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }

    public List<ContactDTO> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactDTO> contacts) {
        this.contacts = contacts;
    }

    public BuyDetailDTO getBuyDetail() {
        return buyDetail;
    }

    public void setBuyDetail(BuyDetailDTO buyDetail) {
        this.buyDetail = buyDetail;
    }

    @Override
    public String toString() {
        return "BuyDetailResponse{" +
                "buyDetail=" + buyDetail +
                ", contacts=" + contacts +
                ", imgs=" + imgs +
                '}';
    }
}
