package com.cdtc.student.assistant.dao;

import com.cdtc.student.assistant.dto.StudentDTO;
import com.cdtc.student.assistant.model.StudentEO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
/**
 * 学生账号
 *   完善登陆日志
 * Create by pcc on 2018/4/30.
 */
@Repository
public interface StudentDao {


    /**
     * 插入
     * @param student 实体
     */
    void insert(StudentEO student);

    /**
     * 验证
     * @param studentNumber 学号
     * @param password 密码
     * @return 实体
     */
    StudentDTO findByStudentNumAndPassword(@Param("studentNumber") String studentNumber, @Param("password") String password);

    /**
     * 更改头像
     * @param studentNumber
     * @param img
     */
    void updateImg(@Param("studentNumber") String studentNumber, @Param("img") String img);

    /**
     * 修改密码
     * @param password
     * @param studentNumber
     */
    void updatePassword(@Param("studentNumber") String studentNumber, @Param("password") String password);

}
