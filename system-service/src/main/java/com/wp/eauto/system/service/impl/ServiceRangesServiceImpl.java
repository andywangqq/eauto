package com.wp.eauto.system.service.impl;

import com.wp.eauto.system.domain.ServiceRanges;
import com.wp.eauto.system.mapper.ServiceRangesMapper;
import com.wp.eauto.system.service.ServiceRangesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * table name:  service_ranges
 * author name: Andy
 * create time: 2021-10-04 13:03:44
 */ 

@Slf4j
@Service("serviceRangesService")
public class ServiceRangesServiceImpl implements ServiceRangesService {

	@Autowired
	private ServiceRangesMapper serviceRangesMapper;

	@Override
	public long addEntity(ServiceRanges param) throws Exception {
		try {
			log.info("addEntity");
			serviceRangesMapper.addEntity(param);
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
			serviceRangesMapper.deleteEntity(id);
			return false;
		} catch(Exception e) {
			log.info("deleteEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public long updateEntity(ServiceRanges param) throws Exception {
		try {
			log.info("updateEntity");
			serviceRangesMapper.updateEntity(param);
			return 0;
		} catch(Exception e) {
			log.info("updateEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public ServiceRanges findEntity(ServiceRanges param) throws Exception {
		try {
			log.info("findEntity");
			return serviceRangesMapper.findEntity(param);
		} catch(Exception e) {
			log.info("findEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<ServiceRanges> findEntityList(ServiceRanges param) throws Exception {
		try {
			log.info("findEntityList");
			return serviceRangesMapper.findEntityList(param);
		} catch(Exception e) {
			log.info("findEntityList异常");
			e.printStackTrace();
			throw e;
		}
	}
}
