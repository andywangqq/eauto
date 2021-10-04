package com.wp.eauto.system.domain;



/**
 * table name:  dealer_product_ranges
 * author name: Andy
 * create time: 2021-10-04 08:19:30
 */ 

public class DealerProductRanges{
	private Long id;	//
	private String dealerProductRangesId;	//
	private String productRangesId;	//产品范围id
	private String dealerId;	//经销商id
	private String productName;	//产品名称


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDealerProductRangesId() {
		return dealerProductRangesId;
	}

	public void setDealerProductRangesId(String dealerProductRangesId) {
		this.dealerProductRangesId = dealerProductRangesId;
	}

	public String getProductRangesId() {
		return productRangesId;
	}

	public void setProductRangesId(String productRangesId) {
		this.productRangesId = productRangesId;
	}

	public String getDealerId() {
		return dealerId;
	}

	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}