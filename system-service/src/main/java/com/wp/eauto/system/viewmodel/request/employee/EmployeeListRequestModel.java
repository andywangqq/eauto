package com.wp.eauto.system.viewmodel.request.employee;

import com.wp.eauto.system.viewmodel.request.BasePageRequestModel;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * User:Administrator
 * Date:2021/11/8
 * Time:16:46
 * Description: No Description
 */
@Data
public class EmployeeListRequestModel extends BasePageRequestModel implements Serializable {

    /**
     * 门店Id
     */
    @NotNull(message = "门店不能为空")
    public String dealerId;
    /**
     * 姓名
     */
    public String employeeName;

    /**
     * 部门
     */
    public String departmentId;

    /**
     * 职位
     */
    public byte roleId;

    /**
     * 状态
     */
    public byte employeeStatus;

    /**
     * 性别
     */
    public byte gender;
}
