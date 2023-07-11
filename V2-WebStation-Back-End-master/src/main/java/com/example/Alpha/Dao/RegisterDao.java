package com.example.Alpha.Dao;

import com.example.Alpha.Bean.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RegisterDao {

    @Select("select * from user where user_username=#{name}")
    public Integer veriftyname(String name);


    @Insert("INSERT INTO user(user_username, user_password, user_power, user_ip, user_email,user_isban) VALUES (#{user_username}, #{user_password}, #{user_power}, #{user_ip}, #{user_email},#{user_isban})")
    Integer insertUser(UserBean user);

}
