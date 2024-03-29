package com.wp.eauto.system.service;

import com.github.pagehelper.PageInfo;
import com.wp.eauto.system.domain.Employee;
import com.wp.eauto.system.viewmodel.model.LoginEmployeeModel;
import com.wp.eauto.system.viewmodel.model.LoginEmployeeRoleModel;
import com.wp.eauto.system.viewmodel.model.LoginUserAccountModel;
import com.wp.eauto.system.viewmodel.request.employee.EmployeeListRequestModel;
import com.wp.eauto.system.viewmodel.response.employee.EmployeeListResponseModel;
import com.wp.eauto.system.viewmodel.response.login.LoginEmployeeResponseModel;
import org.apache.ibatis.annotations.Param;

import javax.websocket.server.PathParam;
import java.util.List;

public interface EmployeeService {

    /**
     * 获取用户账户信息
     * @param userName
     * @return
     */
    LoginUserAccountModel getUserAccount(String userName);

    /**
     * 查询人员信息
     * @param employeeId
     * @return
     */
    LoginEmployeeModel getEmployeeById(String employeeId);

    /**
     * 查询人员角色
     * @param employeeId
     * @return
     */
    List<LoginEmployeeRoleModel> getEmployeeRoles(String employeeId);

    //增加实体
    long addEntity(Employee param) throws Exception;

    //删除实体
    boolean deleteEntity(@PathParam("id") long id) throws Exception;

    //修改实体
    long updateEntity(Employee param) throws Exception;

    //查询实体
    Employee findEntity(String employeeId) throws Exception;

    //查询实体List
    PageInfo<EmployeeListResponseModel> GetEmployeeList(EmployeeListRequestModel param) throws Exception;
}
