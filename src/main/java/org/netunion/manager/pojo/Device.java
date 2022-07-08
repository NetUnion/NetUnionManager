package org.netunion.manager.pojo;

/**
 * 设备 JavaBean
 *
 * @author David Wang
 * @date 2022-07-08
 * @version 2.0
 */
public class Device {
    private String deviceType;
    private String manageIp;
    private String name;
    private int rackNo;

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getManageIp() {
        return manageIp;
    }

    public void setManageIp(String manageIp) {
        this.manageIp = manageIp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRackNo() {
        return rackNo;
    }

    public void setRackNo(int rackNo) {
        this.rackNo = rackNo;
    }

    @Override
    public String toString() {
        return "{" +
                "deviceType='" + deviceType + '\'' +
                ", manageIp='" + manageIp + '\'' +
                ", name='" + name + '\'' +
                ", rackNo=" + rackNo +
                '}';
    }
}
