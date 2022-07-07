package org.netunion.manager.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.netunion.manager.pojo.Device;

import java.util.List;

/**
 * 设备 Mapper 接口
 *
 * @author David Wang
 * @date 2022-07-07
 * @version 1.0
 */
@Mapper
public interface DeviceMapper {
    //增
    public int add(Device device);
    //删
    public void delete(int id);
    //改
    public void update(Device device);
    public void updateDeviceTypeById(int id, String deviceType);
    public void updateManageIpById(int id, String manageIp);
    public void updateNameById(int id, String name);
    public void updateRackNoById(int id, int rackNo);
    //查
    public List<Device> getAll();
    public Device getById(int id);
    public int count();
}
