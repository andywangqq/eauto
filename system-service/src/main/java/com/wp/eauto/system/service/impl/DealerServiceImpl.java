package com.wp.eauto.system.service.impl;

import com.wp.eauto.system.domain.Dealer;
import com.wp.eauto.system.mapper.DealerMapper;
import com.wp.eauto.system.service.DealerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * table name:  dealer
 * author name: Andy
 * create time: 2021-10-04 08:19:31
 */ 

@Slf4j
@Service("dealerService")
public class DealerServiceImpl implements DealerService {

	private static SqlSessionFactory sqlSessionFactory;
	@Autowired
	private DealerMapper dealerMapper;

	@Override
	public long addEntity(Dealer param) throws Exception {
		try {
			log.info("addEntity");
			dealerMapper.addEntity(param);
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
			dealerMapper.deleteEntity(id);
			return false;
		} catch(Exception e) {
			log.info("deleteEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public long updateEntity(Dealer param) throws Exception {


		try {
			log.info("updateEntity");
			return dealerMapper.updateEntity(param);
		} catch(Exception e) {
			log.info("updateEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Dealer findEntity(Dealer param) throws Exception {
		try {
			log.info("findEntity");
			return dealerMapper.findEntity(param);
		} catch(Exception e) {
			log.info("findEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Dealer> findEntityList(Dealer param) throws Exception {
		try {
			log.info("findEntityList");
			return dealerMapper.findEntityList(param);
		} catch(Exception e) {
			log.info("findEntityList异常");
			e.printStackTrace();
			throw e;
		}
	}
}
