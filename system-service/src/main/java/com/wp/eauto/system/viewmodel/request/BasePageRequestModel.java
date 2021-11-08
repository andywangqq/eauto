package com.wp.eauto.system.viewmodel.request;

import lombok.Data;

/**
 * User:Administrator
 * Date:2021/11/8
 * Time:16:35
 * Description: No Description
 */
@Data
public class BasePageRequestModel extends BaseRquestModel {
    public int pageIndex;
    public int pageSize;
}