package com.wp.eauto.system.domain;



/**
 * table name:  vehicle_series
 * author name: Andy
 * create time: 2021-09-30 15:33:33
 */ 

public class VehicleSeries{
	private Long id;	//
	private String vehicleSeriesId;	//
	private String seriesName;	//车系名称
	private String vehicleBrandId;	//品牌id


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVehicleSeriesId() {
		return vehicleSeriesId;
	}

	public void setVehicleSeriesId(String vehicleSeriesId) {
		this.vehicleSeriesId = vehicleSeriesId;
	}

	public String getSeriesName() {
		return seriesName;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	public String getVehicleBrandId() {
		return vehicleBrandId;
	}

	public void setVehicleBrandId(String vehicleBrandId) {
		this.vehicleBrandId = vehicleBrandId;
	}

}