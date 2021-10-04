package com.wp.eauto.system.mapper;

import com.eauto.mapper.BaseMapper;
import com.wp.eauto.system.domain.DealerServiceRanges;
import java.util.List;

/**
 * table name:  dealer_service_ranges
 * author name: Andy
 * create time: 2021-10-04 08:19:31
 */ 


public interface DealerServiceRangesMapper extends BaseMapper<DealerServiceRanges> {

	long addEntity(DealerServiceRanges param);

	boolean deleteEntity(long id);

	long updateEntity(DealerServiceRanges param);

	DealerServiceRanges findEntity(DealerServiceRanges param);

	List<DealerServiceRanges> findEntityList(DealerServiceRanges param);

}
