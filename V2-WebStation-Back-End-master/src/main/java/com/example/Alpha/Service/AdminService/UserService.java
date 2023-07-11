package com.example.Alpha.Service.AdminService;

import com.example.Alpha.Bean.UserBean;
import com.example.Alpha.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public List<UserBean> getAllUser(){
        return userDao.getAllUser();
    }


    public Integer changeUserStatus(UserBean userBean){
        if (!userBean.getUser_power().equals(null)&&!userBean.getUser_isban().equals(null)){
            return userDao.changeUserStatus(userBean);
        }else {
            return 0;
        }

    }


    public Integer delateUserByID(Integer id){

        return userDao.delateUserByID(id);
    }



}
