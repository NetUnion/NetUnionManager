package org.netunion.manager.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登陆控制器
 *
 * @author David Wang
 * @date 2020-07-07
 * @version 1.0
 */
@RestController
public class LoginController {
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
