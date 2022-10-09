package com.wp.eauto.system.viewmodel.request.employee;

import com.sun.istack.NotNull;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 员工保存对象
 */
@Data
public class SaveEmployeeRequestModel {
    @NotEmpty(message = "名称不能为空")
    public String employeeName;
    @Range(min = 1, max = 2, message = "性别错误")
    public Short gender;
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号错误")
    public String phone;
    @NotEmpty(message = "部门不能为空")
    public String departmentId;
    @Min(value = 0)
    public Double allowance;
    @Min(value = 0)
    public Double basePay;
    public String qq;
    @Pattern(regexp = "^(\\d{18,18}|\\d{15,15}|\\d{17,17}x)")
    public String idCardNo;
    @Email(message = "邮箱错误")
    public String email;
    @Range(min = 1, max = 3, message = "状态错误")
    public Short employeeStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date hireDate;
    @NotEmpty(message = "经销店错误")
    public String dealerId;
}
