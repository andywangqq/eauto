package com.wp.eauto.system.mapper;

import com.eauto.mapper.BaseMapper;
import com.wp.eauto.system.domain.DealerProductRanges;
import com.wp.eauto.system.viewmodel.request.dealer.SaveDealerProductRangeListRequestModel;
import com.wp.eauto.system.viewmodel.request.dealer.SaveDealerProductRangesRequestModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * table name:  dealer_product_ranges
 * author name: Andy
 * create time: 2021-10-04 08:19:31
 */ 


public interface DealerProductRangesMapper extends BaseMapper<DealerProductRanges> {

	long addEntity(DealerProductRanges param);

	boolean deleteEntity(long id);

	long updateEntity(DealerProductRanges param);

	DealerProductRanges findEntity(DealerProductRanges param);

	List<DealerProductRanges> findEntityList(DealerProductRanges param);

	//更新门店主营产品集合
	long updateEntityList( @Param("dealerId") String dealerId, @Param("productList") List<SaveDealerProductRangesRequestModel> productList);

}
