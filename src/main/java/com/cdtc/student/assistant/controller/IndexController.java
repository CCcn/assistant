package com.cdtc.student.assistant.controller;

import com.cdtc.student.assistant.common.ResponseCodeConstant;
import com.cdtc.student.assistant.common.ResponseMessageConstant;
import com.cdtc.student.assistant.dao.BannerDao;
import com.cdtc.student.assistant.dao.BuyDao;
import com.cdtc.student.assistant.dao.FindDao;
import com.cdtc.student.assistant.dao.LoveDao;
import com.cdtc.student.assistant.dto.BannerDTO;
import com.cdtc.student.assistant.model.BannerEO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 初始化请求接口
 * Create by pcc on 2018/4/22.
 */
@RestController("index")
@EnableAutoConfiguration
public class IndexController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BannerDao bannerDao;

    @Autowired
    private LoveDao loveDao;

    @Autowired
    private FindDao findDao;

    @Autowired
    private BuyDao buyDao;

    /**
     * 查询最新的数据条数
     */
    private final int LIMIT_SIZE = 10;
    /**
     * 初始化请求
     *  banner
     *  love
     *  find
     *  buy
     * @return
     */
    @RequestMapping("index")
    public Object index(){
        ModelMap modelMap = new ModelMap();

        List<BannerEO> banners = bannerDao.selectAll();

        List<String> imgs = new ArrayList<>();
        List<String> tips = new ArrayList<>();
        List<String> urls = new ArrayList<>();

        for (BannerEO banner : banners) {
            imgs.add(banner.getImg());
            tips.add(banner.getTip());
            urls.add(banner.getUrl());
        }
        BannerDTO bannerDTO = new BannerDTO();
        bannerDTO.setImgs(imgs);
        bannerDTO.setTips(tips);
        bannerDTO.setUrls(urls);

        modelMap.addAttribute("message",ResponseMessageConstant.OK);
        modelMap.addAttribute("code",ResponseCodeConstant.OK);
        modelMap.addAttribute("banner",bannerDTO);
        modelMap.addAttribute("loves",loveDao.findLoveByLimit(LIMIT_SIZE));
        modelMap.addAttribute("finds",findDao.findFindByLimit(LIMIT_SIZE));
        modelMap.addAttribute("buys",buyDao.findBuyByLimit(LIMIT_SIZE));
        return modelMap;
    }


    @RequestMapping("index/page")
    public Object indexPage(){
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("message",ResponseMessageConstant.OK);
        modelMap.addAttribute("code",ResponseCodeConstant.OK);
        modelMap.addAttribute("banner",bannerDao.selectAll());
        modelMap.addAttribute("loves",loveDao.findLoveByLimit(LIMIT_SIZE));
        modelMap.addAttribute("finds",findDao.findFindByLimit(LIMIT_SIZE));
        modelMap.addAttribute("buys",buyDao.findBuyByLimit(LIMIT_SIZE));
        return modelMap;
    }
    /**
     *
     * @return
     */
    @RequestMapping(value = "page")
    public ModelMap page(ModelMap modelMap) {

        return modelMap;
    }

}
