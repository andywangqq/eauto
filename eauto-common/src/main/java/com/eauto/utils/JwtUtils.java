package com.eauto.utils;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * User:Administrator
 * Date:2021/11/10
 * Time:15:07
 * Description: No Description
 */
public class JwtUtils {

    //秘钥 盐
    private static final String SECRET = "SmyC47re$ML%F72x6koqyUQ0XLQOasdsad";

    private static final String EXP = "exp";

    private static final String PAYLOAD = "payload";

    //加密
    public static <T> String sign(T object,long maxAge) throws Exception{
        try{
            final JWTSigner signer = new JWTSigner(SECRET);
            final Map<String,Object> claims = new HashMap<String,Object>();
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(object);
            claims.put(PAYLOAD,jsonString);
            claims.put(EXP,System.currentTimeMillis()+maxAge);
            return signer.sign(claims);
        }catch(Exception e){
            return null;
        }
    }

    //解密
    public static<T> T unsign(String jwt,Class<T> classT) throws Exception{
        final JWTVerifier verifier = new JWTVerifier(SECRET);
        try{
            final Map<String,Object> claims = verifier.verify(jwt);
            if(claims.containsKey(EXP) && claims.containsKey(PAYLOAD)){
                String json = (String)claims.get(PAYLOAD);
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(json,classT);
            }
            return null;
        }catch(Exception e){
            return null;
        }
    }
}
