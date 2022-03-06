package com.eauto.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * USER: wang
 * Date: 2021/6/5
 * Time: 22:35
 */
public class TokenUtils {

    /**
     * token秘钥，请勿泄露，请勿随便修改
     */
    public static final String TOKEN_SECRET = "WPZSFasuserHELLOnm916s20220304me";

    /**
     * token 过期时间: 30天
     */
    public static final long EXPIRE_DATE = 30 * 60 * 100000;

    /**
     * 生产token
     *
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    public static String token(String username, String password) throws Exception {
        String token = "";
        try {
            //过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_DATE);
            //密钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String, Object> header = new HashMap<String, Object>();
            header.put("type", "JWT");
            header.put("alg", "HS256");
            //携带username,password信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("username", username)
                    .withClaim("password", password)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return token;
    }


    /**
     * 验证token
     * @param token
     * @return
     */
    public static boolean verify(String token) {
        try {
           Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
           JWTVerifier verifier = JWT.require(algorithm).build();
           DecodedJWT jwt = verifier.verify(token);
           return true;
        } catch (Exception e) {
             e.printStackTrace();
            return false;
        }
    }


}