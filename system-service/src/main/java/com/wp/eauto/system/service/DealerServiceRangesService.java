package com.wp.eauto.system.service;

import com.wp.eauto.system.domain.DealerServiceRanges;
import javax.websocket.server.PathParam;;
import java.util.List;

/**
 * table name:  dealer_service_ranges
 * author name: Andy
 * create time: 2021-10-04 09:27:49
 */ 

public interface DealerServiceRangesService {

	//增加实体
	long addEntity(DealerServiceRanges param) throws Exception;

	//删除实体
	boolean deleteEntity(@PathParam("id") long id) throws Exception;

	//修改实体
	long updateEntity(DealerServiceRanges param) throws Exception;

	//查询实体
	DealerServiceRanges findEntity(DealerServiceRanges param) throws Exception;

	//查询实体List
	List<DealerServiceRanges> findEntityList(DealerServiceRanges param) throws Exception;

}
