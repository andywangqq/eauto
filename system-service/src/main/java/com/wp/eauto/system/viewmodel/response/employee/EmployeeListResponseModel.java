package com.wp.eauto.system.viewmodel.response.employee;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * User:Administrator
 * Date:2021/11/8
 * Time:17:04
 * Description: No Description
 */
@Data
public class EmployeeListResponseModel implements Serializable {
    /**
     * 人员Id
     */
    public String employeeId;
    /**
     * 人员名称
     */
    public String employeeName;
    /**
     * 性别
     */
    public String genderName;
    /**
     * 用户名
     */
    public String userName;
    /**
     * 状态状态
     */
    public String accountStatusName;

    /**
     * 角色/职位
     */
    public String roleName;

    /**
     * 电话
     */
    public String phone;

    /**
     * 入职日期
     */
    public Date hireDate;

    /**
     * 在职状态
     */
    public String employeeStatusName;
}
