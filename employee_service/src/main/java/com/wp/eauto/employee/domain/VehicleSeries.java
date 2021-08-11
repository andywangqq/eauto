package com.wp.eauto.employee.domain;

import java.util.Date;
import java.math.BigDecimal;
/**
 * table name:  vehicle_series
 * author name: 呐喊
 * create time: 2021-06-09 22:59:08
 */ 
public class VehicleSeries extends EntityHelper{

	private String id;
	/*车系名称*/
	private String series_name;
	/*品牌id*/
	private String vehicle_brand_id;

	public VehicleSeries() {
		super();
	}
	public VehicleSeries(String id,String series_name,String vehicle_brand_id) {
		this.id=id;
		this.series_name=series_name;
		this.vehicle_brand_id=vehicle_brand_id;
	}
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setSeries_name(String series_name){
		this.series_name=series_name;
	}
	public String getSeries_name(){
		return series_name;
	}
	public void setVehicle_brand_id(String vehicle_brand_id){
		this.vehicle_brand_id=vehicle_brand_id;
	}
	public String getVehicle_brand_id(){
		return vehicle_brand_id;
	}
	@Override
	public String toString() {
		return "vehicle_series[" + 
			"id=" + id + 
			", series_name=" + series_name + 
			", vehicle_brand_id=" + vehicle_brand_id + 
			"]";
	}
	@Override
	public String getPrimaryKey() {
		return "id";
	}
}

