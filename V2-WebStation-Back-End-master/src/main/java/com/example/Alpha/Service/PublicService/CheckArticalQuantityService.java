package com.example.Alpha.Service.PublicService;

import com.example.Alpha.Dao.ArticalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CheckArticalQuantityService {

    @Autowired
    ArticalDao articalDao;
    public List<Map<String,Object>> checkArticalQuantity(){
        List<Map<String,Object>> map=new ArrayList<>();

        map=articalDao.checkArticalQuantity();

        return map;

    }


    public List<Map<String,Object>> checkArticalTag(){



        return articalDao.checkArticalTag();
    }


}
