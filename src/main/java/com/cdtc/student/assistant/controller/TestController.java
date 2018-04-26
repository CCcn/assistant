package com.cdtc.student.assistant.controller;

import com.cdtc.student.assistant.dao.BannerDao;
import com.cdtc.student.assistant.model.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create by pcc on 2018/4/22.
 */
@RestController
@EnableAutoConfiguration
public class TestController {

    @Autowired
    private BannerDao bannerDao;

    @RequestMapping(value = "/index")
    public Object index() {
        List<Banner> banners = bannerDao.selectAll();

        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("hello","hello world");
        modelMap.addAttribute("banner",banners);
        return modelMap;
    }

    @RequestMapping(value = "/page")
    public Object page(ModelMap modelMap) {

        return modelMap;
    }
}
