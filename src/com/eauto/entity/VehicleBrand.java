package com.eauto.entity;

import java.util.Date;
import java.math.BigDecimal;
/**
 * table name:  vehicle_brand
 * author name: Andy
 * create time: 2021-09-27 22:32:06
 */ 
public class VehicleBrand extends EntityHelper{

	private long id;
	private String vehicle_brand_id;
	/*品牌名称*/
	private String brand_name;

	public VehicleBrand() {
		super();
	}
	public VehicleBrand(long id,String vehicle_brand_id,String brand_name) {
		this.id=id;
		this.vehicle_brand_id=vehicle_brand_id;
		this.brand_name=brand_name;
	}
	public void setId(long id){
		this.id=id;
	}
	public long getId(){
		return id;
	}
	public void setVehicle_brand_id(String vehicle_brand_id){
		this.vehicle_brand_id=vehicle_brand_id;
	}
	public String getVehicle_brand_id(){
		return vehicle_brand_id;
	}
	public void setBrand_name(String brand_name){
		this.brand_name=brand_name;
	}
	public String getBrand_name(){
		return brand_name;
	}
	@Override
	public String toString() {
		return "vehicle_brand[" + 
			"id=" + id + 
			", vehicle_brand_id=" + vehicle_brand_id + 
			", brand_name=" + brand_name + 
			"]";
	}
	@Override
	public String getPrimaryKey() {
		return "id";
	}
}

