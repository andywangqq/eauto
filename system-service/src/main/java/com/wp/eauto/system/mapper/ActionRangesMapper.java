package com.wp.eauto.system.mapper;

import com.eauto.mapper.BaseMapper;
import com.wp.eauto.system.domain.ActionRanges;
import com.wp.eauto.system.viewmodel.request.action.ActionRequestModel;
import com.wp.eauto.system.viewmodel.response.action.ActionResponseModel;

import java.util.List;

/**
 * table name:  action_ranges
 * author name: Andy
 * create time: 2021-09-30 15:33:33
 */ 


public interface ActionRangesMapper extends BaseMapper<ActionRanges> {

	/**
	 * 查询活动项
	 * @param param
	 * @return
	 */
	List<ActionResponseModel> getActionList(ActionRequestModel param);

	long addEntity(ActionRanges param);

	boolean deleteEntity(long id);

	long updateEntity(ActionRanges param);

	ActionRanges findEntity(ActionRanges param);

	List<ActionRanges> findEntityList(ActionRanges param);

}
