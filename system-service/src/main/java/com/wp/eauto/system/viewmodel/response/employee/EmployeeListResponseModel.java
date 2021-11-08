package com.wp.eauto.system.viewmodel.response.employee;

import lombok.Data;

import java.time.DateTimeException;
import java.util.Date;

/**
 * User:Administrator
 * Date:2021/11/8
 * Time:17:04
 * Description: No Description
 */
@Data
public class EmployeeListResponseModel {
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
     * 职位
     */
    public String roleName;

    /**
     * 电话
     */
    public String phone;

    /**
     * 入职日期
     */
    public Date hiredate;

    /**
     * 在职状态
     */
    public String employeeStatusName;
}
