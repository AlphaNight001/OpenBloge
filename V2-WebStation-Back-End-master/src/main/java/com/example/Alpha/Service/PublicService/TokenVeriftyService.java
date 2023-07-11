package com.example.Alpha.Service.PublicService;

import com.example.Alpha.Util.JWTutil;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TokenVeriftyService {

    public Map<String,Object> veriftyToken(String token){
        JWTutil jw=new JWTutil();

        Map<String,Object> map= jw.parseToken(token);

        if (map.get("msg").equals("tokenPass")){
            return map;
        }else {
            return null;
        }

    }

}
