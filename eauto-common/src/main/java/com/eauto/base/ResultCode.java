package com.eauto.base;

/**
 * User:Administrator
 * Date:2021/9/27
 * Time:15:55
 * Description: No Description
 */
public enum ResultCode {

 /* 成功状态码 */
 SUCCESS(1,"成功"),

 /*参数错误: 1001-1999*/
 PARAM_IS_INVALID(1001,"参数无效"),
 PARAM_IS_BLANK(1002,"参数为空"),
 PARMA_TYPE_BIND_ERROR(1003,"参数类型错误"),
 PARAM_NOT_COMPLETE(1004,"参数缺失"),

 PARAM_DEALERID_IS_BLANK(1005,"经销店id为空"),
 PARMA_ACTIONPOSITION_IS_BLANK(1006,"活动项显示位置为空"),

 DEALER_NOT_FOUNT(1007,"未找到经销店"),

 /*系统模块错误：2001-2999*/
 USER_NOT_LOGGEN_IN(2001,"用户未登录，访问的路径需要验证，请登录"),
 USER_LOGIN_ERROR(2002,"账号不存在或密码错误"),
 USER_ACCOUNT_FORBIDDEN(2003,"账号已被禁用"),
 USER_NOT_EXIST(2004,"用户不存在"),
 USER_HAS_EXISTED(2005,"用户已存在");





 private int code;
 private String message;

 ResultCode(int code, String message) {
  this.code = code;
  this.message = message;
 }

 public int getCode() {
  return code;
 }

 public String getMessage() {
  return message;
 }
}
