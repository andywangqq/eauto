package com.wp.eauto.employee.mapper;

import com.wp.eauto.employee.domain.Employee;
import com.wp.eauto.employee.viewmodel.request.LoginRequestModel;
import com.wp.eauto.employee.viewmodel.response.LoginResultModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {
    List<Employee> getEmployee();
    /**
     * 登录
     * @param param
     * @return
     */
    List<LoginResultModel> login(LoginRequestModel param);

}
