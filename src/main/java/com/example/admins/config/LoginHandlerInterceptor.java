package com.example.admins.config;

import com.example.admins.bean.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 定义拦截器
 * @author: zheng-fx
 * @time: 2020/2/25 0025 17:25
 */
@Slf4j
@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {
    
    //用户进入控制器之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserInfo userLogin = (UserInfo) request.getSession().getAttribute("user_login");
        if(userLogin==null){
            log.info("用户未登陆");
            response.sendRedirect(request.getContextPath() + "/page/login");
//            request.getRequestDispatcher("/user/login").forward(request,response);
            return false;
        }
        /*判断是否未ajax请求*/
        if("XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))){
            log.info("是ajax请求");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Content-Type", "text/json;charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            return true;
        }
        
        return true;
    }
    
    //进入控制器之后，视图渲染之前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        
    }

    //视图渲染之后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


}
