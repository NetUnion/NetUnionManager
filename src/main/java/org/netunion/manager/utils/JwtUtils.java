package org.netunion.manager.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Calendar;
import java.util.Map;

public class JwtUtils {
    private static String SECRET_KEY = "ZheLiYaoGai"; //部署时要更换

    public static String getToken(Map<String, String> map) {
        JWTCreator.Builder builder = JWT.create();
        map.forEach((k, v) -> builder.withClaim(k, v));
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 30);
        builder.withExpiresAt(calendar.getTime());
        return builder.sign(Algorithm.HMAC256(SECRET_KEY)).toString();
    }

    public static void verifyToken(String token) {
        JWT.require(Algorithm.HMAC256(SECRET_KEY)).build().verify(token);
    }

    public static String decodeToken(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET_KEY)).build().verify(token).getSubject();
    }
}
