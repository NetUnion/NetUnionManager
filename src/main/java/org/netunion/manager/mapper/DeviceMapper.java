package org.netunion.manager.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.netunion.manager.pojo.Device;

import java.util.List;

/**
 * 设备 Mapper 接口
 *
 * @author David Wang
 * @date 2022-07-08
 * @version 2.0
 */
@Mapper
public interface DeviceMapper {
    //增
    public int add(Device device);
    //删
    public void delete(String name);
    //改
    public void update(Device device);
    public void updateDeviceTypeByName(String name, String deviceType);
    public void updateManageIpByName(String name, String manageIp);
    public void updateRackNoByName(String name, int rackNo);
    //查
    public List<Device> getAll();
    public Device getByName(String name);
    public int count();
}
