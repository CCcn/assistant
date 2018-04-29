package com.cdtc.student.assistant.dao;

import com.cdtc.student.assistant.dto.ImgDTO;
import com.cdtc.student.assistant.model.ImgEO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Create by pcc on 2018/4/30.
 */
public interface ImgDao {

    /**
     * 保存一条记录
     * @param img
     */
    void insert(ImgEO img);

    /**
     * 通过类型（跳蚤/失物招领）和id（他们对应的id）查找图片
     * @param type 跳蚤/失物招领
     * @param goodsId id
     * @return
     */
    List<ImgDTO> findImgByTypeAndGoodsId(@Param("type") Integer type, @Param("goodsId") Integer goodsId);

}
