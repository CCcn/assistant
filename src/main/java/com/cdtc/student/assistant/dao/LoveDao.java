package com.cdtc.student.assistant.dao;

import com.cdtc.student.assistant.dto.LoveDTO;
import com.cdtc.student.assistant.model.LoveEO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 表白墙
 * Create by pcc on 2018/4/29.
 */
@Repository
public interface LoveDao {

    /**
     * 插入一条表白墙
     * @param loveEO 记录
     * @return 主键
     */
    Integer insert(LoveEO loveEO);

    /**
     * 更新一个实体
     * @param loveEO
     */
    void update(LoveEO loveEO);

    /**
     * 标记删除
     * @param id
     */
    void delete(Integer id);

    /**
     * 用于app内展示
     *  后期实现分页
     *  首页
     * @return List  LoveDTO
     */
    List<LoveDTO> findIndexLove();


    /**
     * 用户表白管理
     *  用户管理累表
     * @return List  LoveDTO
     */
    List<LoveDTO> findLoveByUserID(Integer userId);

    /**
     * 查询数据库最后几条数据
     * @return List  LoveDTO
     */
    List<LoveDTO> findLoveByLimit(Integer size);

}
