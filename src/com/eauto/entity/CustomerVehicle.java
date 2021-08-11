package com.eauto.entity;

import java.util.Date;
/**
 * table name:  customer_vehicle
 * author name: Andy
 * create time: 2021-08-11 21:51:27
 */ 
public class CustomerVehicle extends EntityHelper{

	private String id;
	/*车牌照*/
	private String number_plate;
	/*车主*/
	private String vehicle_owner;
	/*手机号*/
	private String phone;
	/*购买日期*/
	private Date purchase_date;
	/*品牌Id*/
	private String brand_id;
	/*车系Id*/
	private String series_id;
	/*车型Id*/
	private String type_id;
	/*车架号*/
	private String vin;
	/*发动机号*/
	private String engine_number;
	/*年份*/
	private int years;
	/*汽车排放量*/
	private String vehicle_capacity;
	/*颜色*/
	private String color;
	/*当前历程*/
	private int current_mileage;
	/*保养周期*/
	private int service_interval;
	/*创建时间*/
	private Date create_time;
	/*创建人*/
	private String create_user_id;
	/*更新时间*/
	private Date update_time;
	/*更新人*/
	private String update_user_id;

	public CustomerVehicle() {
		super();
	}
	public CustomerVehicle(String id,String number_plate,String vehicle_owner,String phone,Date purchase_date,String brand_id,String series_id,String type_id,String vin,String engine_number,int years,String vehicle_capacity,String color,int current_mileage,int service_interval,Date create_time,String create_user_id,Date update_time,String update_user_id) {
		this.id=id;
		this.number_plate=number_plate;
		this.vehicle_owner=vehicle_owner;
		this.phone=phone;
		this.purchase_date=purchase_date;
		this.brand_id=brand_id;
		this.series_id=series_id;
		this.type_id=type_id;
		this.vin=vin;
		this.engine_number=engine_number;
		this.years=years;
		this.vehicle_capacity=vehicle_capacity;
		this.color=color;
		this.current_mileage=current_mileage;
		this.service_interval=service_interval;
		this.create_time=create_time;
		this.create_user_id=create_user_id;
		this.update_time=update_time;
		this.update_user_id=update_user_id;
	}
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setNumber_plate(String number_plate){
		this.number_plate=number_plate;
	}
	public String getNumber_plate(){
		return number_plate;
	}
	public void setVehicle_owner(String vehicle_owner){
		this.vehicle_owner=vehicle_owner;
	}
	public String getVehicle_owner(){
		return vehicle_owner;
	}
	public void setPhone(String phone){
		this.phone=phone;
	}
	public String getPhone(){
		return phone;
	}
	public void setPurchase_date(Date purchase_date){
		this.purchase_date=purchase_date;
	}
	public Date getPurchase_date(){
		return purchase_date;
	}
	public void setBrand_id(String brand_id){
		this.brand_id=brand_id;
	}
	public String getBrand_id(){
		return brand_id;
	}
	public void setSeries_id(String series_id){
		this.series_id=series_id;
	}
	public String getSeries_id(){
		return series_id;
	}
	public void setType_id(String type_id){
		this.type_id=type_id;
	}
	public String getType_id(){
		return type_id;
	}
	public void setVin(String vin){
		this.vin=vin;
	}
	public String getVin(){
		return vin;
	}
	public void setEngine_number(String engine_number){
		this.engine_number=engine_number;
	}
	public String getEngine_number(){
		return engine_number;
	}
	public void setYears(int years){
		this.years=years;
	}
	public int getYears(){
		return years;
	}
	public void setVehicle_capacity(String vehicle_capacity){
		this.vehicle_capacity=vehicle_capacity;
	}
	public String getVehicle_capacity(){
		return vehicle_capacity;
	}
	public void setColor(String color){
		this.color=color;
	}
	public String getColor(){
		return color;
	}
	public void setCurrent_mileage(int current_mileage){
		this.current_mileage=current_mileage;
	}
	public int getCurrent_mileage(){
		return current_mileage;
	}
	public void setService_interval(int service_interval){
		this.service_interval=service_interval;
	}
	public int getService_interval(){
		return service_interval;
	}
	public void setCreate_time(Date create_time){
		this.create_time=create_time;
	}
	public Date getCreate_time(){
		return create_time;
	}
	public void setCreate_user_id(String create_user_id){
		this.create_user_id=create_user_id;
	}
	public String getCreate_user_id(){
		return create_user_id;
	}
	public void setUpdate_time(Date update_time){
		this.update_time=update_time;
	}
	public Date getUpdate_time(){
		return update_time;
	}
	public void setUpdate_user_id(String update_user_id){
		this.update_user_id=update_user_id;
	}
	public String getUpdate_user_id(){
		return update_user_id;
	}
	@Override
	public String toString() {
		return "customer_vehicle[" + 
			"id=" + id + 
			", number_plate=" + number_plate + 
			", vehicle_owner=" + vehicle_owner + 
			", phone=" + phone + 
			", purchase_date=" + purchase_date + 
			", brand_id=" + brand_id + 
			", series_id=" + series_id + 
			", type_id=" + type_id + 
			", vin=" + vin + 
			", engine_number=" + engine_number + 
			", years=" + years + 
			", vehicle_capacity=" + vehicle_capacity + 
			", color=" + color + 
			", current_mileage=" + current_mileage + 
			", service_interval=" + service_interval + 
			", create_time=" + create_time + 
			", create_user_id=" + create_user_id + 
			", update_time=" + update_time + 
			", update_user_id=" + update_user_id + 
			"]";
	}
	@Override
	public String getPrimaryKey() {
		return "id";
	}
}

