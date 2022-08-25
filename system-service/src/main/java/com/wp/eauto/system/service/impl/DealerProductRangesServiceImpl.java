package com.wp.eauto.system.service.impl;

import com.wp.eauto.system.domain.DealerProductRanges;
import com.wp.eauto.system.mapper.DealerProductRangesMapper;
import com.wp.eauto.system.service.DealerProductRangesService;
import com.wp.eauto.system.viewmodel.request.dealer.SaveDealerProductRangeListRequestModel;
import com.wp.eauto.system.viewmodel.request.dealer.SaveDealerProductRangesRequestModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * table name:  dealer_product_ranges
 * author name: Andy
 * create time: 2021-10-04 08:19:31
 */ 

@Slf4j
@Service("dealerProductRangesService")
public class DealerProductRangesServiceImpl implements DealerProductRangesService {

	@Autowired
	private DealerProductRangesMapper dealerProductRangesMapper;

	@Override
	public long addEntity(DealerProductRanges param) throws Exception {
		try {
			log.info("addEntity");
			dealerProductRangesMapper.addEntity(param);
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
			dealerProductRangesMapper.deleteEntity(id);
			return false;
		} catch(Exception e) {
			log.info("deleteEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public long updateEntity(DealerProductRanges param) throws Exception {
		try {
			log.info("updateEntity");
			dealerProductRangesMapper.updateEntity(param);
			return 0;
		} catch(Exception e) {
			log.info("updateEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public DealerProductRanges findEntity(DealerProductRanges param) throws Exception {
		try {
			log.info("findEntity");
			return dealerProductRangesMapper.findEntity(param);
		} catch(Exception e) {
			log.info("findEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<DealerProductRanges> findEntityList(DealerProductRanges param) throws Exception {
		try {
			log.info("findEntityList");
			return dealerProductRangesMapper.findEntityList(param);
		} catch(Exception e) {
			log.info("findEntityList异常");
			e.printStackTrace();
			throw e;
		}
	}

	//更新门店主营产品实体集合
	@Override
	public long updateEntityList(String dealerId, List<SaveDealerProductRangesRequestModel> productList) throws Exception{
		try {
			log.info("updateEntityList");
			return dealerProductRangesMapper.updateEntityList(dealerId,productList);
		} catch(Exception e) {
			log.info("updateEntityList");
			e.printStackTrace();
			throw e;
		}
	}
}
