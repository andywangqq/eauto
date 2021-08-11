package com.wp.eauto.employee.service;

import com.wp.eauto.employee.domain.Employee;
import com.wp.eauto.employee.viewmodel.request.LoginRequestModel;
import com.wp.eauto.employee.viewmodel.response.LoginResultModel;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployee();
    /**
     * 登录
     * @param param
     * @return
     */
    List<LoginResultModel> login(LoginRequestModel param);
}
