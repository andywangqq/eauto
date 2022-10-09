package com.wp.eauto.system.viewmodel.response.employee;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class EmployeeResponseModel {
    public String employeeId;
    public String employeeName;
    public Short gender;
    public String phone;
    public String departmentId;
    public Double allowance;
    public Double basePay;
    public String qq;
    public String idCardNo;
    public String email;
    public Short employeeStatus;
    public Date hireDate;
    public String dealerId;
}
