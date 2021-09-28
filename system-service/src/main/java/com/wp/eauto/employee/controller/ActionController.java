package com.wp.eauto.employee.controller;

import com.eauto.base.ResultCode;
import com.eauto.base.ResultModel;
import com.wp.eauto.employee.service.ActionService;
import com.wp.eauto.employee.service.EmployeeService;
import com.wp.eauto.employee.viewmodel.request.action.ActionRequestModel;
import com.wp.eauto.employee.viewmodel.response.action.ActionResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User:Administrator
 * Date:2021/9/28
 * Time:17:13
 * Description: No Description
 */
@RestController
@RequestMapping("/eauto/action")
public class ActionController {
    @Autowired
    private ActionService actionService;

    /**
     * 查询活动项
     *
     * @param param
     * @return
     */
    @PostMapping("getActionList")
    public ResultModel<List<ActionResponseModel>> getActionList(ActionRequestModel param) {
        if (param.dealerId == null || param.dealerId.length() <= 0) {
            return ResultModel.failure(ResultCode.PARAM_DEALERID_IS_BLANK);
        }
        if (param.displayPosition == null || param.displayPosition.length() <= 0) {
            return ResultModel.failure(ResultCode.PARMA_ACTIONPOSITION_IS_BLANK);
        }

        List<ActionResponseModel> result = actionService.getActionList(param);
        return ResultModel.Success(result);
    }

}
