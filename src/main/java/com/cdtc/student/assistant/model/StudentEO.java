package com.cdtc.student.assistant.model;

import com.cdtc.student.assistant.utils.Md5Utils;
import com.cdtc.student.assistant.utils.TextUtils;

/**
 * 学生表实体
 * Create by pcc on 2018/4/30.
 */
public class StudentEO {

    private Integer id;

    /**
     * 学号
     */
    private String studentNumber;

    /**
     * 姓名
     */
    private String studentName;

    /**
     * 学院
     */
    private String academy;

    /**
     * 班级
     */
    private String className;

    /**
     * 年纪
     * 2015
     * 2016
     */
    private String grade;

    /**
     * 状态
     *  0：禁用
     *  1：启用
     */
    private Integer status;

    /**
     * 性别
     *  0：男
     *  1：女
     */
    private Integer gender;

    /**
     * 密码
     */
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }
    /**
     * MD5加密
     * @param password
     */
    public void setPassword(String password) {
        if (!TextUtils.isEmpty(password)) {
            this.password = Md5Utils.getMD5String(password);
        } else {
            this.password = null;
        }
    }
}
