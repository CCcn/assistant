package com.cdtc.student.assistant.dao;

import com.cdtc.student.assistant.dto.BuyDTO;
import com.cdtc.student.assistant.dto.BuyDetailDTO;
import com.cdtc.student.assistant.model.BuyEO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 跳蚤dao
 * Create by pcc on 2018/4/29.
 */
@Repository
public interface BuyDao {


    /**
     * 保存一个商品
     * @param buyEO 跳蚤商品
     * @return 主键
     */
    Integer insert(BuyEO buyEO);

    /**
     * 更新跳蚤商品
     * @param buyEO
     */
    void update(BuyEO buyEO);

    /**
     * 标记删除一个商品
     * @param id
     */
    void delete(Integer id);

    /**
     * 通过id查询信息
     * @param id 商品id
     * @return BuyDetailDTO
     */
    BuyDetailDTO findBuyDetailById(Integer id);

    /**
     * 用于app内展示
     *  后期实现分页
     *  首页
     * @return list buyDTO
     */
    List<BuyDTO> findIndexBuy();

    /**
     * 用于app内展示
     *   后期实现分页
     *   搜索
     * @return
     */
    List<BuyDTO> findIndexBuyName(String name);

    /**
     * 用于app内展示
     *   后期实现分页
     *   用户管理列表
     * @return
     */
    List<BuyDTO> findIndexBuyUserId(Integer userId);

    /**
     * 查寻最后几条记录
     * @param size
     * @return
     */
    List<BuyDTO> findBuyByLimit(Integer size);



}
