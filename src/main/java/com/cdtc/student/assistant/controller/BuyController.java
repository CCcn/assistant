package com.cdtc.student.assistant.controller;

import com.cdtc.student.assistant.dao.BuyDao;
import com.cdtc.student.assistant.model.BuyEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 跳蚤请求接口
 * Create by pcc on 2018/4/29.
 */
//@RestController("buy")
//@EnableAutoConfiguration
public class BuyController {

    @Autowired
    private BuyDao buyDao;


    @RequestMapping(name = "create", method = RequestMethod.PATCH)
    private Object create(BuyEO buy) {
        return null;
    }

    public Object save() {
        return null;
    }

    public Object delete() {
        return null;
    }

    /**
     * 某个二手商品详细信息
     * @return
     */
    public Object showBuy() {

        return null;
    }

    /**
     * 所有可用的二手商品
     * @return
     */
    public Object showAllBuy() {
        return  buyDao.findIndexBuy();
    }

    public Object searchGoods(String goodsName) {

        return buyDao.findIndexBuyName(goodsName);
    }
    /**
     * 查询某个用户的可用二手信息
     * @return
     */
    private Object showUserBuy(Integer userId) {

        return buyDao.findIndexBuyUserId(11);
    }


}
