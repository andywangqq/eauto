package com.wp.eauto.system.domain;



/**
 * table name:  dealer_service_ranges
 * author name: Andy
 * create time: 2021-10-04 08:19:30
 */ 

public class DealerServiceRanges{
	private Long id;	//
	private String dealerServiceRangesId;	//
	private String serviceRangesId;	//服务范围ID
	private String dealerId;	//经销商id
	private String serviceName;	//服务名称


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDealerServiceRangesId() {
		return dealerServiceRangesId;
	}

	public void setDealerServiceRangesId(String dealerServiceRangesId) {
		this.dealerServiceRangesId = dealerServiceRangesId;
	}

	public String getServiceRangesId() {
		return serviceRangesId;
	}

	public void setServiceRangesId(String serviceRangesId) {
		this.serviceRangesId = serviceRangesId;
	}

	public String getDealerId() {
		return dealerId;
	}

	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

}