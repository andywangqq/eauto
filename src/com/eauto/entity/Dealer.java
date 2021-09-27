package com.eauto.entity;

import java.util.Date;
/**
 * table name:  dealer
 * author name: Andy
 * create time: 2021-09-27 22:32:06
 */ 
public class Dealer extends EntityHelper{

	private long id;
	private String dealer_id;
	/*中文名称*/
	private String cn_name;
	/*英文名称*/
	private String en_name;
	/*简称*/
	private String a_name;
	/*web站点*/
	private String website;
	/*地址*/
	private String address;
	/*注册时间*/
	private Date registration_time;
	/*本地车牌照*/
	private String plate_number;
	/*固定电话*/
	private String telephone;
	/*经销商类型*/
	private byte dealer_type;
	/*主营产品*/
	private String main_product;
	/*主营车型*/
	private String main_vehicle;
	/*是否已认证*/
	private String authentication;
	/*备注*/
	private String remark;
	/*是否已删除*/
	private byte is_deleted;
	/*创建人*/
	private String create_user_id;
	/*创建时间*/
	private Date create_time;
	/*修改人*/
	private String update_user_id;
	/*修改时间*/
	private Date update_time;

	public Dealer() {
		super();
	}
	public Dealer(long id,String dealer_id,String cn_name,String en_name,String a_name,String website,String address,Date registration_time,String plate_number,String telephone,byte dealer_type,String main_product,String main_vehicle,String authentication,String remark,byte is_deleted,String create_user_id,Date create_time,String update_user_id,Date update_time) {
		this.id=id;
		this.dealer_id=dealer_id;
		this.cn_name=cn_name;
		this.en_name=en_name;
		this.a_name=a_name;
		this.website=website;
		this.address=address;
		this.registration_time=registration_time;
		this.plate_number=plate_number;
		this.telephone=telephone;
		this.dealer_type=dealer_type;
		this.main_product=main_product;
		this.main_vehicle=main_vehicle;
		this.authentication=authentication;
		this.remark=remark;
		this.is_deleted=is_deleted;
		this.create_user_id=create_user_id;
		this.create_time=create_time;
		this.update_user_id=update_user_id;
		this.update_time=update_time;
	}
	public void setId(long id){
		this.id=id;
	}
	public long getId(){
		return id;
	}
	public void setDealer_id(String dealer_id){
		this.dealer_id=dealer_id;
	}
	public String getDealer_id(){
		return dealer_id;
	}
	public void setCn_name(String cn_name){
		this.cn_name=cn_name;
	}
	public String getCn_name(){
		return cn_name;
	}
	public void setEn_name(String en_name){
		this.en_name=en_name;
	}
	public String getEn_name(){
		return en_name;
	}
	public void setA_name(String a_name){
		this.a_name=a_name;
	}
	public String getA_name(){
		return a_name;
	}
	public void setWebsite(String website){
		this.website=website;
	}
	public String getWebsite(){
		return website;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public String getAddress(){
		return address;
	}
	public void setRegistration_time(Date registration_time){
		this.registration_time=registration_time;
	}
	public Date getRegistration_time(){
		return registration_time;
	}
	public void setPlate_number(String plate_number){
		this.plate_number=plate_number;
	}
	public String getPlate_number(){
		return plate_number;
	}
	public void setTelephone(String telephone){
		this.telephone=telephone;
	}
	public String getTelephone(){
		return telephone;
	}
	public void setDealer_type(byte dealer_type){
		this.dealer_type=dealer_type;
	}
	public byte getDealer_type(){
		return dealer_type;
	}
	public void setMain_product(String main_product){
		this.main_product=main_product;
	}
	public String getMain_product(){
		return main_product;
	}
	public void setMain_vehicle(String main_vehicle){
		this.main_vehicle=main_vehicle;
	}
	public String getMain_vehicle(){
		return main_vehicle;
	}
	public void setAuthentication(String authentication){
		this.authentication=authentication;
	}
	public String getAuthentication(){
		return authentication;
	}
	public void setRemark(String remark){
		this.remark=remark;
	}
	public String getRemark(){
		return remark;
	}
	public void setIs_deleted(byte is_deleted){
		this.is_deleted=is_deleted;
	}
	public byte getIs_deleted(){
		return is_deleted;
	}
	public void setCreate_user_id(String create_user_id){
		this.create_user_id=create_user_id;
	}
	public String getCreate_user_id(){
		return create_user_id;
	}
	public void setCreate_time(Date create_time){
		this.create_time=create_time;
	}
	public Date getCreate_time(){
		return create_time;
	}
	public void setUpdate_user_id(String update_user_id){
		this.update_user_id=update_user_id;
	}
	public String getUpdate_user_id(){
		return update_user_id;
	}
	public void setUpdate_time(Date update_time){
		this.update_time=update_time;
	}
	public Date getUpdate_time(){
		return update_time;
	}
	@Override
	public String toString() {
		return "dealer[" + 
			"id=" + id + 
			", dealer_id=" + dealer_id + 
			", cn_name=" + cn_name + 
			", en_name=" + en_name + 
			", a_name=" + a_name + 
			", website=" + website + 
			", address=" + address + 
			", registration_time=" + registration_time + 
			", plate_number=" + plate_number + 
			", telephone=" + telephone + 
			", dealer_type=" + dealer_type + 
			", main_product=" + main_product + 
			", main_vehicle=" + main_vehicle + 
			", authentication=" + authentication + 
			", remark=" + remark + 
			", is_deleted=" + is_deleted + 
			", create_user_id=" + create_user_id + 
			", create_time=" + create_time + 
			", update_user_id=" + update_user_id + 
			", update_time=" + update_time + 
			"]";
	}
	@Override
	public String getPrimaryKey() {
		return "id";
	}
}

