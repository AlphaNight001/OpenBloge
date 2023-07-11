package com.example.Alpha.Controller.PublicController;

import com.alibaba.fastjson.JSONObject;
import com.example.Alpha.Service.PublicService.TokenVeriftyService;
import com.example.Alpha.Util.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api")
@Controller
public class TokenVeriftyController {
    @Autowired
    TokenVeriftyService tokenVeriftyService;

    @ResponseBody
    @RequestMapping(value = "/veriftytoken",method = RequestMethod.POST)
    public JSONObject veriftyToken(@RequestParam("token")String token){
        JSONObject out=new JSONObject();
        Map<String,Object> map= tokenVeriftyService.veriftyToken(token);
        if (map==null){
            out.put("status",0);
            out.put("msg","当前令牌无效");
        }else {
            out.put("status",1);
            out.put("msg","令牌验证成功");
            out.put("username",map.get("username"));
            out.put("userpower",map.get("userpower"));
        }
        return out;
    }
}
