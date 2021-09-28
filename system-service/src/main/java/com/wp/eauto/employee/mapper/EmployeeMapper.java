package com.wp.eauto.employee.mapper;

import com.wp.eauto.employee.viewmodel.model.LoginEmployeeModel;
import com.wp.eauto.employee.viewmodel.model.LoginEmployeeRoleModel;
import com.wp.eauto.employee.viewmodel.model.LoginUserAccountModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {
    /**
     * 获取用户账户
     *
     * @param userName
     * @return
     */
    LoginUserAccountModel getUserAccount(@Param("userName") String userName);

    /**
     * 查询人员信息
     *
     * @param employeeId
     * @return
     */
    LoginEmployeeModel getEmployeeById(@Param("employeeId") String employeeId);

    /**
     * 查询人员角色
     *
     * @param employeeId
     * @return
     */
    List<LoginEmployeeRoleModel> getEmployeeRoles(@Param("employeeId") String employeeId);

}
