package com.wp.eauto.employee.viewmodel.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * USER: wang
 * Date: 2021/6/5
 * Time: 23:15
 */
@Data
public class LoginRequestModel {
    @NotBlank(message = "用户名不能为空")
    public String userName;
    @NotBlank(message = "密码不能为空")
    public String password;
}
