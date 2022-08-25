package com.wp.eauto.system.mapper;

import com.eauto.mapper.BaseMapper;
import com.wp.eauto.system.domain.Dealer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * table name:  dealer
 * author name: Andy
 * create time: 2021-10-04 08:19:31
 */ 


public interface DealerMapper extends BaseMapper<Dealer> {

	long addEntity(Dealer param);

	boolean deleteEntity(long id);

	long updateEntity(Dealer param);

	Dealer findEntity(Dealer param);

	List<Dealer> findEntityList(Dealer param);

}
