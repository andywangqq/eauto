package com.wp.eauto.system.mapper;

import com.eauto.mapper.BaseMapper;
import com.wp.eauto.system.domain.DealerContact;
import java.util.List;

/**
 * table name:  dealer_contact
 * author name: Andy
 * create time: 2021-10-04 08:19:31
 */ 


public interface DealerContactMapper extends BaseMapper<DealerContact> {

	long addEntity(DealerContact param);

	boolean deleteEntity(long id);

	long updateEntity(DealerContact param);

	DealerContact findEntity(DealerContact param);

	List<DealerContact> findEntityList(DealerContact param);

}
