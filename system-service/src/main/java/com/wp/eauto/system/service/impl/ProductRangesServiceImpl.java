package com.wp.eauto.system.service.impl;

import com.wp.eauto.system.domain.ProductRanges;
import com.wp.eauto.system.mapper.ProductRangesMapper;
import com.wp.eauto.system.service.ProductRangesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * table name:  product_ranges
 * author name: Andy
 * create time: 2021-10-04 13:03:44
 */ 

@Slf4j
@Service("productRangesService")
public class ProductRangesServiceImpl implements ProductRangesService {

	@Autowired
	private ProductRangesMapper productRangesMapper;

	@Override
	public long addEntity(ProductRanges param) throws Exception {
		try {
			log.info("addEntity");
			productRangesMapper.addEntity(param);
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
			productRangesMapper.deleteEntity(id);
			return false;
		} catch(Exception e) {
			log.info("deleteEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public long updateEntity(ProductRanges param) throws Exception {
		try {
			log.info("updateEntity");
			productRangesMapper.updateEntity(param);
			return 0;
		} catch(Exception e) {
			log.info("updateEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public ProductRanges findEntity(ProductRanges param) throws Exception {
		try {
			log.info("findEntity");
			return productRangesMapper.findEntity(param);
		} catch(Exception e) {
			log.info("findEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<ProductRanges> findEntityList(ProductRanges param) throws Exception {
		try {
			log.info("findEntityList");
			return productRangesMapper.findEntityList(param);
		} catch(Exception e) {
			log.info("findEntityList异常");
			e.printStackTrace();
			throw e;
		}
	}
}
