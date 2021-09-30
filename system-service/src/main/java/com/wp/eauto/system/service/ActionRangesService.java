package com.wp.eauto.system.service;

import com.wp.eauto.system.domain.ActionRanges;
import com.wp.eauto.system.viewmodel.request.action.ActionRequestModel;
import com.wp.eauto.system.viewmodel.response.action.ActionResponseModel;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * table name:  action_ranges
 * author name: Andy
 * create time: 2021-09-30 15:33:33
 */ 

public interface ActionRangesService {
	/**
	 * 查询活动项
	 * @param param
	 * @return
	 */
	List<ActionResponseModel> getActionList(ActionRequestModel param);

	//增加实体
	long addEntity(ActionRanges param) throws Exception;

	//删除实体
	boolean deleteEntity(@PathParam("id") long id) throws Exception;

	//修改实体
	long updateEntity(ActionRanges param) throws Exception;

	//查询实体
	ActionRanges findEntity(ActionRanges param) throws Exception;

	//查询实体List
	List<ActionRanges> findEntityList(ActionRanges param) throws Exception;

}
