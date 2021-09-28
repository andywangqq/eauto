package com.wp.eauto.employee.service;

import com.wp.eauto.employee.domain.Employee;
import com.wp.eauto.employee.domain.UserAccount;
import com.wp.eauto.employee.viewmodel.model.LoginEmployeeModel;
import com.wp.eauto.employee.viewmodel.model.LoginEmployeeRoleModel;
import com.wp.eauto.employee.viewmodel.model.LoginUserAccountModel;
import com.wp.eauto.employee.viewmodel.request.employee.login.LoginEmployeeRequestModel;
import com.wp.eauto.employee.viewmodel.response.employee.login.EmployeeAndDealer;

import java.util.List;

public interface EmployeeService {

    /**
     * 获取用户账户信息
     * @param userName
     * @return
     */
    LoginUserAccountModel getUserAccount(String userName);

    /**
     * 查询人员信息
     * @param employeeId
     * @return
     */
    LoginEmployeeModel getEmployeeById(String employeeId);

    /**
     * 查询人员角色
     * @param employeeId
     * @return
     */
    List<LoginEmployeeRoleModel> getEmployeeRoles(String employeeId);
}
