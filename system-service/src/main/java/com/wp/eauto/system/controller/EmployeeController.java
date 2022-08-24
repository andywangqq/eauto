package com.wp.eauto.system.controller;

import com.eauto.base.ResultCode;
import com.eauto.base.ResultModel;
import com.eauto.utils.JsonUtil;
import com.wp.eauto.utils.RedisUtils;
import com.eauto.utils.TokenUtils;
import com.wp.eauto.system.service.EmployeeService;
import com.wp.eauto.system.viewmodel.model.LoginEmployeeModel;
import com.wp.eauto.system.viewmodel.model.LoginEmployeeRoleModel;
import com.wp.eauto.system.viewmodel.model.LoginUserAccountModel;
import com.wp.eauto.system.viewmodel.request.login.LoginEmployeeRequestModel;
import com.wp.eauto.system.viewmodel.response.login.LoginEmployeeResponseModel;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping(value = "/employee", produces = "application/json;charset=UTF-8")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RedisUtils redisUtils;

    /**
     * 登录
     *
     * @param param
     * @return
     */
    @PostMapping("login")
    public ResultModel<LoginEmployeeResponseModel> login(@RequestBody LoginEmployeeRequestModel param) throws Exception {
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
        result.employeeId = user.getEmployeeId();
        result.dealerName = employee.dealerName;
        result.employeeName = employee.employeeName;
        result.token = TokenUtils.token(user.employeeId);
       //查询角色
        List<LoginEmployeeRoleModel> employeeRoles = employeeService.getEmployeeRoles(user.employeeId);
        result.roleNames = employeeRoles;

        redisUtils.set(result.token, JsonUtil.writeEntity2JSON(result));

        return ResultModel.Success(result);
    }

    /**
     * todo 新增员工
     */

    /**
     * todo 更新员工
     */

    /**
     * todo 查询员工列表
     */

    /**
     * todo 分配账户
     */

    /**
     * todo 重置密码
     */

    /**
     * todo 删除
     */


}
