package com.wp.eauto.employee.service;

import com.wp.eauto.employee.viewmodel.request.action.ActionRequestModel;
import com.wp.eauto.employee.viewmodel.response.action.ActionResponseModel;

import java.util.List;

/**
 * User:Administrator
 * Date:2021/9/28
 * Time:17:14
 * Description: No Description
 */
public interface ActionService {

    /**
     * 查询活动项
     * @param param
     * @return
     */
   List<ActionResponseModel> getActionList(ActionRequestModel param);
}
