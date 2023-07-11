package com.example.Alpha.Controller.AdminController;


import com.alibaba.fastjson.JSONObject;
import com.example.Alpha.Bean.UserBean;
import com.example.Alpha.Service.AdminService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/admin")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getalluser",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getAllUser(){
        JSONObject out=new JSONObject();
        List<UserBean> userlist=new ArrayList<>();
        userlist=userService.getAllUser();
        out.put("userlist",userlist);
        out.put("msg","用户集合");
        return out;
    }


    @ResponseBody
    @RequestMapping(value = "/changeuserstatus",method = RequestMethod.POST)
    public JSONObject changeUserStatus(@RequestBody UserBean userBean){
        JSONObject out=new JSONObject();
        Integer status= userService.changeUserStatus(userBean);
        if (status.equals(1)){
            out.put("status",status);
            out.put("msg","状态设置成功");
        }else {
            out.put("status",status);
            out.put("msg","权限设置失败");
        }
        return out;
    }


    @ResponseBody
    @RequestMapping(value = "/delateuserbyid",method = RequestMethod.POST)
    public JSONObject delateUserByID(@RequestParam("id") Integer id){
        JSONObject out=new JSONObject();

        Integer status=userService.delateUserByID(id);
        
        if (status==1){
            out.put("status",status);
            out.put("msg","删除用户成功");
        }else {
            out.put("status",status);
            out.put("msg","出错了!!");
        }

        return out;
    }


}
