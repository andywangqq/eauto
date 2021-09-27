package com.wp.eauto.employee.viewmodel.request.employee.login;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * User:Administrator
 * Date:2021/9/27
 * Time:15:19
 * Description: No Description
 */
@Data
public class LoginEmployeeRequestModel {

    /**
     * 登陆账号
     */
    @NotBlank(message = "用户名不能为空")
    public String userName;

    /**
     * 登陆密码
     */
    @NotBlank(message = "密码不能为空")
    public String password;
}

