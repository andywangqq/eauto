package com.eauto.entity;

import java.util.Date;
import java.math.BigDecimal;
/**
 * table name:  vehicle_series
 * author name: Andy
 * create time: 2021-09-27 22:32:06
 */ 
public class VehicleSeries extends EntityHelper{

	private long id;
	private String vehicle_series_id;
	/*车系名称*/
	private String series_name;
	/*品牌id*/
	private String vehicle_brand_id;

	public VehicleSeries() {
		super();
	}
	public VehicleSeries(long id,String vehicle_series_id,String series_name,String vehicle_brand_id) {
		this.id=id;
		this.vehicle_series_id=vehicle_series_id;
		this.series_name=series_name;
		this.vehicle_brand_id=vehicle_brand_id;
	}
	public void setId(long id){
		this.id=id;
	}
	public long getId(){
		return id;
	}
	public void setVehicle_series_id(String vehicle_series_id){
		this.vehicle_series_id=vehicle_series_id;
	}
	public String getVehicle_series_id(){
		return vehicle_series_id;
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
			", vehicle_series_id=" + vehicle_series_id + 
			", series_name=" + series_name + 
			", vehicle_brand_id=" + vehicle_brand_id + 
			"]";
	}
	@Override
	public String getPrimaryKey() {
		return "id";
	}
}

