package com.eauto.model;

import lombok.Data;

import java.io.Serializable;

/**
 * User:Administrator
 * Date:2021/11/10
 * Time:14:10
 * Description: No Description
 */
@Data
public class Login implements Serializable {
    public String uid;
    public String loginName;
    public String password;

    public Login() {
        super();
    }

    public Login(String uid, String loginName, String password) {
        this.uid = uid;
        this.loginName = loginName;
        this.password = password;
    }
}
