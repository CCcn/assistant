package com.cdtc.student.assistant.controller;

import com.cdtc.student.assistant.common.ResponseCodeConstant;
import com.cdtc.student.assistant.common.ResponseMessageConstant;
import com.cdtc.student.assistant.model.FindEO;
import com.cdtc.student.assistant.request.BasePageRequest;
import com.cdtc.student.assistant.request.CreateFindRequest;
import com.cdtc.student.assistant.request.NamePageRequest;
import com.cdtc.student.assistant.request.UserIdPageRequest;
import com.cdtc.student.assistant.response.FindDetailResponse;
import com.cdtc.student.assistant.service.FindService;
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
 * 失物招领接口
 * Create by pcc on 2018/4/29.
 */
@RestController
@RequestMapping("find")
@EnableAutoConfiguration
public class FindController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private FindService findService;


    @RequestMapping(value = "createFind", method = RequestMethod.POST)
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
            find.getFind().setImg("/default/find.jpg");
        }

        findService.insert(find);
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

        FindDetailResponse findDetailResponse = findService.findFindDetailById(id);
        modelMap.addAttribute("data", findDetailResponse);

        return modelMap;
    }

    @RequestMapping(value = "updateFind", method = RequestMethod.POST)
    public Object save(@RequestBody FindEO find) {
        ModelMap modelMap = new ModelMap();
        if (find == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            logger.info("update: null");
            return modelMap;
        }
        if (find.getUserId() == null || find.getDescription() == null || find.getPlace() == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            logger.info("update :参数不正确：" + find);
            return modelMap;
        }

        findService.update(find);
        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);

        logger.info("save: 插入成功：" + find);
        return modelMap;
    }

    /**
     * 分页查询
     *
     * @param pageRequest 分页请求
     * @return
     */
    @RequestMapping(value = "allFinds")
    public Object showAllFind(@RequestBody BasePageRequest pageRequest) {
        ModelMap modelMap = new ModelMap();
        if (pageRequest == null || pageRequest.getPageNum() == null || pageRequest.getPageSize() == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            return modelMap;
        }
        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);
        modelMap.addAttribute("data", findService.findIndexFind(pageRequest.getPageNum(), pageRequest.getPageSize()));
        return modelMap;
    }

    /**
     * 分页 查询某个用户的失物招领
     *
     * @param pageRequest
     * @return
     */
    @RequestMapping(value = "showUserFinds")
    public Object showUserFind(@RequestBody UserIdPageRequest pageRequest) {
        ModelMap modelMap = new ModelMap();
        if (pageRequest == null || pageRequest.getUserId() == null || pageRequest.getPageNum() == null
                || pageRequest.getPageNum() == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            logger.info("showUserFinds :参数不正确：" + pageRequest);
            return modelMap;
        }

        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);
        modelMap.addAttribute("data", findService.findFindByUserId(pageRequest.getUserId(),
                pageRequest.getPageNum(), pageRequest.getPageSize()));

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

        findService.delete(id);

        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);

        return modelMap;
    }

    /**
     * 分页搜索
     * @param pageRequest
     * @return
     */
    @RequestMapping(value = "searchFind")
    public Object search(@RequestBody NamePageRequest pageRequest) {
        ModelMap modelMap = new ModelMap();
        if (pageRequest == null || pageRequest.getName() == null || pageRequest.getPageSize() == null
                || pageRequest.getPageNum() == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            return modelMap;
        }

        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);
        modelMap.addAttribute("data", findService.findIndexFindByName(pageRequest.getName(),
                pageRequest.getPageNum(), pageRequest.getPageSize()));
        return modelMap;
    }


    @RequestMapping(value = "finds")
    public Object showAllFindPost(BasePageRequest pageRequest) {
        ModelMap modelMap = new ModelMap();
        if (pageRequest == null || pageRequest.getPageNum() == null || pageRequest.getPageSize() == null) {
            modelMap.addAttribute("code", ResponseCodeConstant.PARAMETER_LOST_ERROR);
            modelMap.addAttribute("message", ResponseMessageConstant.PARAMETER_LOST_ERROR);
            return modelMap;
        }
        modelMap.addAttribute("code", ResponseCodeConstant.OK);
        modelMap.addAttribute("message", ResponseMessageConstant.OK);
        modelMap.addAttribute("data", findService.findIndexFind(pageRequest.getPageNum(), pageRequest.getPageSize()));
        return modelMap;
    }

}
