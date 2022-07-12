package org.netunion.manager.controller;

import org.netunion.manager.mapper.UserMapper;
import org.netunion.manager.pojo.User;
import org.netunion.manager.service.keycloak.Keycloak;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户控制器
 *
 * @author David Wang
 * @version 3.0
 * @date 2020-07-12
 */

@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    Keycloak keycloak;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;
    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;

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
        if (userMapper.getByUsername(user.getUsername()) != null) {
            return "{\"error\":\"USER EXISTS\"}";
        } else {
            String password = user.getPassword();
            String encodedPassword = passwordEncoder.encode(password);
            user.setPassword(encodedPassword);
            userMapper.add(user);
            return user.toString();
        }
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
            user = userMapper.getByUsername(username);
            return user.toString();
        }
    }

    // 通过 SSO 登录的用户的信息
    @GetMapping(value = "/user/sso/info")
    public String getSsoInfo() {
        String profile = keycloak.getProfile();
        logger.info(profile);
        return profile;
    }

    @GetMapping(value = "/user/sso/reg")
    public String getSsoReg() {
        ClientRegistration keycloakRegistration = this.clientRegistrationRepository.findByRegistrationId("keycloak");
        logger.info(keycloakRegistration.toString());
        return keycloakRegistration.toString();
    }

    @GetMapping(value = "/user/sso/token")
    public OAuth2AccessToken accessToken(OAuth2AuthenticationToken authentication) {
        OAuth2AuthorizedClient authorizedClient = this.authorizedClientService.loadAuthorizedClient(
                authentication.getAuthorizedClientRegistrationId(), authentication.getName());
        OAuth2AccessToken accessToken = authorizedClient.getAccessToken();
        return accessToken;
    }
}
