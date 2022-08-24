package com.eauto.inteceptor;

import com.eauto.base.ResultCode;
import com.eauto.base.ResultModel;
import com.eauto.utils.TokenUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * USER: wang
 * Date: 2021/6/5
 * Time: 22:45
 */
@Component
public class LogInterceptor implements HandlerInterceptor {

    private final Logger log = LoggerFactory.getLogger(getClass().getName());

    private static final ThreadLocal startTimeThreadLocal = new NamedThreadLocal("ThreadLocal StartTime");

    /**
     * 预处理
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object hander) throws Exception {
        //因为是在请求头中发送token，所以第一次请求的方法为"OPTIONS"，具体可以看TCP/IP协议
        String method = request.getMethod();
        if ("OPTIONS".equalsIgnoreCase(method)) {
            return true;
        }
        //表示接受任意域名的请求,也可以指定域名
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
        //该字段可选，是个布尔值，表示是否可以携带cookie
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        long beginTime = System.currentTimeMillis(); //开始时间
        startTimeThreadLocal.set(beginTime); //线程绑定变量(该数据只有当前请求的线程可见)
        log.info("开始计时: {}", new SimpleDateFormat("hh:mm:ss.SSS").format(beginTime));

        response.setCharacterEncoding("UTF-8");
        //Authorization参数是前台放在headler中的key
        String token = request.getHeader("token");
        if (token == null) {
            ResultModel result = ResultModel.failure(ResultCode.USER_NOT_LOGGEN_IN);
            doResponse(response, result);
        } else {
            try {
               if( !TokenUtils.verify(token)){
                   ResultModel result = ResultModel.failure(ResultCode.USER_TOKEN_EXPIRED);
                   doResponse(response, result);
               }
               request.setAttribute("key",token);
                return true;
            } catch (ExpiredJwtException e1) {
                ResultModel result = ResultModel.failure(ResultCode.USER_TOKEN_EXPIRED);
                doResponse(response, result);
            } catch (UnsupportedJwtException e2) {
                ResultModel result = ResultModel.failure(ResultCode.USER_TOKEN_ERROR);
                doResponse(response, result);
            } catch (Exception e3) {
                ResultModel result = ResultModel.failure(ResultCode.USER_NOT_LOGGEN_IN);
                doResponse(response, result);
            }
        }
        return false;
    }

    @SneakyThrows
    private void doResponse(HttpServletResponse response, ResultModel resultVO) {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String s = new ObjectMapper().writeValueAsString(resultVO);
        out.print(s);
        out.flush();
        out.close();
    }

    /**
     * 返回处理
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            log.info("ViewName: " + modelAndView.getViewName());
        }
    }

    /**
     * 后处理
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
        // 保存日志
        //LogUtils.saveLog(request, handler, ex, null);
        //输出日志信息

        log.info("访问地址：" + request.getRequestURI() + "，执行方式：" + request.getMethod());
        Locale form = Locale.SIMPLIFIED_CHINESE;
        long beginTime = Long.valueOf(String.valueOf(startTimeThreadLocal.get())); //得到线程绑定的局部变量(开始时间)

        long endTime = System.currentTimeMillis(); //结束时间
        log.info("计时结束：{},用时{}秒", new SimpleDateFormat("hh:mm:ss.SSS").format(endTime), (endTime - beginTime) / 1000);
    }

}
