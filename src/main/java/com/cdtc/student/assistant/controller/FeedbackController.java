package com.cdtc.student.assistant.controller;

import com.cdtc.student.assistant.common.ResponseCodeConstant;
import com.cdtc.student.assistant.common.ResponseMessageConstant;
import com.cdtc.student.assistant.dao.FeedbackDao;
import com.cdtc.student.assistant.model.FeedbackEO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * Create by pcc on 2018/4/29.
 */
@RestController()
@RequestMapping("feedback")
@EnableAutoConfiguration
public class FeedbackController {

    @Autowired
    private FeedbackDao feedbackDao;

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 已处理
     */
    private final int HANDLED = 0;

    /**
     * 未处理
     */
    private final int UN_HANDLE= 1;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object feedback(@RequestBody FeedbackEO feedbackEO ) {
        ModelMap modelMap = new ModelMap();

        if(feedbackEO == null) {
            modelMap.addAttribute("code",ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            return modelMap;
        }
        feedbackEO.setStatus(UN_HANDLE);
        feedbackEO.setCreateDate(new Date());

        feedbackDao.insert(feedbackEO);

        logger.info("收到反馈信息：" + feedbackEO);

        modelMap.addAttribute("code",ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);
        return modelMap;
    }
}
