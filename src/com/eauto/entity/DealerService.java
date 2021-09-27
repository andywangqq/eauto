package com.eauto.entity;

import java.util.Date;
/**
 * table name:  dealer_service
 * author name: Andy
 * create time: 2021-09-27 22:32:06
 */ 
public class DealerService extends EntityHelper{

	private long id;
	private String dealer_service_id;
	/*经销商id*/
	private String dealer_id;
	/*服务id*/
	private String service_id;
	/*是否主营服务*/
	private byte has_main;

	public DealerService() {
		super();
	}
	public DealerService(long id,String dealer_service_id,String dealer_id,String service_id,byte has_main) {
		this.id=id;
		this.dealer_service_id=dealer_service_id;
		this.dealer_id=dealer_id;
		this.service_id=service_id;
		this.has_main=has_main;
	}
	public void setId(long id){
		this.id=id;
	}
	public long getId(){
		return id;
	}
	public void setDealer_service_id(String dealer_service_id){
		this.dealer_service_id=dealer_service_id;
	}
	public String getDealer_service_id(){
		return dealer_service_id;
	}
	public void setDealer_id(String dealer_id){
		this.dealer_id=dealer_id;
	}
	public String getDealer_id(){
		return dealer_id;
	}
	public void setService_id(String service_id){
		this.service_id=service_id;
	}
	public String getService_id(){
		return service_id;
	}
	public void setHas_main(byte has_main){
		this.has_main=has_main;
	}
	public byte getHas_main(){
		return has_main;
	}
	@Override
	public String toString() {
		return "dealer_service[" + 
			"id=" + id + 
			", dealer_service_id=" + dealer_service_id + 
			", dealer_id=" + dealer_id + 
			", service_id=" + service_id + 
			", has_main=" + has_main + 
			"]";
	}
	@Override
	public String getPrimaryKey() {
		return "id";
	}
}

