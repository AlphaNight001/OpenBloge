package com.example.Alpha.Bean;

public class UserBean {

    private Integer id;

    private String user_username;

    private String user_password;

    private String user_power;

    private String user_token;

    private String user_ip;

    private String user_email;

    private Boolean user_isban;

    private String user_lastip;

    public UserBean() {
    }

    public UserBean(Integer id, String user_username, String user_password, String user_power, String user_token, String user_ip, String user_email, Boolean user_isban, String user_lastip) {
        this.id = id;
        this.user_username = user_username;
        this.user_password = user_password;
        this.user_power = user_power;
        this.user_token = user_token;
        this.user_ip = user_ip;
        this.user_email = user_email;
        this.user_isban = user_isban;
        this.user_lastip = user_lastip;
    }


    public String getUser_lastip() {
        return user_lastip;
    }

    public void setUser_lastip(String user_lastip) {
        this.user_lastip = user_lastip;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_power() {
        return user_power;
    }

    public void setUser_power(String user_power) {
        this.user_power = user_power;
    }

    public String getUser_token() {
        return user_token;
    }

    public void setUser_token(String user_token) {
        this.user_token = user_token;
    }

    public String getUser_ip() {
        return user_ip;
    }

    public void setUser_ip(String user_ip) {
        this.user_ip = user_ip;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public Boolean getUser_isban() {
        return user_isban;
    }

    public void setUser_isban(Boolean user_isban) {
        this.user_isban = user_isban;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", user_username='" + user_username + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_power='" + user_power + '\'' +
                ", user_token='" + user_token + '\'' +
                ", user_ip='" + user_ip + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_isban=" + user_isban +
                ", user_lastip='" + user_lastip + '\'' +
                '}';
    }
}
