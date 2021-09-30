package com.wp.eauto.system.domain;



/**
 * table name:  vehicle_brand
 * author name: Andy
 * create time: 2021-09-30 15:33:33
 */ 

public class VehicleBrand{
	private Long id;	//
	private String vehicleBrandId;	//
	private String brandName;	//品牌名称


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVehicleBrandId() {
		return vehicleBrandId;
	}

	public void setVehicleBrandId(String vehicleBrandId) {
		this.vehicleBrandId = vehicleBrandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

}