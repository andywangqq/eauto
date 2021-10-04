package com.wp.eauto.system.service;

import com.wp.eauto.system.domain.Dealer;
import com.wp.eauto.system.viewmodel.request.dealer.DealerInfoRequestModel;
import com.wp.eauto.system.viewmodel.response.dealer.DealerInfoResponseModel;

import javax.websocket.server.PathParam;;
import java.util.List;

/**
 * table name:  dealer
 * author name: Andy
 * create time: 2021-10-04 09:27:49
 */ 

public interface DealerService {

	//增加实体
	long addEntity(Dealer param) throws Exception;

	//删除实体
	boolean deleteEntity(@PathParam("id") long id) throws Exception;

	//修改实体
	long updateEntity(Dealer param) throws Exception;

	//查询实体
	Dealer findEntity(Dealer param) throws Exception;

	//查询实体List
	List<Dealer> findEntityList(Dealer param) throws Exception;

}
