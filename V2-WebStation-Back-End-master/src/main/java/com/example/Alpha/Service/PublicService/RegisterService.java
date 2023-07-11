package com.example.Alpha.Service.PublicService;

import com.alibaba.fastjson.JSONObject;
import com.example.Alpha.Bean.UserBean;
import com.example.Alpha.Dao.RegisterDao;
import com.example.Alpha.Util.EmailService;
import com.example.Alpha.Util.IPGetUtil;
import com.example.Alpha.Util.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RegisterService {

    @Autowired
    RegisterDao registerDao;

    @Autowired
    EmailService emailService;

    public Integer veriftyname(String name) {

        Integer status = registerDao.veriftyname(name);

        return status;
    }

    public boolean getEmail(String email) throws Exception {
        String code = RandomUtils.generateCode();

        if (emailService.getCode(email) != null) {

            emailService.delateCode(email);
            emailService.putCode(email, code);
            emailService.sendVerificationCode(email, code);


            return true;
        } else {

            emailService.putCode(email, code);


            emailService.sendVerificationCode(email, code);


            return true;
        }
    }


    public Boolean veriftyEmail(String email, String code) {

        EmailService.VerificationCode verificationCode = emailService.getCode(email);

        if (verificationCode != null) {
            long outTime = System.currentTimeMillis() - verificationCode.getCreateTime();
            if (code.equals(verificationCode.getCode()) && outTime < 300000) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    public Boolean registerUser(UserBean userBean, HttpServletRequest request) {
        String ip;
        try {
            ip = IPGetUtil.getIP(request);
            userBean.setUser_ip(ip);
            userBean.setUser_power("0");
            userBean.setUser_isban(false);
        } catch (Exception e) {
            System.out.println("IP获取失败");
        }

        Integer status = registerDao.insertUser(userBean);
        if (status.equals(1)) {
            return true;
        } else {
            return false;
        }
    }


}
