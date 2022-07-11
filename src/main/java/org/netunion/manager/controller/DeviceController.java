package org.netunion.manager.controller;

import org.netunion.manager.mapper.DeviceMapper;
import org.netunion.manager.pojo.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 设备控制器
 *
 * @author David Wang
 * @date 2022-07-08
 * @version 2.0
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
    @GetMapping("/device/{name}")
    public String getDevice(@PathVariable("name") String name) {
        if (deviceMapper.getByName(name) == null) return "{\"error\": \"NO DEVICE\"}";
        else return deviceMapper.getByName(name).toString();
    }
    //通过 POST 方式添加设备
    @PostMapping(value = "/device/add", produces = "application/json;charset=UTF-8")
    public String addDevice(@RequestBody Device device) {
        if (deviceMapper.getByName(device.getName()) != null) return "{\"error\": \"DEVICE EXISTS\"}";
        else {
            deviceMapper.add(device);
            return device.toString();
        }
    }
    //通过 DELETE 方式删除设备
    @DeleteMapping(value = "/device/delete/{name}")
    public String deleteDevice(@PathVariable("name") String name) {
        Device device = deviceMapper.getByName(name);
        if (device != null){
            deviceMapper.delete(name);
            return device.toString();
        }
        else {
            return "{\"error\": \"NO DEVICE\"}";
        }
    }
    //通过 POST 方式更新设备类型
    @PostMapping(value = "/device/update/type")
    public String updateDeviceType(@RequestParam String name, @RequestParam String deviceType) {
        Device device = deviceMapper.getByName(name);
        if (device == null) {
            return "{\"error\": \"NO DEVICE\"}";
        }
        else {
            deviceMapper.updateDeviceTypeByName(name, deviceType);
            device = deviceMapper.getByName(name);
            return device.toString();
        }
    }
    //通过 POST 方式更新设备 manageIp
    @PostMapping(value = "/device/update/manageIp")
    public String updateDeviceManageIp(@RequestParam String name, @RequestParam String manageIp) {
        Device device = deviceMapper.getByName(name);
        if (device == null) {
            return "{\"error\": \"NO DEVICE\"}";
        }
        else {
            deviceMapper.updateManageIpByName(name, manageIp);
            device = deviceMapper.getByName(name);
            return device.toString();
        }
    }
    //通过 POST 方式更新设备 rackNo
    @PostMapping(value = "/device/update/rackNo")
    public String updateDeviceRackNo(@RequestParam String name, @RequestParam int rackNo) {
        Device device = deviceMapper.getByName(name);
        if (device == null) {
            return "{\"error\": \"NO DEVICE\"}";
        }
        else {
            deviceMapper.updateRackNoByName(name, rackNo);
            device = deviceMapper.getByName(name);
            return device.toString();
        }
    }
}
