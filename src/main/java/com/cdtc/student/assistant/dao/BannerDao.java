package com.cdtc.student.assistant.dao;

import com.cdtc.student.assistant.model.Banner;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 轮播图
 * Create by pcc on 2018/4/22.
 */
@Repository
public interface BannerDao {

    /**
     * 查询所有有效的banner
     * @return
     */
    List<Banner> selectAll();

    void insert(Banner banner);
}
