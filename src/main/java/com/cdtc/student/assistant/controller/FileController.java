package com.cdtc.student.assistant.controller;

import com.cdtc.student.assistant.common.ResponseCodeConstant;
import com.cdtc.student.assistant.common.ResponseMessageConstant;
import com.cdtc.student.assistant.response.FileResponse;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.env.Environment;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Create by pcc on 2018/5/6.
 */
@RestController()
@RequestMapping("file")
@EnableAutoConfiguration
public class FileController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Environment env;

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public ModelMap uploads(@RequestParam("img") MultipartFile file, HttpServletRequest request) {
        logger.info("开始上传文件");
        ModelMap modelMap = new ModelMap();
        List<String> urls = new ArrayList<>();

        try {
            //上传目录地址
            String uploadDir = env.getProperty("upload.path") + "/";
            //如果目录不存在，自动创建文件夹
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            //调用上传方法，必须加一个斜杠，否则资源访问不到
            urls.add("/" + executeUpload(uploadDir, file));
        } catch(Exception e){
            logger.info("上传失败：" + e.getMessage());
            modelMap.addAttribute("code", ResponseCodeConstant.FILL_UPLOAD_FAILED);
            modelMap.addAttribute("message", ResponseMessageConstant.FILL_UPLOAD_FAILED);
            return modelMap;
        }

        FileResponse fileResponse = new FileResponse();
        fileResponse.setUrls(urls);
        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);
        modelMap.addAttribute("data", fileResponse);
        return modelMap;
    }

    /**
     * 提取上传方法为公共方法
     *
     * @param uploadDir 上传文件目录
     * @param file      上传对象
     * @throws Exception
     */
    private String executeUpload(String uploadDir, MultipartFile file) throws Exception {
        logger.info("开始上传 ：" + file.getOriginalFilename());
        //文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //上传文件名
        String filename = UUID.randomUUID() + suffix;
        //服务器端保存的文件对象
        File serverFile = new File(uploadDir + filename);
        logger.info("上传图片成功：原始名称 ：" + file.getOriginalFilename() + " url" + uploadDir + file.getOriginalFilename());
        //将上传的文件写入到服务器端文件内
        file.transferTo(serverFile);
        return filename;
    }
}