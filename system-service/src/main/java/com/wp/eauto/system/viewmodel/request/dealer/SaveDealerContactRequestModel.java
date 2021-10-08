package com.wp.eauto.system.viewmodel.request.dealer;

import lombok.Data;

/**
 * User:Administrator
 * Date:2021/10/8
 * Time:14:32
 * Description: No Description
 */
@Data
public class SaveDealerContactRequestModel {
    /**
     * 门店Id
     */
    public String dealerId;
    public String dealerContactId;
    public String contactName;
    public String phone;
    public String email;
    public String qq;
}
