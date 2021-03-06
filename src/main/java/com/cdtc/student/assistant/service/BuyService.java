package com.cdtc.student.assistant.service;

import com.cdtc.student.assistant.dao.BuyDao;
import com.cdtc.student.assistant.dao.ContactDao;
import com.cdtc.student.assistant.dao.ImgDao;
import com.cdtc.student.assistant.dto.BuyDTO;
import com.cdtc.student.assistant.dto.ImgDTO;
import com.cdtc.student.assistant.model.BuyEO;
import com.cdtc.student.assistant.model.ContactEO;
import com.cdtc.student.assistant.model.ImgEO;
import com.cdtc.student.assistant.request.CreateBuyRequest;
import com.cdtc.student.assistant.response.BuyDetailResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 * Create by pcc on 2018/5/6.
 */
@Service
public class BuyService {

    @Autowired
    private BuyDao buyDao;

    @Autowired
    private ContactDao contactDao;

    @Autowired
    private ImgDao imgDao;

    /**
     * 没有图片
     */
    private final int NO_IMG = 0;

    /**
     * 有图片
     */
    private final int HAS_IMG = 1;

    private final Integer CONTACT_TYPE_SHOP = 1;

    /**
     * 插入
     *
     * @param buy
     */

    public void insert(CreateBuyRequest buy) {

        buyDao.insert(buy.getBuy());

        Integer buyId = buy.getBuy().getId();

        for (ContactEO contact : buy.getContacts()) {
            contact.setUserId(buy.getBuy().getUserId());
            contact.setGoodsId(buyId);
            contact.setType(CONTACT_TYPE_SHOP);
        }

        contactDao.insertList(buy.getContacts());

        /**
         * 有图片
         */
        if (buy.getBuy().getHasImg() == HAS_IMG && buy.getImgs() != null && !buy.getImgs().isEmpty()) {

            for (int i = 0 ; i < buy.getImgs().size(); i++) {
                ImgEO imgEO = new ImgEO();
                imgEO.setGoodsId(buyId);
                imgEO.setType(CONTACT_TYPE_SHOP);
                imgEO.setUrl(buy.getImgs().get(i));
                imgDao.insert(imgEO);
            }
        }
    }

    /**
     * 更新
     *
     * @param buyEO
     */
    public void update(BuyEO buyEO) {
        buyDao.update(buyEO);
    }

    /**
     * 标记删除
     *
     * @param id
     */
    public void delete(Integer id) {
        buyDao.delete(id);
    }

    /**
     * 分页查询
     *
     * @param pageNum  页码
     * @param pageSize 大小
     * @return
     */
    public Page<BuyDTO> findIndexBuy(Integer pageNum, Integer pageSize) {
        Page<BuyDTO> page = PageHelper.startPage(pageNum, pageSize);
        buyDao.findIndexBuy();
        return page;
    }

    /**
     * 分页模糊搜索
     * @param name
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<BuyDTO> findIndexBuyName(String name, Integer pageNum, Integer pageSize) {
        Page<BuyDTO> page = PageHelper.startPage(pageNum, pageSize);
        buyDao.findIndexBuyName(name);
        return page;
    }

    /**
     * 分页查询用户的二手商品信息
     * @param id
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<BuyDTO> findIndexBuyUserId(Integer id, Integer pageNum, Integer pageSize) {
        Page<BuyDTO> page = PageHelper.startPage(pageNum, pageSize);
        buyDao.findIndexBuyUserId(id);
        return page;
    }

    /**
     * 查询详细信息
     * @param id
     * @return
     */
    public BuyDetailResponse findBuyDetailById(Integer id) {
        BuyDetailResponse buyDetailResponse = new BuyDetailResponse();
        buyDetailResponse.setBuyDetail(buyDao.findBuyDetailById(id));
        buyDetailResponse.setContacts(contactDao.findContactByTypeAndGoodsId(CONTACT_TYPE_SHOP, id));

        /**
         * 有图片
         */
        if (buyDetailResponse.getBuyDetail().getHasImg() != null && buyDetailResponse.getBuyDetail().getHasImg() == HAS_IMG) {
            List<ImgDTO> imgs = imgDao.findImgByTypeAndGoodsId(CONTACT_TYPE_SHOP,id);
            List<String > stringImg = new ArrayList<>();
            for (int i = 0; i <imgs.size(); i++) {
                stringImg.add(imgs.get(i).getUrl());
            }
            buyDetailResponse.setImgs(stringImg);
            buyDetailResponse.setImgs(stringImg);
        }
        return buyDetailResponse;
    }

}
