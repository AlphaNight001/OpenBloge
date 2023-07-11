package com.example.Alpha.Controller.PublicController;

import com.alibaba.fastjson.JSONObject;
import com.example.Alpha.Bean.UserBean;
import com.example.Alpha.Service.PublicService.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping("/api")
public class RegisterController {





    @Autowired
    RegisterService registerService;




    @ResponseBody
    @RequestMapping(value = "/veriftyname",method = RequestMethod.POST)
    public JSONObject veriftyName(@RequestParam String name){
        JSONObject out=new JSONObject();

        Integer status=registerService.veriftyname(name);
        if(status==null){
            out.put("status",1);
            out.put("msg","昵称唯一，可以使用！");
        }else {
            out.put("status",0);
            out.put("msg","昵称不唯一，禁止使用！");
        }
        return out;
    }


    @ResponseBody
    @RequestMapping(value = "veriftyemail",method = RequestMethod.POST)
    public JSONObject veriftyEmail(@RequestParam  String email,String code){
        JSONObject out=new JSONObject();
        Boolean bl= registerService.veriftyEmail(email,code);

        if (bl){
            out.put("status",1);
            out.put("msg","验证码验证通过！");
        }else {
            out.put("status",0);
            out.put("msg","验证码验证失败！");
        }
        return out;
    }

    @ResponseBody
    @RequestMapping(value = "/getemail",method = RequestMethod.POST)
    public void getEmail(@RequestParam String email) throws Exception{
        Boolean bl=registerService.getEmail(email);
    }


    @ResponseBody
    @RequestMapping(value = "/registeruser",method = RequestMethod.POST)
    public JSONObject registerUser(UserBean userBean, HttpServletRequest request){
        JSONObject out=new JSONObject();
        Boolean bl= registerService.registerUser(userBean,request);


        if (bl){
            if (bl){
                out.put("status",1);
                out.put("msg","注册成功");
            }else {
                out.put("status",0);
                out.put("msg","注册失败");
            }
        }
        return out;
    }


}
