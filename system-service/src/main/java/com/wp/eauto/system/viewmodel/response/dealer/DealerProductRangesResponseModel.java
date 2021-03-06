package com.wp.eauto.system.viewmodel.response.dealer;

import lombok.Data;

@Data
public class DealerProductRangesResponseModel {
    /**
     * 门店产品范围id
     */
    public String dealerProductRangesId;

    /**
     * 产品范围id
     */
    public String productRangesId;

    /**
     * 产品名称
     */
    public String productName;
}
