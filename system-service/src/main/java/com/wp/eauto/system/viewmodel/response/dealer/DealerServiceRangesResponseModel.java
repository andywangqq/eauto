package com.wp.eauto.system.viewmodel.response.dealer;

import lombok.Data;

@Data
public class DealerServiceRangesResponseModel {
    /**
     * 门店服务范围Id
     */
    public String dealerServiceRangesId;

    /**
     * 服务范围id
     */
    public String serviceRangesId;
    /**
     * 服务名称
     */
    public String serviceName;
}
