package com.cdtc.student.assistant.controller;

import com.cdtc.student.assistant.common.ResponseCodeConstant;
import com.cdtc.student.assistant.common.ResponseMessageConstant;
import com.cdtc.student.assistant.dao.StudentDao;
import com.cdtc.student.assistant.dto.StudentDTO;
import com.cdtc.student.assistant.utils.DateUtils;
import com.cdtc.student.assistant.utils.Md5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by pcc on 2018/5/1.
 */
@RestController
@RequestMapping("user")
@EnableAutoConfiguration
public class StudentController {


    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 如果是使用加密的密码进行校验，那么长度是32未（Md5 32位小写）
     */
    private static final int ENCODE_PASSWORD_LENGTH = 32;

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

        String encodePassword = Md5Utils.getMD5String(password);

        StudentDTO student = null;

        logger.info(password.length() + "");

        if (password.length() == ENCODE_PASSWORD_LENGTH) {
            student =  studentDao.findByStudentNumAndPassword(studentNumber,password);
        } else {
            student = studentDao.findByStudentNumAndPassword(studentNumber,encodePassword);
        }

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
        logger.info("登陆成功: 插入成功：" + student + DateUtils.getFormatNow());
        return modelMap;
    }

    @RequestMapping("updatePassword")
    public Object updatePassword(String userName, String origin, String newPassword) {

        return null;
    }
}
