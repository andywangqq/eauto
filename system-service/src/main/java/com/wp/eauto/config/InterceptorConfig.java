package com.wp.eauto.config;

import com.eauto.inteceptor.LogInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class InterceptorConfig extends  WebMvcConfigurationSupport {

    /*
     * 将跨域拦截器交给spring容器托管
     * @return: com.haust.online_class.interceptor.CorsInterceptor
     * @create: 2020/10/21 12:20
     * @author: csp1999
     */
    @Bean
    public LogInterceptor logInterceptor() {
        return new LogInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor())
                .addPathPatterns("/**")//拦截所有的路径
                .excludePathPatterns("/employee/login");

        // 添加注册器
        super.addInterceptors(registry);
    }
}
