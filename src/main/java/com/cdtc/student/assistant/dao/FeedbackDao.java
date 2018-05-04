package com.cdtc.student.assistant.dao;

import com.cdtc.student.assistant.model.FeedbackEO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 反馈dao
 * Create by pcc on 2018/4/29.
 */
@Repository
public interface FeedbackDao {

    /**
     * 保存一条反馈记录
     * @param feedbackEO 实体
     */
    void insert(FeedbackEO feedbackEO);

    /**
     * 通过处理状态查询反馈
     * @param status
     * @return
     */
    List<FeedbackEO> findFeedbackByStatus(Integer status);



}
