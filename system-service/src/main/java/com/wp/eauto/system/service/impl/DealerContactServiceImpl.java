package com.wp.eauto.system.service.impl;

import com.wp.eauto.system.domain.DealerContact;
import com.wp.eauto.system.mapper.DealerContactMapper;
import com.wp.eauto.system.service.DealerContactService;
import com.wp.eauto.system.viewmodel.request.dealer.SaveDealerContactListRequestModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * table name:  dealer_contact
 * author name: Andy
 * create time: 2021-10-04 08:19:31
 */ 

@Slf4j
@Service("dealerContactService")
public class DealerContactServiceImpl implements DealerContactService {

	@Autowired
	private DealerContactMapper dealerContactMapper;

	@Override
	public long addEntity(DealerContact param) throws Exception {
		try {
			log.info("addEntity");
			dealerContactMapper.addEntity(param);
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
			dealerContactMapper.deleteEntity(id);
			return false;
		} catch(Exception e) {
			log.info("deleteEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public long updateEntity(DealerContact param) throws Exception {
		try {
			log.info("updateEntity");
			dealerContactMapper.updateEntity(param);
			return 0;
		} catch(Exception e) {
			log.info("updateEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public DealerContact findEntity(DealerContact param) throws Exception {
		try {
			log.info("findEntity");
			return dealerContactMapper.findEntity(param);
		} catch(Exception e) {
			log.info("findEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<DealerContact> findEntityList(DealerContact param) throws Exception {
		try {
			log.info("findEntityList");
			return dealerContactMapper.findEntityList(param);
		} catch(Exception e) {
			log.info("findEntityList异常");
			e.printStackTrace();
			throw e;
		}
	}

	//	更新门店联系人
	@Override
	public long updateEntityList(SaveDealerContactListRequestModel param) throws Exception{
		try {
			log.info("updateEntityList");
			return dealerContactMapper.updateEntityList(param);
		} catch(Exception e) {
			log.info("updateEntityList异常");
			e.printStackTrace();
			throw e;
		}
	}
}
