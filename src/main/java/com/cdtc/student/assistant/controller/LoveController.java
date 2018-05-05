package com.cdtc.student.assistant.controller;

import com.cdtc.student.assistant.common.ResponseCodeConstant;
import com.cdtc.student.assistant.common.ResponseMessageConstant;
import com.cdtc.student.assistant.dao.LoveDao;
import com.cdtc.student.assistant.request.BasePageRequest;
import com.cdtc.student.assistant.request.CreateLoveRequest;
import com.cdtc.student.assistant.request.UserIdPageRequest;
import com.cdtc.student.assistant.service.LoveService;
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
    private LoveService loveService;




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

        loveService.insert(love.getLove());

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

        loveService.delete(id);


        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);

        return modelMap;
    }

    /**
     * 分页查询
     * @param pageRequest
     * @return
     */
    @RequestMapping("allLoves")
    public Object showAllLove(@RequestBody BasePageRequest pageRequest) {
        ModelMap modelMap = new ModelMap();
        if (pageRequest == null || pageRequest.getPageNum() == null || pageRequest.getPageSize() == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            return modelMap;
        }
        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);

        modelMap.addAttribute("data",loveService.findIndexLove(pageRequest.getPageNum(), pageRequest.getPageSize()));
        return  modelMap;
    }

    /**
     * 分页查询
     * @param pageRequest
     * @return
     */
    @RequestMapping("showUserLoves")
    public Object showUserLove(@RequestBody UserIdPageRequest pageRequest) {
        ModelMap modelMap = new ModelMap();
        if (pageRequest == null || pageRequest.getUserId() == null || pageRequest.getPageNum() == null
                || pageRequest.getPageNum() == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            logger.info("showUserLoves :参数不正确：" + pageRequest);
            return modelMap;
        }
        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);
        modelMap.addAttribute("data",loveService.findLoveByUserID(pageRequest.getUserId(),
                pageRequest.getPageNum(), pageRequest.getPageSize()));
        return  modelMap;
    }
}
