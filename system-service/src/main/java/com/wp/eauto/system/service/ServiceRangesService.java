package com.wp.eauto.system.service;

import com.wp.eauto.system.domain.ServiceRanges;
import javax.websocket.server.PathParam;;
import java.util.List;

/**
 * table name:  service_ranges
 * author name: Andy
 * create time: 2021-10-04 13:03:44
 */ 

public interface ServiceRangesService {

	//增加实体
	long addEntity(ServiceRanges param) throws Exception;

	//删除实体
	boolean deleteEntity(@PathParam("id") long id) throws Exception;

	//修改实体
	long updateEntity(ServiceRanges param) throws Exception;

	//查询实体
	ServiceRanges findEntity(ServiceRanges param) throws Exception;

	//查询实体List
	List<ServiceRanges> findEntityList(ServiceRanges param) throws Exception;

}
