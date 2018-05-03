package com.cdtc.student.assistant.controller;

import com.cdtc.student.assistant.common.ResponseCodeConstant;
import com.cdtc.student.assistant.common.ResponseMessageConstant;
import com.cdtc.student.assistant.dao.ContactDao;
import com.cdtc.student.assistant.dao.FindDao;
import com.cdtc.student.assistant.dto.FindDetailDTO;
import com.cdtc.student.assistant.model.ContactEO;
import com.cdtc.student.assistant.model.FindEO;
import com.cdtc.student.assistant.request.CreateFindRequest;
import com.cdtc.student.assistant.response.BuyDetailResponse;
import com.cdtc.student.assistant.response.FindDetailResponse;
import com.sun.org.apache.xpath.internal.operations.Mod;
import javafx.geometry.Pos;
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
 * 失物招领接口
 * Create by pcc on 2018/4/29.
 */
@RestController
@RequestMapping("find")
@EnableAutoConfiguration
public class FindController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private FindDao findDao;

    @Autowired
    private ContactDao contactDao;

    private final Integer CONTACT_TYPE_SHOP = 0;

    @RequestMapping(value = "createFind" , method = RequestMethod.POST)
    public Object create(@RequestBody CreateFindRequest find) {

        ModelMap modelMap = new ModelMap();
        if (find == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            logger.info("create: null");
            return modelMap;
        }
        if (find.getFind().getUserId() == null || find.getFind().getDescription() == null || find.getFind().getPlace() == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            logger.info("create :参数不正确：" + find);
            return modelMap;
        }

        //没有图片，给默认图片
        if (find.getFind().getImg() == null || find.getFind().getImg().length() == 0) {
            find.getFind().setImg("/banner/1.jpg");
        }

        findDao.insert(find.getFind());
        Integer findId = find.getFind().getId();

        for (ContactEO contact : find.getContacts()) {
            contact.setUserId(find.getFind().getUserId());
            contact.setGoodsId(findId);
            contact.setType(CONTACT_TYPE_SHOP);
        }

        contactDao.insertList(find.getContacts());

        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);

        logger.info("create: 插入成功：" + find);
        return modelMap;
    }


    @RequestMapping(value = "showFind")
    public Object showFind(Integer id) {

        ModelMap modelMap = new ModelMap();

        if (id == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            return modelMap;
        }
        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);


        FindDetailResponse findDetailResponse = new FindDetailResponse();

        findDetailResponse.setFindDetail(findDao.findFindDetailById(id));
        findDetailResponse.setContacts(contactDao.findContactByTypeAndGoodsId(CONTACT_TYPE_SHOP,id));

        modelMap.addAttribute("data", findDetailResponse);

        return modelMap;
    }

    @RequestMapping(value = "saveFind" , method = RequestMethod.POST)
    public Object save(@RequestBody FindEO find) {
        ModelMap modelMap = new ModelMap();
        if (find == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            logger.info("save: null");
            return modelMap;
        }
        if (find.getUserId() == null || find.getDescription() == null || find.getPlace() == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            logger.info("save :参数不正确：" + find);
            return modelMap;
        }

        findDao.update(find);
        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);

        logger.info("save: 插入成功：" + find);
        return modelMap;
    }

    @RequestMapping(value = "allFinds")
    public Object showAllFind() {
        ModelMap modelMap = new ModelMap();

        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);
        modelMap.addAttribute("data", findDao.findIndexFind());

        return modelMap;
    }

    /**
     * 查询某个用户的失物招领
     * @param userId
     * @return
     */
    @RequestMapping(value = "showUserFinds")
    public Object showUserFind(Integer userId){
        ModelMap modelMap = new ModelMap();
        if (userId == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            logger.info("showUserFinds :参数不正确：" + userId);
            return modelMap;
        }

        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);
        modelMap.addAttribute("data", findDao.findFindByUserId(userId));

        return modelMap;
    }

    @RequestMapping(value = "deleteFind")
    public Object delete(Integer id) {
        ModelMap modelMap = new ModelMap();
        if (id == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            logger.info("delete : 参数不正确：" + id);
            return modelMap;
        }

        findDao.delete(id);

        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);

        return modelMap;
    }

    /**
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "searchFind")
    public Object search(String name) {
        ModelMap modelMap = new ModelMap();
        if (name == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            logger.info("search :参数不正确：" + name);
            return modelMap;
        }

        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);
        modelMap.addAttribute("data",findDao.findIndexFindByName(name));
        return modelMap;
    }
}
