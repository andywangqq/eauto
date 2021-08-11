package com.wp.eauto.employee.domain;

import java.util.Date;
import java.math.BigDecimal;
/**
 * table name:  product_ranges
 * author name: 呐喊
 * create time: 2021-06-09 22:59:08
 */ 
public class ProductRanges extends EntityHelper{

	private String id;
	/*产品名称*/
	private String product_name;
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

	public ProductRanges() {
		super();
	}
	public ProductRanges(String id,String product_name,byte is_deleted,Date create_time,String create_user_id,Date update_time,String update_user_id) {
		this.id=id;
		this.product_name=product_name;
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
	public void setProduct_name(String product_name){
		this.product_name=product_name;
	}
	public String getProduct_name(){
		return product_name;
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
		return "product_ranges[" + 
			"id=" + id + 
			", product_name=" + product_name + 
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

