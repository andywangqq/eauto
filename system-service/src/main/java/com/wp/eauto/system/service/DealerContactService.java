package com.wp.eauto.system.service;

import com.wp.eauto.system.domain.DealerContact;
import com.wp.eauto.system.viewmodel.request.dealer.SaveDealerContactListRequestModel;

import javax.websocket.server.PathParam;;
import java.util.List;

/**
 * table name:  dealer_contact
 * author name: Andy
 * create time: 2021-10-04 09:27:49
 */ 

public interface DealerContactService {

	//增加实体
	long addEntity(DealerContact param) throws Exception;

	//删除实体
	boolean deleteEntity(@PathParam("id") long id) throws Exception;

	//修改实体
	long updateEntity(DealerContact param) throws Exception;

	//查询实体
	DealerContact findEntity(DealerContact param) throws Exception;

	//查询实体List
	List<DealerContact> findEntityList(DealerContact param) throws Exception;

	//	更新门店联系人
	long updateEntityList(SaveDealerContactListRequestModel param) throws Exception;
}
