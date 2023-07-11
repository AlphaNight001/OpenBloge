package com.example.Alpha.Service.PublicService;

import com.example.Alpha.Bean.UserBean;
import com.example.Alpha.Dao.LoginDao;
import com.example.Alpha.Dao.UserDao;
import com.example.Alpha.Util.IPGetUtil;
import com.example.Alpha.Util.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginService {
    @Autowired
    LoginDao loginDao;

    @Autowired
    UserDao userDao;

    public UserBean loginVerify(UserBean userBean, HttpServletRequest request) {
        UserBean newUser = loginDao.loginVerify(userBean);
        String ip = null;
        if (newUser == null) {
            return null;
        }
        if (!userBean.getUser_password().equals(newUser.getUser_password())) {
            return null;
        }
        try {
            ip = IPGetUtil.getIP(request);
        } catch (Exception e) {
            System.out.println("ip获取出错");
        }
        newUser.setUser_lastip(ip);
        userDao.setLastIp(newUser);
        Map<String, Object> map = new HashMap<>();
        map.put("username", newUser.getUser_username());
        map.put("userpower", newUser.getUser_power());
        map.put("ip", ip);
        JWTutil jwTutil = new JWTutil();
        String Token = jwTutil.gerateToken(map);
        newUser.setUser_token(Token);
        return newUser;
    }
}
