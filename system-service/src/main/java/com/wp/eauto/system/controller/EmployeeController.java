package com.wp.eauto.system.controller;

import com.eauto.base.ResultCode;
import com.eauto.base.ResultModel;
import com.eauto.utils.JsonUtil;
import com.eauto.utils.UUIDUtils;
import com.github.pagehelper.PageInfo;
import com.wp.eauto.system.domain.Employee;
import com.wp.eauto.system.service.EmployeeService;
import com.wp.eauto.system.viewmodel.request.employee.EmployeeListRequestModel;
import com.wp.eauto.system.viewmodel.request.employee.EmployeeRequestModel;
import com.wp.eauto.system.viewmodel.request.employee.SaveEmployeeRequestModel;
import com.wp.eauto.system.viewmodel.request.employee.UpdateEmployeeRequestModel;
import com.wp.eauto.system.viewmodel.response.employee.EmployeeListResponseModel;
import com.wp.eauto.system.viewmodel.response.employee.EmployeeResponseModel;
import com.wp.eauto.utils.RedisUtils;
import com.eauto.utils.TokenUtils;
import com.wp.eauto.system.viewmodel.model.LoginEmployeeModel;
import com.wp.eauto.system.viewmodel.model.LoginEmployeeRoleModel;
import com.wp.eauto.system.viewmodel.model.LoginUserAccountModel;
import com.wp.eauto.system.viewmodel.request.login.LoginEmployeeRequestModel;
import com.wp.eauto.system.viewmodel.response.login.LoginEmployeeResponseModel;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/employee", produces = "application/json;charset=UTF-8")
public class EmployeeController extends BaseController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RedisUtils redisUtils;

    /**
     * 登录
     *
     * @param param
     * @return
     */
    @PostMapping("login")
    public ResultModel<LoginEmployeeResponseModel> login(@RequestBody LoginEmployeeRequestModel param) throws Exception {
        if (param.userName == null
                || param.userName.length() <= 0
                || param.password == null
                || param.password.length() <= 0
        ) {
            return ResultModel.failure(ResultCode.PARAM_IS_BLANK);
        }

        // 查询账号
        LoginUserAccountModel user = employeeService.getUserAccount(param.userName);
        if (user == null) {
            return ResultModel.failure(ResultCode.USER_LOGIN_ERROR);
        }
        //sha256加密
        String password = new Sha256Hash(param.password).toHex();
        if (!user.password.equals(password)) {
            return ResultModel.failure(ResultCode.USER_LOGIN_ERROR);
        }

        //查询用户
        LoginEmployeeModel employee = employeeService.getEmployeeById(user.employeeId);
        if (employee == null) {
            return ResultModel.failure(ResultCode.USER_NOT_EXIST);
        }

        LoginEmployeeResponseModel result = new LoginEmployeeResponseModel();
        result.employeeId = user.getEmployeeId();
        result.dealerName = employee.dealerName;
        result.dealerId = employee.dealerId;
        result.employeeName = employee.employeeName;
        result.token = TokenUtils.token(user.employeeId);
        //查询角色
        List<LoginEmployeeRoleModel> employeeRoles = employeeService.getEmployeeRoles(user.employeeId);
        result.roleNames = employeeRoles;

        redisUtils.set(result.token, JsonUtil.writeEntity2JSON(result));

        return ResultModel.Success(result);
    }

    /**
     * 新增员工
     */
    public ResultModel<Boolean> addEntity(@RequestBody SaveEmployeeRequestModel param, HttpServletRequest request) throws Exception {

        Employee employee = new Employee();
        employee.setEmployeeId(UUIDUtils.getID());    //
        employee.setEmployeeName(param.employeeName);    //雇员名称
        employee.setGender(param.gender);    //性别
        employee.setPhone(param.phone);    //电话
        employee.setDepartmentId(param.departmentId);    //部门id
        employee.setAllowance(param.allowance);    //津贴
        employee.setBasePay(param.basePay);    //基本工资
        employee.setQq(param.qq); //
        employee.setIdCardNo(param.idCardNo);    //身份证
        employee.setEmail(param.email);    //邮箱
        employee.setEmployeeStatus(param.employeeStatus);    //状态
        employee.setHireDate(param.hireDate);    //入职日期
        employee.setDealerId(param.dealerId);    //经销商id
        employee.setIsDeleted((short) 0);    //是否已删除
        Date date = new Date();
        employee.setCreateTime(date);    //创建时间
        LoginEmployeeResponseModel curUser = getCurUser(request.getAttribute("key").toString());

        employee.setCreateUserId(curUser.employeeId);    //创建人
        employee.setUpdateTime(date);    //修改时间
        employee.setUpdateUserId(curUser.employeeId);    //修改人
        Boolean result = employeeService.addEntity(employee) > 0;
        if (result) {
            return ResultModel.Success(true);
        } else {
            return ResultModel.failure(ResultCode.FAIL);
        }
    }

    /**
     * 查询当前员工
     */
    public ResultModel<EmployeeResponseModel> findEntity(@RequestBody EmployeeRequestModel param, HttpServletRequest request) throws Exception {

        Employee employee = employeeService.findEntity(param.employeeId);
        if (employee == null) {
            return ResultModel.failure(ResultCode.NOT_EXIST);
        }
        EmployeeResponseModel result = new EmployeeResponseModel();
        result.setEmployeeName(employee.getEmployeeName());    //雇员名称
        result.setGender(employee.getGender());    //性别
        result.setPhone(employee.getPhone());    //电话
        result.setDepartmentId(employee.getDepartmentId());    //部门id
        result.setAllowance(employee.getAllowance());    //津贴
        result.setBasePay(employee.getBasePay());    //基本工资
        result.setQq(employee.getQq()); //
        result.setIdCardNo(employee.getIdCardNo());    //身份证
        result.setEmail(employee.getEmail());    //邮箱
        result.setEmployeeStatus(employee.getEmployeeStatus());    //状态
        result.setHireDate(employee.getHireDate());    //入职日期
        result.setDealerId(employee.getDealerId());    //经销商id

        return ResultModel.Success(result);
    }

    /**
     * 更新员工
     */
    public ResultModel<Boolean> updateEntity(@RequestBody UpdateEmployeeRequestModel param, HttpServletRequest request) throws Exception {

        Employee employee = employeeService.findEntity(param.employeeId);
        if (employee == null) {
            return ResultModel.failure(ResultCode.NOT_EXIST);
        }
        employee.setEmployeeName(param.employeeName);    //雇员名称
        employee.setGender(param.gender);    //性别
        employee.setPhone(param.phone);    //电话
        employee.setDepartmentId(param.departmentId);    //部门id
        employee.setAllowance(param.allowance);    //津贴
        employee.setBasePay(param.basePay);    //基本工资
        employee.setQq(param.qq); //
        employee.setIdCardNo(param.idCardNo);    //身份证
        employee.setEmail(param.email);    //邮箱
        employee.setEmployeeStatus(param.employeeStatus);    //状态
        employee.setHireDate(param.hireDate);    //入职日期
        employee.setDealerId(param.dealerId);    //经销商id
        Date date = new Date();
        LoginEmployeeResponseModel curUser = getCurUser(request.getAttribute("key").toString());
        employee.setUpdateTime(date);    //修改时间
        employee.setUpdateUserId(curUser.employeeId);    //修改人
        Boolean result = employeeService.updateEntity(employee) > 0;
        if (result) {
            return ResultModel.Success(true);
        } else {
            return ResultModel.failure(ResultCode.FAIL);
        }
    }

    /**
     * 查询员工列表
     */
    @PostMapping("GetEmployeeList")
    public ResultModel<PageInfo<EmployeeListResponseModel>> GetEmployeeList(@RequestBody EmployeeListRequestModel param, HttpServletRequest request) throws Exception {
        LoginEmployeeResponseModel user = getCurUser(request.getAttribute("key").toString());
        param.dealerId = user.dealerId;
        PageInfo<EmployeeListResponseModel> page = employeeService.GetEmployeeList(param);
        return ResultModel.Success(page);
    }
    /**
     * todo 分配账户
     */

    /**
     * todo 重置密码
     */

    /**
     * todo 删除
     */


}
