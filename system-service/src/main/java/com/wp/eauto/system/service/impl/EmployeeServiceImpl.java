package com.wp.eauto.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wp.eauto.system.domain.Employee;
import com.wp.eauto.system.viewmodel.model.LoginEmployeeModel;
import com.wp.eauto.system.viewmodel.model.LoginEmployeeRoleModel;
import com.wp.eauto.system.viewmodel.model.LoginUserAccountModel;
import com.wp.eauto.system.mapper.EmployeeMapper;
import com.wp.eauto.system.service.EmployeeService;
import com.wp.eauto.system.viewmodel.request.employee.EmployeeListRequestModel;
import com.wp.eauto.system.viewmodel.response.employee.EmployeeListResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 获取用户账户信息
     *
     * @param userName
     * @return
     */
    @Override
    public LoginUserAccountModel getUserAccount(String userName) {
        return employeeMapper.getUserAccount(userName);
    }

    /**
     * 查询人员信息
     *
     * @param employeeId
     * @return
     */
    @Override
    public LoginEmployeeModel getEmployeeById(String employeeId) {
        return employeeMapper.getEmployeeById(employeeId);
    }

    /**
     * 查询人员角色
     *
     * @param employeeId
     * @return
     */
    @Override
    public List<LoginEmployeeRoleModel> getEmployeeRoles(String employeeId) {
        return employeeMapper.getEmployeeRoles(employeeId);
    }


    @Override
    public long addEntity(Employee param) throws Exception {
        try {
            log.info("addEntity");
            employeeMapper.addEntity(param);
            return 0;
        } catch (Exception e) {
            log.info("addEntity异常");
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public boolean deleteEntity(long id) throws Exception {
        try {
            log.info("deleteEntity");
            employeeMapper.deleteEntity(id);
            return false;
        } catch (Exception e) {
            log.info("deleteEntity异常");
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public long updateEntity(Employee param) throws Exception {
        try {
            log.info("updateEntity");
            employeeMapper.updateEntity(param);
            return 0;
        } catch (Exception e) {
            log.info("updateEntity异常");
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Employee findEntity(Employee param) throws Exception {
        try {
            log.info("findEntity");
            return employeeMapper.findEntity(param);
        } catch (Exception e) {
            log.info("findEntity异常");
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Employee> findEntityList(Employee param) throws Exception {
        try {
            log.info("findEntityList");
            return employeeMapper.findEntityList(param);
        } catch (Exception e) {
            log.info("findEntityList异常");
            e.printStackTrace();
            throw e;
        }
    }


    /**
     * 查询人员列表
     *
     * @param param
     * @return
     * @throws Exception
     */
    @Override
    public PageInfo<List<EmployeeListResponseModel>> queryEmployeeList(EmployeeListRequestModel param) throws Exception {
        try{
            return PageHelper.startPage(param.getPageIndex(), param.getPageSize()).doSelectPageInfo(() -> employeeMapper.queryEmployeeList(param));
        }catch(Exception e){
            log.info("queryEmployeeList");
            e.printStackTrace();
            throw e;
        }

    }


}
