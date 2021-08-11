package com.wp.eauto.employee.controller;

import com.eauto.base.RestResponse;
import com.wp.eauto.employee.viewmodel.request.LoginRequestModel;
import com.wp.eauto.employee.viewmodel.response.LoginResultModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/eauto/employee")
public interface EmployeeController {

    /**
     * 登录
     * @param param
     * @return
     */
    @RequestMapping("/login")
    RestResponse<LoginResultModel> login(LoginRequestModel param);
}
