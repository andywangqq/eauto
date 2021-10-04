package com.wp.eauto.system.controller;

import com.eauto.base.ResultCode;
import com.eauto.base.ResultModel;
import com.wp.eauto.system.domain.Dealer;
import com.wp.eauto.system.domain.DealerContact;
import com.wp.eauto.system.domain.DealerProductRanges;
import com.wp.eauto.system.domain.DealerServiceRanges;
import com.wp.eauto.system.service.*;
import com.wp.eauto.system.viewmodel.request.action.ActionRequestModel;
import com.wp.eauto.system.viewmodel.request.dealer.DealerInfoRequestModel;
import com.wp.eauto.system.viewmodel.response.action.ActionResponseModel;
import com.wp.eauto.system.viewmodel.response.dealer.DealerContactResponseModel;
import com.wp.eauto.system.viewmodel.response.dealer.DealerInfoResponseModel;
import com.wp.eauto.system.viewmodel.response.dealer.DealerProductRangesResponseModel;
import com.wp.eauto.system.viewmodel.response.dealer.DealerServiceRangesResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User:Administrator
 * Date:2021/9/29
 * Time:11:29
 * Description: No Description
 */
@RestController
@RequestMapping("/eauto/dealer")
public class DealerController {
    @Autowired
    private DealerService dealerService;

    @Autowired
    private DealerServiceRangesService dealerServiceRangesService;

    @Autowired
    private DealerProductRangesService dealerProductRangesService;

    @Autowired
    private DealerContactService dealerContactService;

    /**
     * 查询经销店详情
     *
     * @param param
     * @return
     */
    @PostMapping("getDealerInfo")
    public ResultModel<DealerInfoResponseModel> getDealerInfo(DealerInfoRequestModel param) throws Exception {
        if (param.dealerId == null || param.dealerId.length() <= 0) {
            return ResultModel.failure(ResultCode.PARAM_DEALERID_IS_BLANK);
        }
        //查询经销店信息
        Dealer dparam = new Dealer();
        dparam.setDealerId(param.dealerId);
        Dealer dealer = dealerService.findEntity(dparam);
        if (dealer == null) {
            return ResultModel.failure(ResultCode.DEALER_NOT_FOUNT);
        }
        DealerInfoResponseModel result = new DealerInfoResponseModel();
        result.dealerId = dealer.getDealerId();
        result.address = dealer.getAddress();
        result.aName = dealer.getAName();
        result.authentication = dealer.getAuthentication();
        result.cnName = dealer.getCnName();
        result.enName = dealer.getEnName();
        result.dealerType = dealer.getDealerType();
        result.plateNumber = dealer.getPlateNumber();
        result.registrationTime = dealer.getRegistrationTime();
        result.remark = dealer.getRemark();
        result.telephone = dealer.getTelephone();
        result.website = dealer.getWebsite();

        //查询经销店服务
        DealerServiceRanges srparam = new DealerServiceRanges();
        srparam.setDealerId(param.dealerId);
        List<DealerServiceRanges> dealerServiceRangesList = dealerServiceRangesService.findEntityList(srparam);
        if (dealerServiceRangesList != null && dealerServiceRangesList.size() > 0) {
            for (DealerServiceRanges service : dealerServiceRangesList) {
                DealerServiceRangesResponseModel srr = new  DealerServiceRangesResponseModel();
                srr.dealerServiceRangesId = service.getDealerServiceRangesId();
                srr.serviceName = service.getServiceName();
                result.serviceRanges.add(srr);
            }
        }

        //查询经销店产品
        DealerProductRanges prparam = new DealerProductRanges();
        prparam.setDealerId(param.dealerId);
        List<DealerProductRanges> dealerProductRangesList = dealerProductRangesService.findEntityList(prparam);
        if (dealerProductRangesList != null && dealerProductRangesList.size() > 0) {
            for (DealerProductRanges product : dealerProductRangesList) {
                DealerProductRangesResponseModel prr = new  DealerProductRangesResponseModel();
                prr.dealerProductRangesId = product.getDealerProductRangesId();
                prr.productName = product.getProductName();
                result.productRanges.add(prr);
            }
        }

        //查询经销店联系人
        DealerContact cparam = new DealerContact();
        cparam.setDealerId(param.dealerId);
        List<DealerContact> contactList = dealerContactService.findEntityList(cparam);
        if (contactList != null && contactList.size() > 0) {
            for (DealerContact contact : contactList) {
                DealerContactResponseModel cr = new  DealerContactResponseModel();
                cr.dealerContactId = contact.getDealerContactId();
                cr.contactName = contact.getContactName();
                cr.email = contact.getEmail();
                cr.phone = contact.getPhone();
                cr.qq = contact.getQq();
                result.contacts.add(cr);
            }
        }
        return ResultModel.Success(result);
    }
}
