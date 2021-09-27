package com.eauto.entity;

import java.util.Date;
/**
 * table name:  dealer_image
 * author name: Andy
 * create time: 2021-09-27 22:32:06
 */ 
public class DealerImage extends EntityHelper{

	private long id;
	private String dealer_image_id;
	/*经销商id*/
	private String dealer_id;
	/*图片后缀*/
	private String image_suffix;
	/*图片类型*/
	private String image_type;
	/*图片路径*/
	private String image_url;
	/*排序*/
	private int sort;
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

	public DealerImage() {
		super();
	}
	public DealerImage(long id,String dealer_image_id,String dealer_id,String image_suffix,String image_type,String image_url,int sort,byte is_deleted,String create_user_id,Date create_time,String update_user_id,Date update_time) {
		this.id=id;
		this.dealer_image_id=dealer_image_id;
		this.dealer_id=dealer_id;
		this.image_suffix=image_suffix;
		this.image_type=image_type;
		this.image_url=image_url;
		this.sort=sort;
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
	public void setDealer_image_id(String dealer_image_id){
		this.dealer_image_id=dealer_image_id;
	}
	public String getDealer_image_id(){
		return dealer_image_id;
	}
	public void setDealer_id(String dealer_id){
		this.dealer_id=dealer_id;
	}
	public String getDealer_id(){
		return dealer_id;
	}
	public void setImage_suffix(String image_suffix){
		this.image_suffix=image_suffix;
	}
	public String getImage_suffix(){
		return image_suffix;
	}
	public void setImage_type(String image_type){
		this.image_type=image_type;
	}
	public String getImage_type(){
		return image_type;
	}
	public void setImage_url(String image_url){
		this.image_url=image_url;
	}
	public String getImage_url(){
		return image_url;
	}
	public void setSort(int sort){
		this.sort=sort;
	}
	public int getSort(){
		return sort;
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
		return "dealer_image[" + 
			"id=" + id + 
			", dealer_image_id=" + dealer_image_id + 
			", dealer_id=" + dealer_id + 
			", image_suffix=" + image_suffix + 
			", image_type=" + image_type + 
			", image_url=" + image_url + 
			", sort=" + sort + 
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

