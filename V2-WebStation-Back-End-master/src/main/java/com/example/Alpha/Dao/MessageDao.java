package com.example.Alpha.Dao;

import com.example.Alpha.Bean.MessageBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface MessageDao {


    @Insert("insert into message(msg_userid,msg_username,msg_message,msg_time) value(#{msg_userid},#{msg_username},#{msg_message},#{msg_time})")
    public Integer uploadMessage(MessageBean messageBean);

    @Select("SELECT message.*, user.user_power FROM message INNER JOIN user ON message.msg_userid = user.id;")
    public List<MessageBean> getAllMessage();

    @Delete("DELETE FROM message WHERE id = #{id};")
    public Integer delateMsgByID(Integer id);

}
