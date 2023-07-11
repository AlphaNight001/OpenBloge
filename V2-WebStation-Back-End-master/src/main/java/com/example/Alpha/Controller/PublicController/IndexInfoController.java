package com.example.Alpha.Controller.PublicController;

import com.example.Alpha.Util.IPGetUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexInfoController {

    @RequestMapping(value = "/api/getip",method = RequestMethod.POST)
    @ResponseBody
    public String getIp(HttpServletRequest request){

        String ip;
        try {
            ip=IPGetUtil.getIP(request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return ip;
    }

}
