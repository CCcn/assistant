package com.cdtc.student.assistant.controller;

import com.cdtc.student.assistant.common.ResponseCodeConstant;
import com.cdtc.student.assistant.common.ResponseMessageConstant;
import com.cdtc.student.assistant.dao.StudentDao;
import com.cdtc.student.assistant.dto.StudentDTO;
import com.cdtc.student.assistant.request.UpdatePasswordRequest;
import com.cdtc.student.assistant.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by pcc on 2018/5/1.
 */
@RestController
@RequestMapping("user")
@EnableAutoConfiguration
public class StudentController {


    Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private StudentDao studentDao;
    /**
     * 登陆
     * @param studentNumber 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping("login")
    public Object login(String studentNumber, String password) {
        ModelMap modelMap = new ModelMap();
        if (studentNumber == null || password == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            logger.info("login : userName :" + studentNumber + " password" + password);
            return modelMap;
        }

        logger.info("userName" + studentNumber +"  password" + password );

        //客户端传送的加密后的密码
        StudentDTO student = studentDao.findByStudentNumAndPassword(studentNumber,password);

        if (student == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.USERNAME_OR_PASSWORD_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.USERNAME_OR_PASSWORD_ERROR);
            logger.info("login 失败：用户名或密码错误: userName :" + studentNumber + " password" + password);
            return modelMap;
        }

        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);
        modelMap.addAttribute("data",student);
        //应该写登陆日志
        logger.info("登陆成功: ：" + student + DateUtils.getFormatNow());
        return modelMap;
    }


    /**
     * 修改密码
     * @param request id、原密码、新密码
     * @return Object
     */
    @RequestMapping(value = "updatePassword", method = RequestMethod.POST)
    public Object updatePassword(@Validated @RequestBody UpdatePasswordRequest request) {
        logger.info("用户修改密码 ：" + request);

        ModelMap modelMap = new ModelMap();
        StudentDTO student = studentDao.findByStudentNumAndPassword(request.getStudentNumber(), request.getOldPassword());

        if (student == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PASSWORD_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PASSWORD_ERROR);
            logger.info("修改密码失败：密码错误: password " + request.getOldPassword());
            return modelMap;
        }

        studentDao.updatePassword(request.getStudentNumber(), request.getNewPassword());

        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", "修改密码成功");
        logger.info("修改密码成功：studentNumber " + request.getStudentNumber() +" 密码：" + request.getNewPassword());
        return modelMap;
    }
}
