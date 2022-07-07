package org.netunion.manager.controller;

import org.netunion.manager.config.Device;
import org.netunion.manager.mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 设备控制器
 *
 * @author David Wang
 * @date 2022-07-07
 * @version 1.1
 */
@RestController
public class DeviceController {
    @Autowired
    DeviceMapper deviceMapper;
    // 获取所有设备信息 JSON 格式
    @GetMapping("/device")
    public List<Device> getDeviceList() {
        return deviceMapper.getAll();
    }
    // 获取指定设备信息 JSON 格式
    @GetMapping("/device/{id}")
    public Device getDevice(@PathVariable("id") int id) {
        if (deviceMapper.getById(id) == null) return null;
        else return deviceMapper.getById(id);
    }
    //通过 POST 方式添加设备
    @PostMapping(value = "/device/add", produces = "application/json;charset=UTF-8")
    public String addDevice(@RequestBody Device device) {
        deviceMapper.add(device);
        return device.toString();
    }
    //通过 DELETE 方式删除设备
    @DeleteMapping(value = "/device/delete/{id}")
    public String deleteDevice(@PathVariable("id") int id) {
        Device device = deviceMapper.getById(id);
        if (device != null){
            deviceMapper.delete(id);
            return device.toString();
        }
        else {
            return "EMPTY ID";
        }
    }
    //通过 POST 方式更新设备类型
    @PostMapping(value = "/device/update/type")
    public String updateDeviceType(@RequestParam int id, @RequestParam String type) {
        Device device = deviceMapper.getById(id);
        if (device == null) {
            return "EMPTY ID";
        }
        else {
            deviceMapper.updateDeviceTypeById(id, type);
            return device.toString();
        }
    }
    //通过 POST 方式更新设备 manageIp
    @PostMapping(value = "/device/update/manageIp")
    public String updateDeviceManageIp(@RequestParam int id, @RequestParam String manageIp) {
        Device device = deviceMapper.getById(id);
        if (device == null) {
            return "EMPTY ID";
        }
        else {
            deviceMapper.updateManageIpById(id, manageIp);
            return device.toString();
        }
    }
    //通过 POST 方式更新设备 name
    @PostMapping(value = "/device/update/name")
    public String updateDeviceName(@RequestParam int id, @RequestParam String name) {
        Device device = deviceMapper.getById(id);
        if (device == null) {
            return "EMPTY ID";
        }
        else {
            deviceMapper.updateNameById(id, name);
            return device.toString();
        }
    }
    //通过 POST 方式更新设备 rackNo
    @PostMapping(value = "/device/update/rackNo")
    public String updateDeviceRackNo(@RequestParam int id, @RequestParam int rackNo) {
        Device device = deviceMapper.getById(id);
        if (device == null) {
            return "EMPTY ID";
        }
        else {
            deviceMapper.updateRackNoById(id, rackNo);
            return device.toString();
        }
    }
}
