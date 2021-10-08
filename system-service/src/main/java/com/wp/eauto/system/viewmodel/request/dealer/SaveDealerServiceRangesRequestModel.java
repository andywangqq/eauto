package com.wp.eauto.system.viewmodel.request.dealer;

import lombok.Data;

/**
 * User:Administrator
 * Date:2021/10/8
 * Time:14:14
 * Description: No Description
 */
@Data
public class SaveDealerServiceRangesRequestModel {

    /**
     * 门店服务范围Id
     */
    public String dealerServiceRangesId;
    /**
     * 服务范围Id
     */
    public String serviceRangesId;
    /**
     * 服务名称
     */
    public String serviceName;
}
