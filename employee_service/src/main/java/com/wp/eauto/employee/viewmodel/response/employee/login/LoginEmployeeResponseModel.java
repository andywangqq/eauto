package com.wp.eauto.employee.viewmodel.response.employee.login;


import com.wp.eauto.employee.viewmodel.model.LoginEmployeeRoleModel;
import lombok.Data;

import java.util.List;

/**
 * User:Administrator
 * Date:2021/9/27
 * Time:15:23
 * Description: No Description
 */
@Data
public class LoginEmployeeResponseModel {
    /**
     * 人员名称
     */
    public String employeeName;

    /**
     * 所在经销店
     */
    public String dealerName;

    /**
     * 角色名称
     */
    public List<LoginEmployeeRoleModel> roleNames;
}

