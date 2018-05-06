package com.cdtc.student.assistant.controller;

import com.cdtc.student.assistant.common.ResponseCodeConstant;
import com.cdtc.student.assistant.common.ResponseMessageConstant;
import com.cdtc.student.assistant.dao.BuyDao;
import com.cdtc.student.assistant.dao.ContactDao;
import com.cdtc.student.assistant.dto.ContactDTO;
import com.cdtc.student.assistant.model.BuyEO;
import com.cdtc.student.assistant.model.ContactEO;
import com.cdtc.student.assistant.request.BasePageRequest;
import com.cdtc.student.assistant.request.CreateBuyRequest;
import com.cdtc.student.assistant.request.NamePageRequest;
import com.cdtc.student.assistant.request.UserIdPageRequest;
import com.cdtc.student.assistant.response.BuyDetailResponse;
import com.cdtc.student.assistant.service.BuyService;
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

import java.util.List;

/**
 * 跳蚤请求接口
 * Create by pcc on 2018/4/29.
 */
@RestController()
@RequestMapping("buy")
@EnableAutoConfiguration
public class BuyController {

    Logger logger = LoggerFactory.getLogger(getClass());

    private final Integer CONTACT_TYPE_SHOP = 1;

    /**
     * 没有图片
     */
    private final int NO_IMG = 0;

    /**
     * 有图片
     */
    private final int HAS_IMG = 1;

    @Autowired
    private BuyService buyService;


    /**
     * 暂时没做图片上传
     *
     * @param buy
     * @return
     */
    @RequestMapping(value = "createBuy", method = RequestMethod.POST)
    public Object create(@RequestBody CreateBuyRequest buy) {
        ModelMap modelMap = new ModelMap();
        if (buy == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            logger.info("create : null");
            return modelMap;
        }
        if (buy.getBuy().getUserId() == null || buy.getBuy().getOwner() == null || buy.getBuy() == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            logger.info("create :参数不正确：" + buy);
            return modelMap;
        }

        //没有图片，给默认图片
        if (buy.getBuy().getImg() == null || buy.getBuy().getImg().length() == 0) {
            buy.getBuy().setImg("/default/buy.jpg");
        }

        buyService.insert(buy);

        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);

        logger.info("create: 插入成功：" + buy);
        return modelMap;
    }

    @RequestMapping(value = "updateBuy", method = RequestMethod.POST)
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

        buyService.update(buyEO);

        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);
        logger.info("save :保存成功：" + buyEO);
        return modelMap;
    }
//

    /**
     * delete
     *
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

        buyService.delete(id);

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

        BuyDetailResponse buyDetailResponse = buyService.findBuyDetailById(id);

        modelMap.addAttribute("data", buyDetailResponse);

        return modelMap;
    }

    /**
     * 分页查询
     *
     * @param pageRequest
     * @return
     */
    @RequestMapping(value = "allBuys")
    public Object showAllBuy(@RequestBody BasePageRequest pageRequest) {
        ModelMap modelMap = new ModelMap();

        if (pageRequest == null || pageRequest.getPageNum() == null || pageRequest.getPageSize() == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            return modelMap;
        }

        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);
        modelMap.addAttribute("data", buyService.findIndexBuy(pageRequest.getPageNum(),
                pageRequest.getPageSize()));
        return modelMap;
    }

    /**
     * 分页模糊搜索
     * @param pageRequest
     * @return
     */
    @RequestMapping(value = "searchBuy")
    public Object searchBuy(@RequestBody NamePageRequest pageRequest) {
        ModelMap modelMap = new ModelMap();
        if (pageRequest == null || pageRequest.getName() == null || pageRequest.getPageSize() == null
                || pageRequest.getPageNum() == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            return modelMap;
        }

        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);
        modelMap.addAttribute("data", buyService.findIndexBuyName(pageRequest.getName(),
                pageRequest.getPageNum(), pageRequest.getPageSize()));

        return modelMap;
    }

    /**
     * 分页查询用户的二手信息
     * @param pageRequest
     * @return
     */
    @RequestMapping(value = "showUserBuys")
    private Object showUserBuys(@RequestBody UserIdPageRequest pageRequest) {
        ModelMap modelMap = new ModelMap();
        if (pageRequest == null || pageRequest.getUserId() == null || pageRequest.getPageNum() == null
                || pageRequest.getPageNum() == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            logger.info("showUserBuys :参数不正确：" + pageRequest);
            return modelMap;
        }
        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);
        modelMap.addAttribute("data", buyService.findIndexBuyUserId(pageRequest.getUserId(),
                pageRequest.getPageNum(), pageRequest.getPageSize()));
        return modelMap;
    }

}
