package org.netunion.manager.pojo;

/**
 * 权限用户实体
 *
 * @author David Wang
 * @date 2022-07-07
 * @version 1.0
 */
public class User {
    private String userName;
    private String hashedPassword;
    private int id;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "{" +
                "userName='" + userName + '\'' +
                ", hashedPasswd='" + hashedPassword + '\'' +
                ", id'" + id + '\'' +
                '}';
    }
}
