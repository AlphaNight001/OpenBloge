package com.example.Alpha.Test.TestController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@Controller
public class test1 {
    @ResponseBody
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public void test1(@RequestBody String[] data){

        System.out.println(data);

    }

}
