package org.netunion.manager.config;

/**
 * 成员 JavaBean
 *
 * @author David Wang
 * @date 2022-07-06
 * @version 1.0
 */
public class Member {
    private int id;
    private String name;
    private String studentId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentId='" + studentId + '\'' +
                '}';
    }
}
