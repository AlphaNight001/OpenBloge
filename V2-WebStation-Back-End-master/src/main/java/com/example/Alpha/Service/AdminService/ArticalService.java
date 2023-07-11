package com.example.Alpha.Service.AdminService;

import com.example.Alpha.Bean.ArticalBean;
import com.example.Alpha.Dao.ArticalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ArticalService {
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    ArticalDao articalDao;

    public Integer articalUpload(ArticalBean articalBean){
        articalBean.setArtical_time(sdf.format(new Date()));

        articalBean.setArtical_lastChangeTime(sdf.format(new Date()));

        Integer status= articalDao.articaUpload(articalBean);

        return status;
    }


    public List<ArticalBean> getAllArtical(){

        List list=articalDao.getAllArtical();


        return list;
    }

    public Integer delateArticalById(Integer id){

        Integer status= articalDao.delateArticalById(id);
        return status;
    }

    public ArticalBean getArticalById(Integer id){

        ArticalBean bean= articalDao.getArticalById(id);

        return bean;
    }


    public List<ArticalBean> getArticalByKindOf(String str) {

        List<ArticalBean> list=articalDao.getArticalByKindOf(str);

        return list;

    }

    public Integer updateArticalById(ArticalBean articalBean){
        articalBean.setArtical_lastChangeTime(sdf.format(new Date()));
        Integer status= articalDao.changeArtical(articalBean);

        return status;
    }

}
