package com.cdtc.student.assistant.response;

import com.cdtc.student.assistant.dto.ContactDTO;
import com.cdtc.student.assistant.dto.FindDetailDTO;

import java.util.List;

/**
 * Create by pcc on 2018/5/4.
 */
public class FindDetailResponse {

    private FindDetailDTO findDetail;

    private List<ContactDTO> contacts;

    private List<String> imgs;

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }

    public FindDetailDTO getFindDetail() {
        return findDetail;
    }

    public void setFindDetail(FindDetailDTO findDetail) {
        this.findDetail = findDetail;
    }

    public List<ContactDTO> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactDTO> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "FindDetailResponse{" +
                "findDetail=" + findDetail +
                ", contacts=" + contacts +
                ", imgs=" + imgs +
                '}';
    }
}
