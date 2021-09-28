package com.wp.eauto.employee.mapper;

/**
 * User:Administrator
 * Date:2021/9/28
 * Time:17:15
 * Description: No Description
 */

import com.wp.eauto.employee.viewmodel.request.action.ActionRequestModel;
import com.wp.eauto.employee.viewmodel.response.action.ActionResponseModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionMapper {

    /**
     * 查询活动项
     * @param param
     * @return
     */
    List<ActionResponseModel> getActionList(ActionRequestModel param);
}
