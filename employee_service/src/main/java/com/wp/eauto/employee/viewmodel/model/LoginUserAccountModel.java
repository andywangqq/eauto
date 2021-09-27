package com.wp.eauto.employee.viewmodel.model;

import lombok.Data;

/**
 * 登录账户返回信息
 */
@Data
public class LoginUserAccountModel {
    /**
     * 用户Id
     */
    public String employeeId;

    /**
     * 密码
     */
    public String password;
}
