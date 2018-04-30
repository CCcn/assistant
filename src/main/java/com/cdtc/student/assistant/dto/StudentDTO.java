package com.cdtc.student.assistant.dto;

/**
 * 学生传输对象
 * Create by pcc on 2018/4/30.
 */
public class StudentDTO {

    /**
     * 学号
     */
    private String studentNumber;

    /**
     * 姓名
     */
    private String name;

    /**
     * 头像
     */
    private String img;

    /**
     * 班级
     */
    private String className;

    /**
     * 年纪
     */
    private String grade;

    /**
     * 学院
     */
    private String academy;

    /**
     * 性别
     */
    private Integer gender;

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "studentNumber='" + studentNumber + '\'' +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", className='" + className + '\'' +
                ", grade='" + grade + '\'' +
                ", academy='" + academy + '\'' +
                ", gender=" + gender +
                '}';
    }
}
