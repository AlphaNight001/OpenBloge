package com.example.Alpha.Service.UserService;

import com.example.Alpha.Bean.MessageBean;
import com.example.Alpha.Bean.UserBean;
import com.example.Alpha.Dao.LoginDao;
import com.example.Alpha.Dao.MessageDao;
import com.example.Alpha.Service.PublicService.TokenVeriftyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class MessageService {

    @Autowired
    LoginDao loginDao;

    @Autowired
    MessageDao messageDao;

    public Boolean uploadMessage(Map<String,Object> map, MessageBean messageBean){
        UserBean userBean=new UserBean();
        String username=(String) map.get("username");
        userBean.setUser_username(username);
        UserBean newUser=loginDao.loginVerify(userBean);
        messageBean.setMsg_userid(newUser.getId());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        messageBean.setMsg_time(sdf.format(new Date()));
        messageBean.setMsg_username(username);
        Integer status=messageDao.uploadMessage(messageBean);

        if (status.equals(1)){
            return true;
        }else {
            return false;
        }
    }


    public List<MessageBean> gerAllMessage(){

        List<MessageBean> list= messageDao.getAllMessage();


        return list;
    }
}
