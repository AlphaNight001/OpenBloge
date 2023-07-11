package com.example.Alpha.Interceptor;

import com.example.Alpha.Service.PublicService.TokenVeriftyService;
import com.example.Alpha.Util.JWTutil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class AdminInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        TokenVeriftyService tokenVeriftyService=new TokenVeriftyService();
        Map<String,Object> map= tokenVeriftyService.veriftyToken(request.getHeader("token"));



        if (map!=null&&map.get("userpower").equals("1")){
            return true;
        }
        else {
            response.getWriter().write("No Power!!!");
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 在整个请求完成之后，也就是视图渲染完毕之后进行调用，通常用于清理资源等工作
    }
}
