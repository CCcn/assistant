package com.cdtc.student.assistant.dao;

import com.cdtc.student.assistant.model.StudentEO;

/**
 * 学生账号
 *   完善登陆日志
 * Create by pcc on 2018/4/30.
 */
public interface StudentDao {


    /**
     * 插入
     * @param student 实体
     */
    void insert(StudentEO student);

    /**
     * 更新、更改状态、改密码等等
     * @param student
     */
    void update(StudentEO student);

    /**
     * 验证
     * @param studentNum 学号
     * @return 实体
     */
    StudentEO findByStudentNumAndPassword(String studentNum, String password);

    /**
     * 更改头像
     * @param id
     * @param img
     */
    void updateImg(String id, String img);




}
