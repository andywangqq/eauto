package com.wp.eauto.system.controller;

import com.eauto.utils.JsonUtil;
import com.wp.eauto.system.viewmodel.response.login.LoginEmployeeResponseModel;
import com.wp.eauto.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @Autowired
    private RedisUtils redisUtils;

    public LoginEmployeeResponseModel getCurUser(String key) {
        return JsonUtil.fromJSON2Entity(redisUtils.get(key).toString(),LoginEmployeeResponseModel.class);

    }


}
