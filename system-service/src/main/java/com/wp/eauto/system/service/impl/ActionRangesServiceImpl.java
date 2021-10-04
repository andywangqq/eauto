package com.wp.eauto.system.service.impl;

import com.wp.eauto.system.domain.ActionRanges;
import com.wp.eauto.system.mapper.ActionRangesMapper;
import com.wp.eauto.system.service.ActionRangesService;
import com.wp.eauto.system.viewmodel.request.action.ActionRequestModel;
import com.wp.eauto.system.viewmodel.response.action.ActionResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * table name:  action_ranges
 * author name: Andy
 * create time: 2021-09-30 16:03:57
 */

@Slf4j
@Service("actionRangesService")
public class ActionRangesServiceImpl implements ActionRangesService {

	@Autowired
	private ActionRangesMapper actionRangesMapper;

	@Override
	public List<ActionResponseModel> getActionList(ActionRequestModel param) {
		return actionRangesMapper.getActionList(param);
	}

	@Override
	public long addEntity(ActionRanges param) throws Exception {
		try {
			log.info("addEntity");
			actionRangesMapper.addEntity(param);
			return 0;
		} catch(Exception e) {
			log.info("addEntity异常");
			e.printStackTrace();
			throw e;
		}
	}
	@Override
	public boolean deleteEntity(long id) throws Exception {
		try {
			log.info("deleteEntity");
			actionRangesMapper.deleteEntity(id);
			return false;
		} catch(Exception e) {
			log.info("deleteEntity异常");
			e.printStackTrace();
			throw e;
		}
	}
	@Override
	public long updateEntity(ActionRanges param) throws Exception {
		try {
			log.info("updateEntity");
			actionRangesMapper.updateEntity(param);
			return 0;
		} catch(Exception e) {
			log.info("updateEntity异常");
			e.printStackTrace();
			throw e;
		}
	}
	@Override
	public ActionRanges findEntity(ActionRanges param) throws Exception {
		try {
			log.info("findEntity");
			return actionRangesMapper.findEntity(param);
		} catch(Exception e) {
			log.info("findEntity异常");
			e.printStackTrace();
			throw e;
		}
	}
	@Override
	public List<ActionRanges> findEntityList(ActionRanges param) throws Exception {
		try {
			log.info("findEntityList");
			return actionRangesMapper.findEntityList(param);
		} catch(Exception e) {
			log.info("findEntityList异常");
			e.printStackTrace();
			throw e;
		}
	}
}
