package com.eauto.LoginPackage.inteceptor;

import com.eauto.token.TokenUtils;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * USER: wang
 * Date: 2021/6/5
 * Time: 22:45
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object hander) throws Exception {
        response.setCharacterEncoding("UTF-8");
        //Authorization参数是前台放在headler中的key
        String token = request.getHeader("Authorization");
        if(token != null){
            boolean flag = TokenUtils.verify(token);
            if(flag){
                return true;
            }
        }
        System.out.println("token认证失败，请登录...");//跳转
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                                   @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                 @Nullable Exception ex) throws Exception {
    }

}
