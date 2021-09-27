package com.eauto.entity;

import java.util.Date;
/**
 * table name:  dealer_product
 * author name: Andy
 * create time: 2021-09-27 22:32:06
 */ 
public class DealerProduct extends EntityHelper{

	private long id;
	private String dealer_product_id;
	/*经销商id*/
	private String dealer_id;
	/*产品Id*/
	private String product_id;
	/*是否为主营产品*/
	private byte has_main;

	public DealerProduct() {
		super();
	}
	public DealerProduct(long id,String dealer_product_id,String dealer_id,String product_id,byte has_main) {
		this.id=id;
		this.dealer_product_id=dealer_product_id;
		this.dealer_id=dealer_id;
		this.product_id=product_id;
		this.has_main=has_main;
	}
	public void setId(long id){
		this.id=id;
	}
	public long getId(){
		return id;
	}
	public void setDealer_product_id(String dealer_product_id){
		this.dealer_product_id=dealer_product_id;
	}
	public String getDealer_product_id(){
		return dealer_product_id;
	}
	public void setDealer_id(String dealer_id){
		this.dealer_id=dealer_id;
	}
	public String getDealer_id(){
		return dealer_id;
	}
	public void setProduct_id(String product_id){
		this.product_id=product_id;
	}
	public String getProduct_id(){
		return product_id;
	}
	public void setHas_main(byte has_main){
		this.has_main=has_main;
	}
	public byte getHas_main(){
		return has_main;
	}
	@Override
	public String toString() {
		return "dealer_product[" + 
			"id=" + id + 
			", dealer_product_id=" + dealer_product_id + 
			", dealer_id=" + dealer_id + 
			", product_id=" + product_id + 
			", has_main=" + has_main + 
			"]";
	}
	@Override
	public String getPrimaryKey() {
		return "id";
	}
}

