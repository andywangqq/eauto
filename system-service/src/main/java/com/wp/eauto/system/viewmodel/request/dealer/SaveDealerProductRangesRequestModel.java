package com.wp.eauto.system.viewmodel.request.dealer;

import lombok.Data;

/**
 * User:Administrator
 * Date:2021/10/8
 * Time:14:15
 * Description: No Description
 */
@Data
public class SaveDealerProductRangesRequestModel {
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
