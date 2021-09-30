package com.wp.eauto.system.domain;



/**
 * table name:  vehicle_type
 * author name: Andy
 * create time: 2021-09-30 15:33:33
 */ 

public class VehicleType{
	private Long id;	//
	private String vehicleTypeId;	//
	private String typeName;	//车型名称
	private String vehicleSeriesId;	//车系id
	private String vehicleBrandId;	//品牌id


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVehicleTypeId() {
		return vehicleTypeId;
	}

	public void setVehicleTypeId(String vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getVehicleSeriesId() {
		return vehicleSeriesId;
	}

	public void setVehicleSeriesId(String vehicleSeriesId) {
		this.vehicleSeriesId = vehicleSeriesId;
	}

	public String getVehicleBrandId() {
		return vehicleBrandId;
	}

	public void setVehicleBrandId(String vehicleBrandId) {
		this.vehicleBrandId = vehicleBrandId;
	}

}