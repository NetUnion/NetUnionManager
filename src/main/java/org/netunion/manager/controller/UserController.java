package org.netunion.manager.controller;

import org.netunion.manager.mapper.UserMapper;
import org.netunion.manager.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户控制器
 *
 * @author David Wang
 * @date 2020-07-07
 * @version 1.0
 */
@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;
    // 获取所有用户信息 JSON 格式
    @GetMapping("/user")
    public List<User> getUserList() {
        return userMapper.getAll();
    }
    // 获取指定用户信息 JSON 格式
    @GetMapping("/user/getById")
    public User getById(@RequestParam("id") int id) {
        if (userMapper.getById(id) == null) return null;
        else return userMapper.getById(id);
    }
    @GetMapping("/user/getByUsername")
    public User getByUserName(@RequestParam("username") String username) {
        if (userMapper.getByUserName(username) == null) return null;
        else return userMapper.getByUserName(username);
    }
    //通过 POST 方式添加用户
    @PostMapping(value = "/user/add", produces = "application/json;charset=UTF-8")
    public String addUser(@RequestBody User user) {
        if (getByUserName(user.getUserName()) != null) return "USERNAME EXIST";
        else {
            userMapper.add(user);
            return user.toString();
        }
    }
    //通过 DELETE 方式删除用户
    @DeleteMapping(value = "/user/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        User user = userMapper.getById(id);
        if (user != null){
            userMapper.delete(id);
            return user.toString();
        }
        else {
            return "{\"error\": \"EMPTY ID\"}";
        }
    }
    //通过 POST 方式更新用户密码
    @PostMapping(value = "/user/update/password")
    public String updateUserPassword(@RequestParam int id, @RequestParam String oldPassWord, @RequestParam String newPassWord) {
        User user = userMapper.getById(id);
        if (user == null) {
            return "{\"error\": \"EMPTY ID\"}";
        } else {
            if (user.getHashedPassword().equals(oldPassWord)) {
                userMapper.updatePasswordById(id, oldPassWord, newPassWord);
                return user.toString();
            } else {
                return "{\"error\": \"EMPTY ID\"}";
            }
        }
    }
}
