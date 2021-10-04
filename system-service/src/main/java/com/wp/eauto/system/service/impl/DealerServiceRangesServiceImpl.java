package com.wp.eauto.system.service.impl;

import com.wp.eauto.system.domain.DealerServiceRanges;
import com.wp.eauto.system.mapper.DealerServiceRangesMapper;
import com.wp.eauto.system.service.DealerServiceRangesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * table name:  dealer_service_ranges
 * author name: Andy
 * create time: 2021-10-04 08:19:31
 */ 

@Slf4j
@Service("dealerServiceRangesService")
public class DealerServiceRangesServiceImpl implements DealerServiceRangesService {

	@Autowired
	private DealerServiceRangesMapper dealerServiceRangesMapper;

	@Override
	public long addEntity(DealerServiceRanges param) throws Exception {
		try {
			log.info("addEntity");
			dealerServiceRangesMapper.addEntity(param);
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
			dealerServiceRangesMapper.deleteEntity(id);
			return false;
		} catch(Exception e) {
			log.info("deleteEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public long updateEntity(DealerServiceRanges param) throws Exception {
		try {
			log.info("updateEntity");
			dealerServiceRangesMapper.updateEntity(param);
			return 0;
		} catch(Exception e) {
			log.info("updateEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public DealerServiceRanges findEntity(DealerServiceRanges param) throws Exception {
		try {
			log.info("findEntity");
			return dealerServiceRangesMapper.findEntity(param);
		} catch(Exception e) {
			log.info("findEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<DealerServiceRanges> findEntityList(DealerServiceRanges param) throws Exception {
		try {
			log.info("findEntityList");
			return dealerServiceRangesMapper.findEntityList(param);
		} catch(Exception e) {
			log.info("findEntityList异常");
			e.printStackTrace();
			throw e;
		}
	}
}
