package com.eauto.entity;

import java.util.Date;
import java.math.BigDecimal;
/**
 * table name:  role
 * author name: Andy
 * create time: 2021-08-11 21:51:27
 */ 
public class Role extends EntityHelper{

	private String id;
	/*角色名称*/
	private String role_name;
	/*备注*/
	private String remark;
	/*经销商id*/
	private String dealer_id;
	/*是否已删除*/
	private byte is_deleted;
	/*创建时间*/
	private Date create_time;
	/*创建人*/
	private String create_user_id;
	/*修改时间*/
	private Date update_time;
	/*修改人*/
	private String update_user_id;

	public Role() {
		super();
	}
	public Role(String id,String role_name,String remark,String dealer_id,byte is_deleted,Date create_time,String create_user_id,Date update_time,String update_user_id) {
		this.id=id;
		this.role_name=role_name;
		this.remark=remark;
		this.dealer_id=dealer_id;
		this.is_deleted=is_deleted;
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
	public void setRole_name(String role_name){
		this.role_name=role_name;
	}
	public String getRole_name(){
		return role_name;
	}
	public void setRemark(String remark){
		this.remark=remark;
	}
	public String getRemark(){
		return remark;
	}
	public void setDealer_id(String dealer_id){
		this.dealer_id=dealer_id;
	}
	public String getDealer_id(){
		return dealer_id;
	}
	public void setIs_deleted(byte is_deleted){
		this.is_deleted=is_deleted;
	}
	public byte getIs_deleted(){
		return is_deleted;
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
		return "role[" + 
			"id=" + id + 
			", role_name=" + role_name + 
			", remark=" + remark + 
			", dealer_id=" + dealer_id + 
			", is_deleted=" + is_deleted + 
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

