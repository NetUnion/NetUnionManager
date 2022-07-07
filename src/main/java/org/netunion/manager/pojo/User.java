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
    private String hashedPasswd;
    private String ipAddress;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHashedPasswd() {
        return hashedPasswd;
    }

    public void setHashedPasswd(String hashedPasswd) {
        this.hashedPasswd = hashedPasswd;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", hashedPasswd='" + hashedPasswd + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }
}
