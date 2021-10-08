package com.wp.eauto.system.viewmodel.request.dealer;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * User:Administrator
 * Date:2021/10/8
 * Time:17:00
 * Description: No Description
 */
@Data
public class SaveDealerProductRangeListRequestModel {
    public SaveDealerProductRangeListRequestModel(){
        this.dealerProductRangeList = new ArrayList<>();
    }
    /**
     * 门店Id
     */
    public String dealerId;

    public List<SaveDealerProductRangesRequestModel> dealerProductRangeList;
}
