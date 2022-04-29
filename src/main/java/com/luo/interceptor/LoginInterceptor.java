package com.luo.interceptor;

import com.luo.utils.SystemConstant;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         * 拦截器
         * 首先知道它有没有登录，没登录return false
         * 登录的话 return true
         *
         */
        Object login = request.getSession().getAttribute(SystemConstant.LOGINUSER);
        if (login!=null){
            return true;
        }
        response.sendRedirect(request.getContextPath()+"/admin/login.html");
        return false;
    }

}
