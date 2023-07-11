package com.example.Alpha.Dao;

import com.example.Alpha.Bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface LoginDao {

    @Select("select * from user where user_username=#{user_username}")
    public UserBean loginVerify(UserBean userBean);
}
