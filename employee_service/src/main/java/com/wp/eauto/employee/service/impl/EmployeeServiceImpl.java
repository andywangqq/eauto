package com.wp.eauto.employee.service.impl;

import com.wp.eauto.employee.domain.Employee;
import com.wp.eauto.employee.mapper.EmployeeMapper;
import com.wp.eauto.employee.service.EmployeeService;
import com.wp.eauto.employee.viewmodel.request.LoginRequestModel;
import com.wp.eauto.employee.viewmodel.response.LoginResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getEmployee() {
        return employeeMapper.getEmployee();
    }

    /**
     * 登录
     *
     * @param param
     * @return
     */
    @Override
    public List<LoginResultModel> login(LoginRequestModel param) {
        return employeeMapper.login(param);
    }
}
