package com.wp.eauto.system.viewmodel.request.dealer;

import lombok.Data;

import java.util.Date;

/**
 * User:Administrator
 * Date:2021/10/8
 * Time:14:13
 * Description: No Description
 */
@Data
public class SaveDealerRequestModel {
    /**
     * 经销店Id
     */
    public String dealerId;
    /**
     * 经销店中文名称
     */
    public String cnName;
    /**
     * 经销店英文名称
     */
    public String enName;
    /**
     * 经销店简称
     */
    public String aName;
    /**
     * 经销店网址
     */
    public String website;
    /**
     * 经销店地址
     */
    public String address;
    /**
     * 经销店类型（经营方式）
     */
    public String dealerType;
    /**
     * 注册时间
     */
    public Date registrationTime;
    /**
     * 所在地车牌
     */
    public String plateNumber;
    /**
     * 固定电话
     */
    public String telephone;
    /**
     * 是否已认证
     */
    public String authentication;
    /**
     * 备注
     */
    public String remark;
}
