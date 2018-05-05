package com.cdtc.student.assistant.service;

import com.cdtc.student.assistant.dao.LoveDao;
import com.cdtc.student.assistant.dto.LoveDTO;
import com.cdtc.student.assistant.model.LoveEO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Create by pcc on 2018/5/6.
 */
public class LoveService {

    @Autowired
    private LoveDao loveDao;

    /**
     * 插入
     * @param loveEO
     */
    public void insert(LoveEO loveEO) {
        loveDao.insert(loveEO);
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Integer id) {
        loveDao.delete(id);
    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<LoveDTO> findIndexLove(Integer pageNum, Integer pageSize) {
        Page<LoveDTO> page = PageHelper.startPage(pageNum, pageSize);
        loveDao.findIndexLove();
        return page;
    }

    /**
     * 分页查询用户所有的表白
     * @param id
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<LoveDTO> findLoveByUserID(Integer id, Integer pageNum, Integer pageSize) {
        Page<LoveDTO> page = PageHelper.startPage(pageNum, pageSize);
        loveDao.findLoveByUserID(id);
        return page;
    }
}
