package com.wp.eauto.system.viewmodel.request.dealer;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SaveDealerContactListRequestModel {
    public SaveDealerContactListRequestModel() {
        this.dealerContacts = new ArrayList<>();
    }

    /**
     * 门店Id
     */
    public String dealerId;
    public List<SaveDealerContactRequestModel> dealerContacts;
}
