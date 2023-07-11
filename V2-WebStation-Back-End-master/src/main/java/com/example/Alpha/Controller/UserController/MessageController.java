package com.example.Alpha.Controller.UserController;

import com.alibaba.fastjson.JSONObject;
import com.example.Alpha.Bean.MessageBean;
import com.example.Alpha.Service.PublicService.TokenVeriftyService;
import com.example.Alpha.Service.UserService.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/user")
public class MessageController {

    @Autowired
    TokenVeriftyService tokenVeriftyService;

    @Autowired
    MessageService messageService;
    @ResponseBody
    @RequestMapping(value = "/uploadmessage", method = RequestMethod.POST)
    public JSONObject uploadMessage(MessageBean messageBean, HttpServletRequest request) {
        JSONObject out = new JSONObject();
        Map<String, Object> map = tokenVeriftyService.veriftyToken(request.getHeader("token"));

        if (map != null) {
            Boolean bl= messageService.uploadMessage(map,messageBean);
            if (bl){
                out.put("status", "1");
                out.put("msg", "留言发布成功");
            }else {
                out.put("status", "0");
                out.put("msg", "登录状态异常");
            }
        } else {
            out.put("status", "0");
            out.put("msg", "登录状态异常");
        }
        return out;

    }

    @ResponseBody
    @RequestMapping(value = "/getallmessage",method = RequestMethod.POST)
    public JSONObject getAllMessage(){
        JSONObject out=new JSONObject();

        List<MessageBean> list=messageService.gerAllMessage();

        if(list!=null){
            out.put("result",list);
            out.put("msg","获取评论成功!");
        }else {
            out.put("msg","评论获取出错!");
        }

        return out;
    }
}
