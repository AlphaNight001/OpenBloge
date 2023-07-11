package com.example.Alpha.Util;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTutil {
    private static final String SECRET="#*-sadwe:[lp]pdawd@#$%^&";
    public String gerateToken(Map<String,Object> claims){

        JwtBuilder jwtBuilder= Jwts.builder();
        //签发算法设置秘钥
        jwtBuilder.signWith(SignatureAlgorithm.HS256,SECRET);
        //body数据，必须唯一
        jwtBuilder.addClaims(claims);
        //签发时间
        jwtBuilder.setIssuedAt(new Date());
        //过期时间
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis()+(1000*60*480)));
        //生成TOken
        return jwtBuilder.compact();

    }




    public Map<String,Object> parseToken(String Token){
        Map<String,Object> clams=new HashMap<>();

        JwtParser jwtParser = Jwts.parser().setSigningKey(SECRET);

        try {
            clams=jwtParser.parseClaimsJws(Token).getBody();
            clams.put("msg","tokenPass");
        }catch (Exception e){
            clams.put("msg","tokenBad");
        }

        return clams;
    }
}
