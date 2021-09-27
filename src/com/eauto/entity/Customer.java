package com.eauto.entity;

import java.util.Date;
/**
 * table name:  customer
 * author name: Andy
 * create time: 2021-09-27 22:32:05
 */ 
public class Customer extends EntityHelper{

	private long id;
	private String customer_id;
	/*用户名称*/
	private String cn_name;
	/*简称*/
	private String short_name;
	/*英文名称*/
	private String en_name;
	/*电话*/
	private String phone;
	/*地址*/
	private String address;
	/*邮箱*/
	private String email;
	/*qq*/
	private String qq;
	/*生日*/
	private null birthday;
	/*客户类型*/
	private String customer_type;
	/*固定电话*/
	private String telephone;
	/*创建时间*/
	private Date create_time;
	/*创建人*/
	private String create_user_id;
	/*更新时间*/
	private Date update_time;
	/*更新人*/
	private String update_user_id;

	public Customer() {
		super();
	}
	public Customer(long id,String customer_id,String cn_name,String short_name,String en_name,String phone,String address,String email,String qq,null birthday,String customer_type,String telephone,Date create_time,String create_user_id,Date update_time,String update_user_id) {
		this.id=id;
		this.customer_id=customer_id;
		this.cn_name=cn_name;
		this.short_name=short_name;
		this.en_name=en_name;
		this.phone=phone;
		this.address=address;
		this.email=email;
		this.qq=qq;
		this.birthday=birthday;
		this.customer_type=customer_type;
		this.telephone=telephone;
		this.create_time=create_time;
		this.create_user_id=create_user_id;
		this.update_time=update_time;
		this.update_user_id=update_user_id;
	}
	public void setId(long id){
		this.id=id;
	}
	public long getId(){
		return id;
	}
	public void setCustomer_id(String customer_id){
		this.customer_id=customer_id;
	}
	public String getCustomer_id(){
		return customer_id;
	}
	public void setCn_name(String cn_name){
		this.cn_name=cn_name;
	}
	public String getCn_name(){
		return cn_name;
	}
	public void setShort_name(String short_name){
		this.short_name=short_name;
	}
	public String getShort_name(){
		return short_name;
	}
	public void setEn_name(String en_name){
		this.en_name=en_name;
	}
	public String getEn_name(){
		return en_name;
	}
	public void setPhone(String phone){
		this.phone=phone;
	}
	public String getPhone(){
		return phone;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public String getAddress(){
		return address;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public String getEmail(){
		return email;
	}
	public void setQq(String qq){
		this.qq=qq;
	}
	public String getQq(){
		return qq;
	}
	public void setBirthday(null birthday){
		this.birthday=birthday;
	}
	public null getBirthday(){
		return birthday;
	}
	public void setCustomer_type(String customer_type){
		this.customer_type=customer_type;
	}
	public String getCustomer_type(){
		return customer_type;
	}
	public void setTelephone(String telephone){
		this.telephone=telephone;
	}
	public String getTelephone(){
		return telephone;
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
		return "customer[" + 
			"id=" + id + 
			", customer_id=" + customer_id + 
			", cn_name=" + cn_name + 
			", short_name=" + short_name + 
			", en_name=" + en_name + 
			", phone=" + phone + 
			", address=" + address + 
			", email=" + email + 
			", qq=" + qq + 
			", birthday=" + birthday + 
			", customer_type=" + customer_type + 
			", telephone=" + telephone + 
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

