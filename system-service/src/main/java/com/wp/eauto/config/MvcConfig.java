package com.wp.eauto.config;

import com.eauto.LoginPackage.inteceptor.LoginInterceptor;
import com.eauto.utils.RSAUtils;
import com.wp.eauto.system.config.JwtProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;
import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * User:Administrator
 * Date:2021/11/10
 * Time:11:40
 * Description: No Description
 */
@Configuration
@EnableConfigurationProperties(JwtProperties.class)
public class MvcConfig implements WebMvcConfigurer {
    @Autowired
    private JwtProperties jwtProperties;

    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor(jwtProperties);
    }


    /**
     * 用于添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * addpathPatterns():给拦截器添加拦截路径（默认值：/或/**）
         * excludePathPatterns():给拦截器添加放行路径
         */
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/**");
    }

    /**
     * User:Administrator
     * Date:2021/11/10
     * Time:15:50
     * Description: No Description
     */@ConfigurationProperties(prefix = "tens.jwt")
    public static class JwtProperties {
        private String secret;
        private String pubkeyPath;
        private String prikeyPath;
        private int expire;
        private PublicKey publicKey;
        private PrivateKey privateKey;
        private String cookieName;
        private Integer cookieMaxAge;
        private static final Logger logger = LoggerFactory.getLogger(JwtProperties.class);
        /**
         * @PostContruct: 在构造方法执行后执行该方法
         */
        @PostConstruct
        public void init(){
            try{
                File pubkey  = new File(pubkeyPath);
                File prikey = new File(prikeyPath);
                if(!pubkey.exists() || !prikey.exists()){
                    //如果没有密钥文件的话，就生成公钥和私钥
                    RSAUtils.generateKeyPair(pubkeyPath,prikeyPath,secret);
                }
                //获取公钥私钥
                this.publicKey = RsaUtils.getPublicKey(pubkeyPath);
                this.privateKey = RsaUtils.getPrivateKey(prikeyPath);
            }catch (Exception e){
                logger.error("初始化公钥私钥失败！",e);
                throw new RuntimeException();
            }
        }
    }
}
