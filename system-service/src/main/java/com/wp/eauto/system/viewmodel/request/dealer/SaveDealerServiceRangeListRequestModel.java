package com.wp.eauto.system.viewmodel.request.dealer;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * User:Administrator
 * Date:2021/10/8
 * Time:17:49
 * Description: No Description
 */
@Data
public class SaveDealerServiceRangeListRequestModel {
    public SaveDealerServiceRangeListRequestModel(){
        this.dealerServiceRanges = new ArrayList<>();
    }
    /**
     * 门店Id
     */
    public String dealerId;

    public List<SaveDealerServiceRangesRequestModel> dealerServiceRanges;
}
