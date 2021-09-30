package com.wp.eauto.system.domain;



/**
 * table name:  dealer_product
 * author name: Andy
 * create time: 2021-09-30 15:33:33
 */ 

public class DealerProduct{
	private Long id;	//
	private String dealerProductId;	//
	private String dealerId;	//经销商id
	private String productId;	//产品Id
	private Short hasMain;	//是否为主营产品


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDealerProductId() {
		return dealerProductId;
	}

	public void setDealerProductId(String dealerProductId) {
		this.dealerProductId = dealerProductId;
	}

	public String getDealerId() {
		return dealerId;
	}

	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Short getHasMain() {
		return hasMain;
	}

	public void setHasMain(Short hasMain) {
		this.hasMain = hasMain;
	}

}