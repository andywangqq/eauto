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

 /* 失败 */
 FAIL(2,"失败"),

 /* 数据不存在 */
 NOT_EXIST(3,"数据不存在"),

 /*参数错误: 1001-1999*/
 PARAM_IS_INVALID(1001,"参数无效"),
 /**
  * 参数为空
  */
 PARAM_IS_BLANK(1002,"参数为空"),
 /**
  * 参数类型错误
  */
 PARMA_TYPE_BIND_ERROR(1003,"参数类型错误"),
 /**
  * 参数缺失
  */
 PARAM_NOT_COMPLETE(1004,"参数缺失"),
 /**
  * 经销店id为空
  */
 PARAM_DEALERID_IS_BLANK(1005,"经销店id为空"),
 /**
  * 活动项显示位置为空
  */
 PARMA_ACTIONPOSITION_IS_BLANK(1006,"活动项显示位置为空"),
 /**
  *未找到门店
  */
 DEALER_NOT_FOUNT(1007,"未找到门店"),
 /**
  * 门店保存错误
  */
 DEALER_SAVE_ERROR(1008,"门店保存错误"),
 /**
  * 门店主营产品范围保存错误
  */
 DEALER_PRODUCT_RANGES_SAVE_ERROR(1009,"门店主营产品范围保存错误"),
 /**
  * 门店主营服务范围保存错误
  */
 DEALER_SERVICE_RANGES_SAVE_ERROR(1010,"门店主营服务范围保存错误"),
 /**
  * 门店联系人保存错误
  */
 DEALER_CONTACT_SAVE_ERROR(1011,"门店联系人保存错误"),
 /**
  * 门店联系人保存错误
  */
 DEALER_CONTACT_PARAM_NUMBER_ERROR(101101,"门店联系人参数数量错误"),

 /*系统模块错误：2001-2999*/
 /**
  * 用户未登录，访问的路径需要验证，请登录
  */
 USER_NOT_LOGGEN_IN(2001,"用户未登录，访问的路径需要验证，请登录"),
 /**
  * 账号不存在或密码错误
  */
 USER_LOGIN_ERROR(2002,"账号不存在或密码错误"),
 /**
  * 账号已被禁用
  */
 USER_ACCOUNT_FORBIDDEN(2003,"账号已被禁用"),
 /**
  * 用户不存在
  */
 USER_NOT_EXIST(2004,"用户不存在"),
 /**
  * 用户已存在
  */
 USER_HAS_EXISTED(2005,"用户已存在"),
 /**
  * token过期
  */
 USER_TOKEN_EXPIRED(2006,"令牌已过期"),
 /**
  * token错误
  */
 USER_TOKEN_ERROR(2007,"令牌错误");





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
