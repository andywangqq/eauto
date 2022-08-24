package com.eauto.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.eauto.base.ResultCode;
import com.eauto.base.ResultModel;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.UnsupportedJwtException;
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
     * token 过期时间: 10天
     */
    public static final int calendarField = Calendar.DATE;
    public static final int calendarInterval = 10;

    /**
     * 生产token
     *
     * @return
     * @throws Exception
     */
    public static String token(String userId) throws Exception {
        String token = "";
        Date iatDate = new Date();
        // expire time
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(calendarField, calendarInterval);
        Date expiresDate = nowTime.getTime();
        try {
            //设置头部信息
            Map<String, Object> header = new HashMap<String, Object>();
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            //携带username,password信息，生成签名
            token = JWT.create()
                    .withHeader(header)// header
                    .withClaim("iss", "Service") // payload
                    .withClaim("aud", "APP")
                    .withClaim("user_id", null == userId ? null : userId)
                    .withIssuedAt(iatDate) // sign time
                    .withExpiresAt(expiresDate) // expire time
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));// signature
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