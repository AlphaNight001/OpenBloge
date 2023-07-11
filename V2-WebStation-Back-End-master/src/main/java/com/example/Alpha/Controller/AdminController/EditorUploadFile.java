package com.example.Alpha.Controller.AdminController;

import com.alibaba.fastjson.JSONObject;
import com.example.Alpha.Bean.DelimgArrBean;
import com.example.Alpha.Bean.ImgBean;
import com.example.Alpha.Service.AdminService.EditorUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.*;

@Controller
@RequestMapping("/api/admin")
public class EditorUploadFile {
    @Autowired
    private EditorUploadService uploadService;

    @RequestMapping(value = "/uploadimg", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject UploadImg(@RequestParam("file") MultipartFile file) {
        JSONObject out=new JSONObject();
        if (!file.isEmpty()){
            ImgBean imgBean=uploadService.upLoadImg(file);
            Map<String,Object> arr=new HashMap<>();
            arr.put("url",imgBean.getPath());
            out.put("data",arr);
            return out;

        }else {
            out.put("errno",0);
            return out;
        }

    }


    @ResponseBody
    @RequestMapping(value = "/delateimg",method = RequestMethod.POST)
    public void delateImg(@RequestBody DelimgArrBean imgarr){
        uploadService.delateImg(imgarr.getImgarr());
    }
}
