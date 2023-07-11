package com.example.Alpha.Controller.AdminController;

import com.alibaba.fastjson.JSONObject;
import com.example.Alpha.Bean.UpdateBean;
import com.example.Alpha.Service.AdminService.UpdateService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/admin")
public class UpdateController {
    @Autowired
    UpdateService updateService;

    @ResponseBody
    @RequestMapping(value = "updatego",method = RequestMethod.POST)
    public JSONObject updateGo(@RequestBody UpdateBean update){
        JSONObject out=new JSONObject();
        Integer status= updateService.updateGo(update);

        if (status==1){
            out.put("status",status);
            out.put("msg","文章上传成功");

        }else {

            out.put("status",status);
            out.put("msg","文章上传失败");
        }
        return out;
    }


    @ResponseBody
    @RequestMapping(value = "selectallupdate",method = RequestMethod.POST)
    public JSONObject selectAllUpdate(){
        JSONObject out = new JSONObject();

        List<UpdateBean> list= updateService.selectAllUpdate();

        if (list!=null){
            out.put("list",list);
            out.put("status",1);
        }else {
            out.put("msg","查询失败！");
            out.put("status",0);
        }


        return out;
    }

    @ResponseBody
    @RequestMapping(value = "delateupdatebyid",method = RequestMethod.POST)
    public Integer deleteUpdateByID(@RequestParam(value = "id") Integer id){
        return updateService.deleteUpdateByID(id);
    }

    @ResponseBody
    @RequestMapping(value = "queryupdatebyid",method = RequestMethod.POST)
    public JSONObject queryUpdateByID(@RequestParam(value = "id") Integer id){
        JSONObject out=new JSONObject();


        UpdateBean updateBean= updateService.queryUpdateByID(id);

        if (updateBean!=null){
            out.put("msg","查询成功!!");
            out.put("status",1);
            out.put("info",updateBean);
        }else {
            out.put("msg","查询失败!!");
            out.put("status",0);
            out.put("info",updateBean);
        }


        return out;
    }


    @ResponseBody
    @RequestMapping(value = "changeupdate",method = RequestMethod.POST)
    public JSONObject changeUpdate(@RequestBody UpdateBean updateBean){
        Integer status= updateService.changeUpdate(updateBean);
        JSONObject out = new JSONObject();
        if (status==1){
            out.put("msg","日志修改成功！！");
            out.put("status",status);
        }else {
            out.put("msg","日志修改失败");
            out.put("status",status);
        }
        return out;
    }



}
