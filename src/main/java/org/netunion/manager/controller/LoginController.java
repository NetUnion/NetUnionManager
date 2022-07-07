package org.netunion.manager.controller;

import org.netunion.manager.mapper.UserMapper;
import org.netunion.manager.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.netunion.manager.utils.JwtUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 登陆控制器
 *
 * @author David Wang
 * @version 1.0
 * @date 2020-07-07
 */
@RestController
public class LoginController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    //校验用户名密码
    @PostMapping(value = "/check")
    public boolean check(@RequestParam String userName, @RequestParam String hashedPassword) {
        User user = userMapper.getByUserName(userName);
        if (user == null) return false;
        else return user.getHashedPasswd().equals(hashedPassword);
    }
    //判断是否为有效用户并生成token
    @PostMapping(value = "/login/token", produces = "application/json;charset=UTF-8")
    public String getToken(@RequestBody User user) {
        if (check(user.getUserName(), user.getHashedPasswd())) {
            Map<String, String> payload = new HashMap<>();
            payload.put("userName", user.getUserName());
            payload.put("hashedPassword", user.getHashedPasswd());
            payload.put("time", String.valueOf(System.currentTimeMillis()));
            return JwtUtils.getToken(payload);
        }
        else {
            return "LOGIN ERROR";
        }
    }
}
