package com.eauto.model;

import java.io.Serializable;

/**
 * User:Administrator
 * Date:2021/11/10
 * Time:17:18
 * Description: No Description
 */
public class RedisLogin implements Serializable {

    public String uid;

    public String token;

    public long refTime;

    public RedisLogin(){

    }

    public RedisLogin(String uid,String token,long refTime){
        this.uid = uid;
        this.token = token;
        this.refTime = refTime;
    }
}
