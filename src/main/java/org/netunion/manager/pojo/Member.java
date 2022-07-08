package org.netunion.manager.pojo;

/**
 * 成员 JavaBean
 *
 * @author David Wang
 * @date 2022-07-08
 * @version 2.0
 */
public class Member {
    private String name;
    private String studentId;

    private String phoneNum;

    private String bankNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getBankNum() {
        return bankNum;
    }

    public void setBankNum(String bankNum) {
        this.bankNum = bankNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", studentId='" + studentId + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", bankNum='" + bankNum + '\'' +
                '}';
    }
}
