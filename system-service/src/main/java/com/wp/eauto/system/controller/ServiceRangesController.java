package com.wp.eauto.system.controller;

import com.eauto.base.ResultModel;
import com.wp.eauto.system.domain.ProductRanges;
import com.wp.eauto.system.domain.ServiceRanges;
import com.wp.eauto.system.service.ProductRangesService;
import com.wp.eauto.system.service.ServiceRangesService;
import com.wp.eauto.system.viewmodel.response.product.ProductRangesResponseModel;
import com.wp.eauto.system.viewmodel.response.service.ServiceRangesResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/ServiceRanges", produces = "application/json;charset=UTF-8")
public class ServiceRangesController {
    @Autowired
    public ServiceRangesService serviceRangesService;

    @PostMapping("getServiceRanges")
    public ResultModel<List<ServiceRangesResponseModel>> getServiceRanges() throws Exception {
        List<ServiceRangesResponseModel> result = new ArrayList();
        List<ServiceRanges> serviceRangesList = serviceRangesService.findEntityList(new ServiceRanges());
        if(serviceRangesList!=null && serviceRangesList.size()>0){
            for (ServiceRanges ser:serviceRangesList
            ) {
                ServiceRangesResponseModel se = new ServiceRangesResponseModel();
                se.serviceRangesId =ser.getServiceRangesId();
                se.serviceName = ser.getServiceName();
                result.add(se);
            }
        }
        return ResultModel.Success(result);
    }

}
