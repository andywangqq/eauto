package com.wp.eauto.employee.controller.impl;

import com.eauto.base.RestResponse;
import com.wp.eauto.employee.controller.EmployeeController;
import com.wp.eauto.employee.domain.Employee;
import com.wp.eauto.employee.service.EmployeeService;
import com.wp.eauto.employee.viewmodel.request.LoginRequestModel;
import com.wp.eauto.employee.viewmodel.response.LoginResultModel;
import lombok.experimental.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeControllerImpl implements EmployeeController {
    @Autowired
    private EmployeeService employeeService;



    /**
     * 登录
     * @param param
     * @return
     */
    @Override
    public RestResponse<LoginResultModel> login(@RequestBody @Valid LoginRequestModel param){
        LoginResultModel result = employeeService.login(param).get(0);
    return RestResponse.ok(result);
    }
}
