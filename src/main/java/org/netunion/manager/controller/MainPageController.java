package org.netunion.manager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 主页控制
 *
 * @author David Wang
 * @date 2020-07-06
 * @version 1.0
 */
@RestController
public class MainPageController {
    @GetMapping("/index")
    @ResponseBody
    public String getMainPage() {
        return "Welcome to NetUnion Manager!";
    }
}
