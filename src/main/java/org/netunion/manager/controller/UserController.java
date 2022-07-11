package org.netunion.manager.controller;

import org.netunion.manager.mapper.UserMapper;
import org.netunion.manager.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户控制器
 *
 * @author David Wang
 * @version 2.0
 * @date 2020-07-08
 */

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    //查询单个用户
    @GetMapping("/user/{username}")
    public User getUser(@PathVariable String username) {
        return userMapper.getByUsername(username);
    }

    //查询所有用户
    @GetMapping("/user")
    public List<User> getAll() {
        return userMapper.getAll();
    }

    //增加用户
    @PostMapping(value = "/user/add", produces = "application/json;charset=UTF-8")
    public String addMember(@RequestBody User user) {
        userMapper.add(user);
        return user.toString();
    }

    //删除用户
    @DeleteMapping(value = "/user/delete/{username}")
    public String deleteUser(@PathVariable("username") String username) {
        User user = userMapper.getByUsername(username);
        if (user != null) {
            userMapper.delete(username);
            return user.toString();
        } else {
            return "{\"error\": \"NO USER\"}";
        }
    }

    //更新用户密码
    @PostMapping(value = "/user/update/password")
    public String updatePassword(@RequestParam String username,
                                 @RequestParam String oldPassword,
                                 @RequestParam String newPassword) {
        User user = userMapper.getByUsername(username);
        if (user == null) {
            return "{\"error\": \"NO USER\"}";
        } else if (passwordEncoder.matches(oldPassword, user.getPassword())) {
            newPassword = passwordEncoder.encode(newPassword);
            userMapper.updatePasswordByUsername(username, newPassword);
            return "{\"success\": \"PASSWORD CHANGED\"}";
        } else {
            return "{\"error\": \"WRONG PASSWORD\"}";
        }
    }

    //更新用户权限
    @PostMapping(value = "/user/update/authority")
    public String updateAuthority(@RequestParam String username,
                                 @RequestParam String authority) {
        User user = userMapper.getByUsername(username);
        if (user == null) {
            return "{\"error\": \"NO USER\"}";
        } else {
            userMapper.updateAuthorityByUsername(username, authority);
            return user.toString();
        }
    }
}
