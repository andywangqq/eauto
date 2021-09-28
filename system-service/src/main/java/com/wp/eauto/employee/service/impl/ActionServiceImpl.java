package com.wp.eauto.employee.service.impl;

import com.wp.eauto.employee.mapper.ActionMapper;
import com.wp.eauto.employee.service.ActionService;
import com.wp.eauto.employee.viewmodel.request.action.ActionRequestModel;
import com.wp.eauto.employee.viewmodel.response.action.ActionResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User:Administrator
 * Date:2021/9/28
 * Time:17:15
 * Description: No Description
 */
@Service
public class ActionServiceImpl implements ActionService {
    @Autowired
    private ActionMapper actionMapper;

    @Override
    public List<ActionResponseModel> getActionList(ActionRequestModel param) {
        return actionMapper.getActionList(param);
    }
}
