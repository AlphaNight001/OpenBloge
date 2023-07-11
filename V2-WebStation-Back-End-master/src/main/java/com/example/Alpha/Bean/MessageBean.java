package com.example.Alpha.Bean;

public class MessageBean {
    private Integer id;
    private Integer msg_userid;
    private String msg_username;
    private String msg_message;
    private String msg_time;

    private String user_power;




    public MessageBean() {
    }


    public MessageBean(Integer id, Integer msg_userid, String msg_username, String msg_message, String msg_time, String user_power) {
        this.id = id;
        this.msg_userid = msg_userid;
        this.msg_username = msg_username;
        this.msg_message = msg_message;
        this.msg_time = msg_time;
        this.user_power = user_power;
    }


    public String getUser_power() {
        return user_power;
    }

    public void setUser_power(String user_power) {
        this.user_power = user_power;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMsg_userid() {
        return msg_userid;
    }

    public void setMsg_userid(Integer msg_userid) {
        this.msg_userid = msg_userid;
    }

    public String getMsg_username() {
        return msg_username;
    }

    public void setMsg_username(String msg_username) {
        this.msg_username = msg_username;
    }

    public String getMsg_message() {
        return msg_message;
    }

    public void setMsg_message(String msg_message) {
        this.msg_message = msg_message;
    }

    public String getMsg_time() {
        return msg_time;
    }

    public void setMsg_time(String msg_time) {
        this.msg_time = msg_time;
    }


    @Override
    public String toString() {
        return "MessageBean{" +
                "id=" + id +
                ", msg_userid=" + msg_userid +
                ", msg_username='" + msg_username + '\'' +
                ", msg_message='" + msg_message + '\'' +
                ", msg_time='" + msg_time + '\'' +
                ", user_power='" + user_power + '\'' +
                '}';
    }
}
