package com.wp.eauto.employee.controller;

import com.eauto.base.ResultCode;
import com.eauto.base.ResultModel;
import com.wp.eauto.employee.service.EmployeeService;
import com.wp.eauto.employee.viewmodel.model.LoginEmployeeModel;
import com.wp.eauto.employee.viewmodel.model.LoginEmployeeRoleModel;
import com.wp.eauto.employee.viewmodel.model.LoginUserAccountModel;
import com.wp.eauto.employee.viewmodel.request.login.LoginEmployeeRequestModel;
import com.wp.eauto.employee.viewmodel.response.login.LoginEmployeeResponseModel;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

//import static com.wp.eauto.base.ResultModel.Success;

@RestController
@RequestMapping("/eauto/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @PostMapping("login")
    public ResultModel<LoginEmployeeResponseModel> login(LoginEmployeeRequestModel param) {
        if (param.userName == null
                || param.userName.length() <= 0
                || param.password == null
                || param.password.length() <= 0
        ) {
            return ResultModel.failure(ResultCode.PARAM_IS_BLANK);
        }

        // 查询账号
        LoginUserAccountModel user = employeeService.getUserAccount(param.userName);
        if (user == null) {
            return ResultModel.failure(ResultCode.USER_LOGIN_ERROR);
        }
        //sha256加密
        String password = new Sha256Hash(param.password).toHex();
        if (!user.password.equals(password)) {
            return ResultModel.failure(ResultCode.USER_LOGIN_ERROR);
        }
        //查询用户
        LoginEmployeeModel employee = employeeService.getEmployeeById(user.employeeId);
        if (employee == null) {
            return ResultModel.failure(ResultCode.USER_NOT_EXIST);
        }

        LoginEmployeeResponseModel result = new LoginEmployeeResponseModel();
        result.dealerName = employee.dealerName;
        result.employeeName = employee.employeeName;

        //查询角色
        List<LoginEmployeeRoleModel> employeeRoles = employeeService.getEmployeeRoles(user.employeeId);
        result.roleNames = employeeRoles;
        return ResultModel.Success(result);
    }

}
