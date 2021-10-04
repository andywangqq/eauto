package com.wp.eauto.system.service;

import com.wp.eauto.system.domain.ProductRanges;
import javax.websocket.server.PathParam;;
import java.util.List;

/**
 * table name:  product_ranges
 * author name: Andy
 * create time: 2021-10-04 13:03:44
 */ 

public interface ProductRangesService {

	//增加实体
	long addEntity(ProductRanges param) throws Exception;

	//删除实体
	boolean deleteEntity(@PathParam("id") long id) throws Exception;

	//修改实体
	long updateEntity(ProductRanges param) throws Exception;

	//查询实体
	ProductRanges findEntity(ProductRanges param) throws Exception;

	//查询实体List
	List<ProductRanges> findEntityList(ProductRanges param) throws Exception;

}
