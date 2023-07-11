package com.example.Alpha.Controller.PublicController;

import com.alibaba.fastjson.JSONObject;
import com.example.Alpha.Service.PublicService.CheckArticalQuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class CheckArticalQuantityController {

    @Autowired
    CheckArticalQuantityService checkArticalQuantityService;

    @ResponseBody
    @RequestMapping(value = "/api/checkarticalquantity" ,method = RequestMethod.POST)
    public JSONObject checkArticalQuantity(){
        JSONObject out=new JSONObject();

        List<Map<String,Object>> list= checkArticalQuantityService.checkArticalQuantity();

        out.put("result",list);

        return out;
    }



    @ResponseBody
    @RequestMapping(value = "/api/checkarticaltag")
    public JSONObject checkArticalTag(){
        JSONObject out=new JSONObject();

        List<Map<String,Object>> list= checkArticalQuantityService.checkArticalTag();

        out.put("result",list);

        return out;
    }


}
