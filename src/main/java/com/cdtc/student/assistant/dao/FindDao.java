package com.cdtc.student.assistant.dao;

import com.cdtc.student.assistant.dto.FindDTO;
import com.cdtc.student.assistant.dto.FindDetailDTO;
import com.cdtc.student.assistant.model.FindEO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 失物招领
 * Create by pcc on 2018/4/29.
 */
@Repository
public interface FindDao {

    /**
     * 保存一条数据
     * @param findEO 失物招领
     * @return 主键
     */
    Integer insert(FindEO findEO);

    /**
     * 更新数据
     * @param findEO
     */
    void update(FindEO findEO);

    /**
     * 标记删除
     * @param id
     */
    void delete(Integer id);


    /**
     * 通过id查询详细信息
     * @param id
     * @return
     */
    FindDetailDTO findFindDetailById(Integer id);

    /**
     * 首页
     *  首页展示
     * @return List FindDTO
     */
    List<FindDTO> findIndexFind();

    /**
     * 搜索
     *
     * @param name 物品名称
     * @return List FindDTO
     */
    List<FindDTO> findIndexFindByName(String name);

    /**
     * 用户查询自己的列表
     * @param userId
     * @return List FindDTO
     */
    List<FindDTO> findFindByUserId(Integer userId);

    /**
     * 查询记录的最后几条
     * @param size 条数限制
     * @return List FindDTO
     */
    List<FindDTO> findFindByLimit(Integer size);
}
