package com.example.Alpha.Controller.AdminController;

import com.alibaba.fastjson.JSONObject;
import com.example.Alpha.Bean.MessageBean;
import com.example.Alpha.Dao.MessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/api/admin")
@Controller
public class AdminMessageController {

    @Autowired
    MessageDao messageDao;

    @ResponseBody
    @RequestMapping(value = "/delatemsg",method = RequestMethod.POST)
    public JSONObject getAllMessage(@RequestBody MessageBean msg){
        JSONObject out=new JSONObject();
        Integer status= messageDao.delateMsgByID(msg.getId());
        if (status==1){
            out.put("msg","删除成功");
            out.put("status",status);
        }else {
            out.put("msg","出错了");
            out.put("status",status);
        }

        return out;
    }


}
