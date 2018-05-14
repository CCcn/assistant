package com.cdtc.student.assistant.request;

import javax.validation.constraints.NotBlank;

/**
 * 修改密码
 */
public class UpdatePasswordRequest {

    @NotBlank
    private String  studentNumber;

    @NotBlank
    private String oldPassword;

    @NotBlank
    private String newPassword;


    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

   @Override
    public String toString() {
        return "UpdatePasswordRequest{" +
                "studentNumber='" + studentNumber + '\'' +
                ", oldPassword='" + oldPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}
