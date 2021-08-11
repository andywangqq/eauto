package com.wp.eauto.employee.domain;

import java.util.Date;
import java.math.BigDecimal;
/**
 * table name:  vehicle_type
 * author name: 呐喊
 * create time: 2021-06-09 22:59:08
 */ 
public class VehicleType extends EntityHelper{

	private String id;
	/*车型名称*/
	private String type_name;
	/*车系id*/
	private String vehicle_series_id;
	/*品牌id*/
	private String vehicle_brand_id;

	public VehicleType() {
		super();
	}
	public VehicleType(String id,String type_name,String vehicle_series_id,String vehicle_brand_id) {
		this.id=id;
		this.type_name=type_name;
		this.vehicle_series_id=vehicle_series_id;
		this.vehicle_brand_id=vehicle_brand_id;
	}
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setType_name(String type_name){
		this.type_name=type_name;
	}
	public String getType_name(){
		return type_name;
	}
	public void setVehicle_series_id(String vehicle_series_id){
		this.vehicle_series_id=vehicle_series_id;
	}
	public String getVehicle_series_id(){
		return vehicle_series_id;
	}
	public void setVehicle_brand_id(String vehicle_brand_id){
		this.vehicle_brand_id=vehicle_brand_id;
	}
	public String getVehicle_brand_id(){
		return vehicle_brand_id;
	}
	@Override
	public String toString() {
		return "vehicle_type[" + 
			"id=" + id + 
			", type_name=" + type_name + 
			", vehicle_series_id=" + vehicle_series_id + 
			", vehicle_brand_id=" + vehicle_brand_id + 
			"]";
	}
	@Override
	public String getPrimaryKey() {
		return "id";
	}
}

