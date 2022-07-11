package org.netunion.manager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 安全配置
 *
 * @author David Wang
 * @date 2020-07-08
 * @version 2.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig{
    @Bean
    // 设置密码加密方式
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain httpSecurity(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/index").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/index")
                .and()
                .oauth2Login()
                .defaultSuccessUrl("/index")
                .and()
                .oauth2Client()
                .and()
                .csrf().disable()
                .sessionManagement()
                .maximumSessions(1);
        return http.build();
    }
}
