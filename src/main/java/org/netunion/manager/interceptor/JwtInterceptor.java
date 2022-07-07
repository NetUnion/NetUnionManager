package org.netunion.manager.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.netunion.manager.utils.JwtUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT 拦截器
 *
 * @author David Wang
 * @date 2020-07-07
 * @version 1.0
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            return true;
        }

        Map<String, Object> map = new HashMap<>();
        String token = request.getHeader("token");
        try {
            JwtUtils.verifyToken(token);
            return true;
        } catch (SignatureVerificationException e) {
            map.put("msg", "签名错误");
            map.put("status", 401);
        } catch (TokenExpiredException e) {
            map.put("msg", "token过期");
            map.put("status", 401);
        } catch (AlgorithmMismatchException e) {
            map.put("msg", "算法错误");
            map.put("status", 401);
        } catch (Exception e) {
            map.put("msg", "token错误");
            map.put("status", 401);
        }
        map.put("state", false);
        Map<String, Object> res = new HashMap<>();
        res.put("data", map);
        String json = new ObjectMapper().writeValueAsString(res);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().write(json);
        return false;
    }
}
