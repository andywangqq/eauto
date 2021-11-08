package com.wp.eauto.system.controller;

import com.eauto.base.ResultCode;
import com.eauto.base.ResultModel;
import com.eauto.common.UUIDUtils;
import com.wp.eauto.system.domain.Dealer;
import com.wp.eauto.system.domain.DealerContact;
import com.wp.eauto.system.domain.DealerProductRanges;
import com.wp.eauto.system.domain.DealerServiceRanges;
import com.wp.eauto.system.service.*;
import com.wp.eauto.system.viewmodel.request.dealer.*;
import com.wp.eauto.system.viewmodel.response.dealer.DealerContactResponseModel;
import com.wp.eauto.system.viewmodel.response.dealer.DealerInfoResponseModel;
import com.wp.eauto.system.viewmodel.response.dealer.DealerProductRangesResponseModel;
import com.wp.eauto.system.viewmodel.response.dealer.DealerServiceRangesResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    public ResultModel<DealerInfoResponseModel> getDealerInfo(@RequestBody DealerInfoRequestModel param) throws Exception {
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

        //查询门店服务
        DealerServiceRanges srparam = new DealerServiceRanges();
        srparam.setDealerId(param.dealerId);
        List<DealerServiceRanges> dealerServiceRangesList = dealerServiceRangesService.findEntityList(srparam);
        if (dealerServiceRangesList != null && dealerServiceRangesList.size() > 0) {
            for (DealerServiceRanges service : dealerServiceRangesList) {
                DealerServiceRangesResponseModel srr = new DealerServiceRangesResponseModel();
                srr.dealerServiceRangesId = service.getDealerServiceRangesId();
                srr.serviceRangesId = service.getServiceRangesId();
                srr.serviceName = service.getServiceName();
                result.dealerServiceRanges.add(srr);
            }
        }

        //查询门店产品
        DealerProductRanges prparam = new DealerProductRanges();
        prparam.setDealerId(param.dealerId);
        List<DealerProductRanges> dealerProductRangesList = dealerProductRangesService.findEntityList(prparam);
        if (dealerProductRangesList != null && dealerProductRangesList.size() > 0) {
            for (DealerProductRanges product : dealerProductRangesList) {
                DealerProductRangesResponseModel prr = new DealerProductRangesResponseModel();
                prr.dealerProductRangesId = product.getDealerProductRangesId();
                prr.productRangesId = product.getProductRangesId();
                prr.productName = product.getProductName();
                result.dealerProductRanges.add(prr);
            }
        }

        //查询经销店联系人
        DealerContact cparam = new DealerContact();
        cparam.setDealerId(param.dealerId);
        List<DealerContact> contactList = dealerContactService.findEntityList(cparam);
        if (contactList != null && contactList.size() > 0) {
            for (DealerContact contact : contactList) {
                DealerContactResponseModel cr = new DealerContactResponseModel();
                cr.dealerContactId = contact.getDealerContactId();
                cr.contactName = contact.getContactName();
                cr.email = contact.getEmail();
                cr.phone = contact.getPhone();
                cr.qq = contact.getQq();
                result.dealerContacts.add(cr);
            }
        }
        return ResultModel.Success(result);
    }

    /**
     * 保存当前经销店信息
     *
     * @param param
     * @return
     */
    @PostMapping("saveDealer")
    public ResultModel<Boolean> saveDealer(@RequestBody SaveDealerRequestModel param) throws Exception {

        //保存经销店
        if (param.dealerId == null || param.dealerId.length() <= 0) {
            return ResultModel.failure(ResultCode.PARAM_DEALERID_IS_BLANK);
        }
        if (param.cnName == null || param.cnName.length() <= 0
                || param.aName == null || param.aName.length() <= 0
                || param.address == null || param.address.length() <= 0
                || param.authentication == null || param.authentication.length() <= 0
                || param.dealerType == null || param.dealerType.length() <= 0
                || param.telephone == null || param.telephone.length() <= 0
                || param.registrationTime == null
        ) {
            return ResultModel.failure(ResultCode.PARAM_NOT_COMPLETE);
        }

        Dealer dparam = new Dealer();
        dparam.setDealerId(param.dealerId);
        Dealer dealer = dealerService.findEntity(dparam);
        if (dealer == null) {
            return ResultModel.failure(ResultCode.DEALER_NOT_FOUNT);
        }
        dealer.setCnName(param.cnName);
        dealer.setEnName(param.enName);
        dealer.setAName(param.aName);
        dealer.setWebsite(param.website);
        dealer.setAddress(param.address);
        dealer.setDealerType(param.dealerType);
        dealer.setRegistrationTime(param.registrationTime);
        dealer.setPlateNumber(param.plateNumber);
        dealer.setTelephone(param.telephone);
        dealer.setAuthentication(param.authentication);
        dealer.setRemark(param.remark);
        Long dr = dealerService.updateEntity(dealer);
        if (dr <= 0) {
            return ResultModel.failure(ResultCode.DEALER_SAVE_ERROR);
        }

        //保存经销店主营服务

        //保存经销店联系人

        return ResultModel.Success();
    }

    /**
     * 保存门店主营产品
     * @param param
     * @return
     */
    @PostMapping(value = "saveDealerProductRanges", produces = "application/json;charset=UTF-8")
    public ResultModel<Boolean> saveDealerProductRanges(@RequestBody SaveDealerProductRangeListRequestModel param) throws Exception{
        if(param.dealerProductRanges!=null && param.dealerProductRanges.size()>0){
            for (SaveDealerProductRangesRequestModel item:param.dealerProductRanges
                 ) {
                if(item.dealerProductRangesId==null||item.dealerProductRangesId.length()<=0){
                    item.dealerProductRangesId = UUIDUtils.random().toString();
                }
            }
        }
        try{
            dealerProductRangesService.updateEntityList(param);
        }catch(Exception ex){
            return ResultModel.failure(ResultCode.DEALER_PRODUCT_RANGES_SAVE_ERROR);
        }
    return ResultModel.Success();
    }

    /**
     * 保存门店主营服务
     * @param param
     * @return
     */
    @PostMapping(value = "saveDealerServiceRanges", produces = "application/json;charset=UTF-8")
    public ResultModel<Boolean> saveDealerServiceRanges(@RequestBody SaveDealerServiceRangeListRequestModel param) throws Exception{
        if(param.dealerServiceRanges!=null && param.dealerServiceRanges.size()>0){
            for (SaveDealerServiceRangesRequestModel item:param.dealerServiceRanges
            ) {
                if(item.dealerServiceRangesId==null||item.dealerServiceRangesId.length()<=0){
                    item.dealerServiceRangesId = UUIDUtils.random().toString();
                }
            }
        }
        try{
            dealerServiceRangesService.updateEntityList(param);
        }catch(Exception ex){
            return ResultModel.failure(ResultCode.DEALER_SERVICE_RANGES_SAVE_ERROR);
        }
        return ResultModel.Success();
    }

    @PostMapping("saveDealerContacts")
    public ResultModel<Boolean> saveDealerContacts(@RequestBody SaveDealerContactListRequestModel param) throws Exception{
        if(param.dealerContacts!=null && param.dealerContacts.size()>0){
            for (SaveDealerContactRequestModel item:param.dealerContacts
            ) {
                if(item.dealerContactId==null||item.dealerContactId.length()<=0){
                    item.dealerContactId = UUIDUtils.random().toString();
                }
            }
        }
        Long r =  dealerContactService.updateEntityList(param);
        if(r<=0){
            return ResultModel.failure(ResultCode.DEALER_CONTACT_SAVE_ERROR);
        }
        return ResultModel.Success();
    }


    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat, false));
    }
}







