package com.eauto.model;

import java.util.HashMap;
import java.util.Map;

/**
 * User:Administrator
 * Date:2021/11/10
 * Time:17:57
 * Description: No Description
 */
public enum LoginResponseCode {
    USERID_NOT_NULL(3001,"用户id不能为空"),
    LOGIN_TOKEN_NOT_NULL(3002,"登陆token不能为空"),
    USERID_NOT_UNAUTHORIZED(3003,"用户token或ID验证不通过"),
    RESPONSE_CODE_UNLOGIN_ERROR(421,"未登录异常"),
    LOGIN_TIME_EXP(3004,"登陆时间超长，请重新登陆");
    public int code;
    public String message;
    private LoginResponseCode(int code,String message){
        this.code = code;
        this.message = message;
    }
//    public static Map<String,Object> buildEnumResponseVO(LoginResponseCode responseCode, Object data){
//        return new ResponseVO(responseCode.code,responseCode.message,data);
//    }
    public static Map<String,Object> buildReturnMap(LoginResponseCode responseCode,Object data){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",responseCode.code);
        map.put("message",responseCode.message);
        map.put("data",data);
        return map;
    }
}
