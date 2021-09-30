package com.wp.eauto.system.mapper;

import com.eauto.mapper.BaseMapper;
import com.wp.eauto.system.domain.Employee;
import com.wp.eauto.system.viewmodel.model.LoginEmployeeModel;
import com.wp.eauto.system.viewmodel.model.LoginEmployeeRoleModel;
import com.wp.eauto.system.viewmodel.model.LoginUserAccountModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface EmployeeMapper extends BaseMapper<Employee> {
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

    long addEntity(Employee param);

    boolean deleteEntity(long id);

    long updateEntity(Employee param);

    Employee findEntity(Employee param);

    List<Employee> findEntityList(Employee param);

}
