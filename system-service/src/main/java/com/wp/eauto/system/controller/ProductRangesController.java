package com.wp.eauto.system.controller;


import com.eauto.base.ResultModel;
import com.wp.eauto.system.domain.ProductRanges;
import com.wp.eauto.system.service.ProductRangesService;
import com.wp.eauto.system.viewmodel.request.product.ProductRangesRequestModel;
import com.wp.eauto.system.viewmodel.response.product.ProductRangesResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/ProductRanges", produces = "application/json;charset=UTF-8")
public class ProductRangesController {
    @Autowired
    public ProductRangesService productRangesService;

    @PostMapping("getProductRanges")
    public ResultModel<List<ProductRangesResponseModel>> getProductRanges() throws Exception {
        List<ProductRangesResponseModel> result = new ArrayList();
        List<ProductRanges> productRangesList = productRangesService.findEntityList(new ProductRanges());
        if(productRangesList!=null && productRangesList.size()>0){
            for (ProductRanges pro:productRangesList
                 ) {
                ProductRangesResponseModel pr = new ProductRangesResponseModel();
                pr.productRangesId =pro.getProductRangesId();
                pr.productName = pro.getProductName();
                result.add(pr);
            }
        }
        return ResultModel.Success(result);
    }

}
