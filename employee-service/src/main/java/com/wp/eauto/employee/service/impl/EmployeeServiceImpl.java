package com.wp.eauto.employee.service.impl;

import com.wp.eauto.employee.domain.UserAccount;
import com.wp.eauto.employee.viewmodel.model.LoginEmployeeModel;
import com.wp.eauto.employee.viewmodel.model.LoginEmployeeRoleModel;
import com.wp.eauto.employee.viewmodel.model.LoginUserAccountModel;
import com.wp.eauto.employee.viewmodel.request.employee.login.LoginEmployeeRequestModel;
import com.wp.eauto.employee.viewmodel.response.employee.login.EmployeeAndDealer;
import com.wp.eauto.employee.mapper.EmployeeMapper;
import com.wp.eauto.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 获取用户账户信息
     * @param userName
     * @return
     */
    @Override
    public LoginUserAccountModel getUserAccount(String userName) {
       return employeeMapper.getUserAccount(userName);
    }

    /**
     * 查询人员信息
     * @param employeeId
     * @return
     */
    @Override
    public LoginEmployeeModel getEmployeeById(String employeeId){
        return employeeMapper.getEmployeeById(employeeId);
    }

    /**
     * 查询人员角色
     * @param employeeId
     * @return
     */
    @Override
    public List<LoginEmployeeRoleModel> getEmployeeRoles(String employeeId) {
        return employeeMapper.getEmployeeRoles(employeeId);
    }


}
