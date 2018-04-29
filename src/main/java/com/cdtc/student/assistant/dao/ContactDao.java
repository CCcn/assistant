package com.cdtc.student.assistant.dao;

import com.cdtc.student.assistant.dto.ContactDTO;
import com.cdtc.student.assistant.model.ContactEO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create by pcc on 2018/4/29.
 */
@Repository
public interface ContactDao {

    /**
     * 保存一条记录
     * @param contactEO
     */
    void insertSingle(ContactEO contactEO);

    /**
     * 批量保存
     * @param contactEOS
     */
    void insertList(List<ContactEO> contactEOS);

    /**
     * 通过类型和物品id查找联系方式
     * @param type 失物招领、跳蚤
     * @param goodsID 失物招领、跳蚤的id
     * @return List ContactDTO
     */
    List<ContactDTO> findContactByTypeAndGoodsId(@Param("type") Integer type, @Param("goodsId") Integer goodsID);
}
