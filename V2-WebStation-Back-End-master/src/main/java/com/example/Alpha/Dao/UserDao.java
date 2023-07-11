package com.example.Alpha.Dao;

import com.example.Alpha.Bean.UserBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select id,user_username,user_power,user_token,user_ip,user_email,user_isban,user_lastip from user;")
    public List<UserBean> getAllUser();

    @Update("UPDATE user SET user_lastip = #{user_lastip} WHERE id = #{id};")
    public Integer setLastIp(UserBean userBean);


    @Update("UPDATE user set user_power=#{user_power},user_isban=#{user_isban} where id=#{id}")
    public Integer changeUserStatus(UserBean userBean);

    @Delete("DELETE FROM user WHERE id = #{id};")
    public Integer delateUserByID(Integer id);




}
