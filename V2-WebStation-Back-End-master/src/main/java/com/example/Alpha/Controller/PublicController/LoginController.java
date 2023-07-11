package com.example.Alpha.Controller.PublicController;

import com.alibaba.fastjson.JSONObject;
import com.example.Alpha.Bean.UserBean;
import com.example.Alpha.Service.PublicService.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;


    @ResponseBody
    @RequestMapping(value = "/api/loginctrl")
    public JSONObject login(@RequestBody JSONObject user, HttpServletRequest request) {
        JSONObject out = new JSONObject();
        UserBean userBean = new UserBean();
        userBean.setUser_password(user.getString("password"));
        userBean.setUser_username(user.getString("username"));
        UserBean newUser = loginService.loginVerify(userBean,request);

        if (newUser==null){
            out.put("status",0);
            out.put("msg","账号密码验证失败");
            return out;
        }
        if (newUser.getUser_isban()){
            out.put("status",202);
            out.put("msg","账号已经被封禁");
            return out;
        }
        if (newUser!=null){
            out.put("status",1);
            out.put("msg","账号密码验证成功");
            out.put("username",newUser.getUser_username());
            out.put("token",newUser.getUser_token());
            out.put("userpower",newUser.getUser_power());
            return out;
        }

        return out;
    }


}
