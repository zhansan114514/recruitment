package com.maven.recruitment.Utills;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.Map;


public class JwtUtils {

    private static final String signKey = "RecruitmentSystem";
    private static final long time = 3600*10000;

    /**
     * 生成JWT令牌
     * @param claims payload所存储的内容
     * @return jwt JWT令牌
     */
    public static String generateJwt(Map<String, Object> claims){
        return Jwts.builder()
                .addClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS256, signKey)
                .setExpiration(new Date(System.currentTimeMillis() + time))
                .compact();
    }

    /**
     * 解析JWT令牌
     * @param jwt JWT令牌
     * @return payload中存储的值
     */
    public static Claims parseJWT(String jwt){
        return Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();
    }
}
