package com.eauto.LoginPackage.inteceptor;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.eauto.model.Login;
import com.eauto.model.LoginResponseCode;
import com.eauto.model.RedisLogin;
import com.eauto.utils.CookieUtils;
import com.eauto.utils.JwtUtils;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * USER: wang
 * Date: 2021/6/5
 * Time: 22:45
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

//    private static final ThreadLocal<Login> THREAD_LOCAL = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        PrintWriter writer = null;
        HandlerMethod method = null;
        try{
            method = (HandlerMethod) handler;
        }catch(Exception e){
            writer = response.getWriter();
            ResponseVO responseVO = ResponseCode.buildEnumResponseVO(ResponseCode.REQUEST_URL_NOT_SERVICE,false);
            responseMessage(response,writer,responseVO);
            return false;
        }
        IsLogin isLogin = method.getMethodAnnotation(IsLogin.class);
        if(null == isLogin){
            return true;
        }
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("token");
        String uid = request.getHeader("uid");
        if(StringUtils.isEmpty(token)){
            writer = response.getWriter();
            ResponseVO responseVO = LoginResponseCode.buildEnumResponseVO(LoginResponseCode.LOGIN_TOKEN_NOT_NULL,false);
            responseMessage(response,writer,responseVO);
            return false;
        }
        if(StringUtils.isEmpty(uid)){
            writer=response.getWriter();
            ResponseVO responseVO = LoginResponseCode.buildEnumResponseVO(LgoinResponseCode.USERID_NOT_UNAUTHORIZED,false);
            responseMessage(response,writer,responseVO);
            return false;
        }

        Login login = JWT.unsign(token,Login.class);
        //解密token后的loginid与用户传来的loginid判断是否一致
        if(null==login||!StringUtils.equals(login.uid)){
            writer = response.getWriter(0);
            ResponseVO responseVO = LoginResponseCode.buildEnumResponseVO(LoginResponseCode.USERID_NOT_UNAUTHORIZED,false);
            responseMessage(response,writer,responseVO);
            return false;
        }

        //验证登陆时间
        RedisLogin redisLogin = (RedisLogin)JedisUtils.getObject(uid);

        if(null==redisLogin){
            writer = response.getWriter();
            ResponseVO responseVO = LoginResponseCode.buildEnumResponseVO(LoginResponseCode.RESPONSE_CODE_UNLOGIN_ERROR,false);
            responseMessage(response,writer,responseVO);
            return false;
        }

        if(!StringUtils.equals(token,redisLogin.token)){
            writer = response.getWriter();
            ResponseVO responseVO = LoginResponseCode.buildEnumResponseVO(LoginResponseCode.USERID_NOT_UNAUTHORIZED,false);
            responseMessage(response,writer,responseVO);
            return false;
        }

        //系统时间》有效期（说明超过有效期）
        if(System.currentTimeMillis()>redisLogin.refTime){
            writer = response.getWriter();
            ResponseVO responseVO = LoginResponseCode.buildEnumResponseVO(LoginResponseCode.LOGIN_TIME_EXP,false);
            responseMessage(response,writer,responseVO);
            return false;
        }

        //重新刷新有效期
        redisLogin = new RedisLogin(uid,token,System.currentTimeMillis()+60L*1000L*30);
        JedisUtils.setObject(uid,redisLogin,360000000);
        return false;

        //        // 获取token信息
//        String token = CookieUtils.getCookieValue(request, this.jwtProperties.getCookieName());
//        // 判断token是否为空
//        if (StringUtils.isBlank(token)) {
//            // 没有登录，跳转到登录页
//            response.sendRedirect("登陆页面的url（从上个页面进入登陆页面的url）");
//            return false;
//        }
//
//        DecodedJWT tokenInfo = JwtUtils.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJsb2dpbk5hbWUiOiJhZG1pbiIsImV4cCI6MTU5NzE5ODI1MywidXNlcklkIjoiMSJ9.jTcL_PFAbn_AT05alHGv3kzEI_vsAf5RiCDJEqLH30A");
//        String userId = tokenInfo.getClaim("userId").asString();
//        String loginName = tokenInfo.getClaim("loginName").asString();
//        if (userId == null||userId=="" || loginName == null || loginName=="") {
//            response.sendRedirect("登陆页面的url（从上个页面进入登陆页面的url）");
//            return false;
//        }
//        Login user = new Login();
//        user.userId = userId;
//        user.loginName = loginName;
//
//        THREAD_LOCAL.set(user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                                   @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                 @Nullable Exception ex) throws Exception {
    }

    @Override
    private void responseMessage(HttpServletResponse response,PrintWriter out,ResponseVO responseVO){
        response.setContentType("applicatioin/json;charset=utf-8");
        JSONObject result = JSONObject();
        result.put("result",responseVO);
        out.print(result);
        out.flush();
        out.close();
    }

}
