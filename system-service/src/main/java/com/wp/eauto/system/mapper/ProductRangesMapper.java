package com.wp.eauto.system.mapper;

import com.eauto.mapper.BaseMapper;
import com.wp.eauto.system.domain.ProductRanges;
import java.util.List;

/**
 * table name:  product_ranges
 * author name: Andy
 * create time: 2021-10-04 13:03:44
 */ 


public interface ProductRangesMapper extends BaseMapper<ProductRanges> {

	long addEntity(ProductRanges param);

	boolean deleteEntity(long id);

	long updateEntity(ProductRanges param);

	ProductRanges findEntity(ProductRanges param);

	List<ProductRanges> findEntityList(ProductRanges param);

}
