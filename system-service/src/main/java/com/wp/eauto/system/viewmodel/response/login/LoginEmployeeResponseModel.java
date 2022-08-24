package com.wp.eauto.system.viewmodel.response.login;


import com.wp.eauto.system.viewmodel.model.LoginEmployeeRoleModel;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * User:Administrator
 * Date:2021/9/27
 * Time:15:23
 * Description: No Description
 */
@Data
public class LoginEmployeeResponseModel implements Serializable {
    /**
     * 人员名称
     */
    public String employeeName;

    /**
     * 人员id
     */
    public String employeeId;

    /**
     * 所在经销店
     */
    public String dealerName;

    /**
     * 角色名称
     */
    public List<LoginEmployeeRoleModel> roleNames;

    /**
     * 请求跟踪id
     */
    public String traceId;

    /**
     *
     */
    public String token;
}