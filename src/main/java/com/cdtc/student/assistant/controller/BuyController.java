package com.cdtc.student.assistant.controller;

import com.cdtc.student.assistant.common.ResponseCodeConstant;
import com.cdtc.student.assistant.common.ResponseMessageConstant;
import com.cdtc.student.assistant.dao.BuyDao;
import com.cdtc.student.assistant.model.BuyEO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 跳蚤请求接口
 * Create by pcc on 2018/4/29.
 */
@RestController()
@RequestMapping("buy")
@EnableAutoConfiguration
public class BuyController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BuyDao buyDao;

    /**
     * 没有图片
     */
    private final int NO_IMG = 0;

    /**
     * 有图片
     */
    private final int HAS_IMG = 1;


    /**
     * 暂时没做图片上传
     * @param buy
     * @return
     */
    @RequestMapping(value = "createBuy", method = RequestMethod.POST)
    public Object create(@RequestBody BuyEO buy) {
        ModelMap modelMap = new ModelMap();
        if (buy == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            logger.info("create : null");
            return modelMap;
        }
        if (buy.getUserId() == null || buy.getOwner() == null || buy.getPrice() == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            logger.info("create :参数不正确：" + buy);
            return modelMap;
        }

        buyDao.insert(buy);

        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);

        logger.info("create: 插入成功：" + buy);
        return modelMap;
    }

    @RequestMapping(value = "saveBuy", method = RequestMethod.POST)
    public Object save(@RequestBody BuyEO buyEO) {
        ModelMap modelMap = new ModelMap();
        if (buyEO == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            return modelMap;
        }
        if (buyEO.getUserId() == null || buyEO.getOwner() == null || buyEO.getPrice() == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            logger.info("save :参数不正确：" + buyEO);
            return modelMap;
        }

        buyDao.update(buyEO);
        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);
        logger.info("save :保存成功：" + buyEO);
        return modelMap;
    }
//
    /**
     * delete
     * @param id
     * @return
     */
    @RequestMapping(value = "deleteBuy")
    public Object delete(Integer id) {
        ModelMap modelMap = new ModelMap();
        if (id == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            logger.info("delete :参数不正确：" + id);
            return modelMap;
        }

        buyDao.delete(id);

        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);
        logger.info("delete :标记删除成功：" + id);
        return modelMap;
    }

    /**
     * 某个二手商品详细信息
     *
     * @return
     */
    @RequestMapping(value = "showBuy")
    public Object showBuy(Integer id) {
        ModelMap modelMap = new ModelMap();
        if (id == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            return modelMap;
        }
        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);
        modelMap.addAttribute("data", buyDao.findBuyDetailById(id));

        return null;
    }

    /**
     * 所有可用的二手商品
     *
     * @return
     */
    @RequestMapping(value = "allBuys")
    public Object showAllBuy() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);
        modelMap.addAttribute("data", buyDao.findIndexBuy());
        return modelMap;
    }

    @RequestMapping(value = "searchBuy")
    public Object searchBuy(String goodsName) {
        ModelMap modelMap = new ModelMap();
        if (goodsName == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            return modelMap;
        }

        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);
        modelMap.addAttribute("data", buyDao.findIndexBuyName(goodsName));

        return modelMap;
    }

    /**
     * 查询某个用户的可用二手信息
     *
     * @return
     */
    @RequestMapping(value = "showUserBuys")
    private Object showUserBuys(Integer userId) {
        ModelMap modelMap = new ModelMap();
        if (userId == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            return modelMap;
        }
        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);
        modelMap.addAttribute("data", buyDao.findIndexBuyUserId(userId));

        return modelMap;
    }

}
