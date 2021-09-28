package com.wp.eauto.employee.viewmodel.response.action;

import lombok.Data;

/**
 * User:Administrator
 * Date:2021/9/28
 * Time:17:22
 * Description: 活动响应对象
 */
@Data
public class ActionResponseModel {
    /**
     * 活动名称
     */
    public String actionName;

    /**
     * 活动地址
     */
    public String actionUrl;
}
