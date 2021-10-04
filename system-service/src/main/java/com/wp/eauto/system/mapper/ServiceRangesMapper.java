package com.wp.eauto.system.mapper;

import com.eauto.mapper.BaseMapper;
import com.wp.eauto.system.domain.ServiceRanges;
import java.util.List;

/**
 * table name:  service_ranges
 * author name: Andy
 * create time: 2021-10-04 13:03:44
 */ 


public interface ServiceRangesMapper extends BaseMapper<ServiceRanges> {

	long addEntity(ServiceRanges param);

	boolean deleteEntity(long id);

	long updateEntity(ServiceRanges param);

	ServiceRanges findEntity(ServiceRanges param);

	List<ServiceRanges> findEntityList(ServiceRanges param);

}
