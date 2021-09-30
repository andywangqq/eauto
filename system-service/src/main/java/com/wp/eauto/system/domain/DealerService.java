package com.wp.eauto.system.domain;



/**
 * table name:  dealer_service
 * author name: Andy
 * create time: 2021-09-30 15:33:33
 */ 

public class DealerService{
	private Long id;	//
	private String dealerServiceId;	//
	private String dealerId;	//经销商id
	private String serviceId;	//服务id
	private Short hasMain;	//是否主营服务


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDealerServiceId() {
		return dealerServiceId;
	}

	public void setDealerServiceId(String dealerServiceId) {
		this.dealerServiceId = dealerServiceId;
	}

	public String getDealerId() {
		return dealerId;
	}

	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public Short getHasMain() {
		return hasMain;
	}

	public void setHasMain(Short hasMain) {
		this.hasMain = hasMain;
	}

}