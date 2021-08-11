package com.wp.eauto.employee.domain;

import java.util.Date;
import java.math.BigDecimal;
/**
 * table name:  vehicle_brand
 * author name: 呐喊
 * create time: 2021-06-09 22:59:08
 */ 
public class VehicleBrand extends EntityHelper{

	private String id;
	/*品牌名称*/
	private String brand_name;

	public VehicleBrand() {
		super();
	}
	public VehicleBrand(String id,String brand_name) {
		this.id=id;
		this.brand_name=brand_name;
	}
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
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
			", brand_name=" + brand_name + 
			"]";
	}
	@Override
	public String getPrimaryKey() {
		return "id";
	}
}

