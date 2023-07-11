package com.example.Alpha.Service.AdminService;

import com.example.Alpha.Bean.UpdateBean;
import com.example.Alpha.Dao.UpdateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UpdateService{

    @Autowired
    UpdateDao updateDao;

    public Integer updateGo(UpdateBean updateBean){

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        updateBean.setUpdate_Time(sdf.format(new Date()));

        Integer status=updateDao.updateGo(updateBean);


        return status;
    }

    public List<UpdateBean> selectAllUpdate(){
        UpdateBean updateBean=new UpdateBean();

        List<UpdateBean> list= new ArrayList<>();

        list=updateDao.selectAllUpdate();

        return list;
    }

    public Integer deleteUpdateByID(Integer id){
        Integer status=updateDao.delateUpdateByID(id);
        return status;
    }


    public UpdateBean queryUpdateByID(Integer id){

        UpdateBean updateBean=updateDao.queryUpdateByID(id);

        return updateBean;
    }


    public Integer changeUpdate(UpdateBean updateBean){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        updateBean.setUpdate_Time(sdf.format(new Date()));

        return updateDao.changeUpdateByID(updateBean);
    }




}
