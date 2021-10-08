package com.wp.eauto.system.service;

import com.wp.eauto.system.domain.DealerProductRanges;
import com.wp.eauto.system.viewmodel.request.dealer.SaveDealerProductRangeListRequestModel;

import javax.websocket.server.PathParam;;
import java.util.List;

/**
 * table name:  dealer_product_ranges
 * author name: Andy
 * create time: 2021-10-04 09:27:49
 */ 

public interface DealerProductRangesService {

	//增加实体
	long addEntity(DealerProductRanges param) throws Exception;

	//删除实体
	boolean deleteEntity(@PathParam("id") long id) throws Exception;

	//修改实体
	long updateEntity(DealerProductRanges param) throws Exception;

	//查询实体
	DealerProductRanges findEntity(DealerProductRanges param) throws Exception;

	//查询实体List
	List<DealerProductRanges> findEntityList(DealerProductRanges param) throws Exception;

	//更新门店主营产品实体集合
	long updateEntityList(SaveDealerProductRangeListRequestModel param) throws Exception;

}
