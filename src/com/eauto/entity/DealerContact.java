package com.eauto.entity;

import java.util.Date;
/**
 * table name:  dealer_contact
 * author name: Andy
 * create time: 2021-08-11 21:51:27
 */ 
public class DealerContact extends EntityHelper{

	private String id;
	/*经销商id*/
	private String dealer_id;
	/*联系人名称*/
	private String contact_name;
	/*电话*/
	private String phone;
	/*邮箱*/
	private String email;
	private String qq;

	public DealerContact() {
		super();
	}
	public DealerContact(String id,String dealer_id,String contact_name,String phone,String email,String qq) {
		this.id=id;
		this.dealer_id=dealer_id;
		this.contact_name=contact_name;
		this.phone=phone;
		this.email=email;
		this.qq=qq;
	}
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setDealer_id(String dealer_id){
		this.dealer_id=dealer_id;
	}
	public String getDealer_id(){
		return dealer_id;
	}
	public void setContact_name(String contact_name){
		this.contact_name=contact_name;
	}
	public String getContact_name(){
		return contact_name;
	}
	public void setPhone(String phone){
		this.phone=phone;
	}
	public String getPhone(){
		return phone;
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
	@Override
	public String toString() {
		return "dealer_contact[" + 
			"id=" + id + 
			", dealer_id=" + dealer_id + 
			", contact_name=" + contact_name + 
			", phone=" + phone + 
			", email=" + email + 
			", qq=" + qq + 
			"]";
	}
	@Override
	public String getPrimaryKey() {
		return "id";
	}
}

