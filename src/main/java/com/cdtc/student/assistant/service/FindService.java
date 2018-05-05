package com.cdtc.student.assistant.service;

import com.cdtc.student.assistant.dao.ContactDao;
import com.cdtc.student.assistant.dao.FindDao;
import com.cdtc.student.assistant.dto.FindDTO;
import com.cdtc.student.assistant.model.ContactEO;
import com.cdtc.student.assistant.model.FindEO;
import com.cdtc.student.assistant.request.CreateFindRequest;
import com.cdtc.student.assistant.response.FindDetailResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by pcc on 2018/5/5.
 */
@Service
public class FindService {

    @Autowired
    private FindDao findDao;

    @Autowired
    private ContactDao contactDao;

    private final Integer CONTACT_TYPE_SHOP = 0;

    /**
     * 分页查找所有信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<FindDTO> findIndexFind(Integer pageNum, Integer pageSize){
        Page<FindDTO> page = PageHelper.startPage(pageNum, pageSize);
        findDao.findIndexFind();
        return page;
    }

    /**
     * 分页查询用户个人的所有信息
     * @param id id
     * @param pageNum 页码
     * @param pageSize 每页的大小
     * @return
     */
    public Page<FindDTO> findFindByUserId(Integer id, Integer pageNum, Integer pageSize) {
        Page<FindDTO> page = PageHelper.startPage(pageNum, pageSize);
        findDao.findFindByUserId(id);
        return page;
    }
    /**
     * 查找详细
     * @param id find Id
     * @return
     */
    public FindDetailResponse findFindDetailById(Integer id) {
        FindDetailResponse findDetailResponse = new FindDetailResponse();

        findDetailResponse.setFindDetail(findDao.findFindDetailById(id));
        findDetailResponse.setContacts(contactDao.findContactByTypeAndGoodsId(CONTACT_TYPE_SHOP,id));
        return findDetailResponse;
    }

    /**
     * 插入
     * @param find
     */
    public void insert(CreateFindRequest find) {
        findDao.insert(find.getFind());
        Integer findId = find.getFind().getId();

        for (ContactEO contact : find.getContacts()) {
            contact.setUserId(find.getFind().getUserId());
            contact.setGoodsId(findId);
            contact.setType(CONTACT_TYPE_SHOP);
        }

    }

    /**
     * 更新
     * @param findEO
     */
    public void update(FindEO findEO) {
        findDao.update(findEO);
    }

    /**
     * 分页搜索
     * @param name 物品名称
     * @param pageNum 页码
     * @param pageSize 每页的大小
     * @return page
     */
    public Page<FindDTO> findIndexFindByName(String name, Integer pageNum, Integer pageSize) {
        Page<FindDTO> page = PageHelper.startPage(pageNum, pageSize);
        findDao.findIndexFindByName(name);
        return page;
    }

    /**
     * 标记删除
     * @param id
     */
    public void delete(Integer id) {
        findDao.delete(id);
    }

}
