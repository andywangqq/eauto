package com.wp.eauto.employee.viewmodel.response.employee.login;

import lombok.Data;
/**
 * User:Administrator
 * Date:2021/9/27
 * Time:17:55
 * Description: 人员及经销店信息
 */
@Data
public class EmployeeAndDealer {
    /**
     * 人员名称
     */
    public String employeeName;

    /**
     * 经销店名称
     */
    public String dealerName;
}
