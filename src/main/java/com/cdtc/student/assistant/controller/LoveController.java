package com.cdtc.student.assistant.controller;

import com.cdtc.student.assistant.common.ResponseCodeConstant;
import com.cdtc.student.assistant.common.ResponseMessageConstant;
import com.cdtc.student.assistant.dao.LoveDao;
import com.cdtc.student.assistant.request.CreateLoveRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 表白墙请求接口
 * Create by pcc on 2018/4/29.
 */
@RestController
@RequestMapping("love")
@EnableAutoConfiguration
public class LoveController {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private LoveDao loveDao;


    @RequestMapping(value = "createLove" , method = RequestMethod.POST)
    public Object create(@RequestBody CreateLoveRequest love) {

        ModelMap modelMap = new ModelMap();
        if (love == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            return modelMap;
        }
        if (love.getLove().getUserId() == null || love.getLove().getTitle() == null || love.getLove().getContent() == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            logger.info("create :参数不正确：" + love);
            return modelMap;
        }

        loveDao.insert(love.getLove());

        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);

        logger.info("create: 插入成功：" + love);
        return modelMap;
    }

    @RequestMapping("deleteLove")
    public Object delete(Integer id) {
        ModelMap modelMap = new ModelMap();
        if (id == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            return modelMap;
        }

        loveDao.delete(id);


        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);

        return modelMap;
    }

    @RequestMapping("allLoves")
    public Object showAllLove() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);
        modelMap.addAttribute("data",loveDao.findIndexLove());
        return  modelMap;
    }

    @RequestMapping("showUserLoves")
    public Object showUserLove(Integer userId) {
        ModelMap modelMap = new ModelMap();
        if (userId == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            return modelMap;
        }
        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);
        modelMap.addAttribute("data",loveDao.findLoveByUserID(userId));

        return  modelMap;
    }
}
