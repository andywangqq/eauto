package com.wp.eauto.system.domain;

import java.util.Date;


/**
 * table name:  dealer
 * author name: Andy
 * create time: 2021-10-04 08:19:30
 */ 

public class Dealer{
	private Long id;	//
	private String dealerId;	//
	private String cnName;	//中文名称
	private String enName;	//英文名称
	private String aName;	//简称
	private String website;	//web站点
	private String address;	//地址
	private Date registrationTime;	//注册时间
	private String plateNumber;	//本地车牌照
	private String telephone;	//固定电话
	private String dealerType;	//经销商类型
	private String mainProduct;	//主营产品
	private String mainVehicle;	//主营车型
	private String authentication;	//是否已认证
	private String remark;	//备注
	private Short isDeleted;	//是否已删除
	private String createUserId;	//创建人
	private Date createTime;	//创建时间
	private String updateUserId;	//修改人
	private Date updateTime;	//修改时间


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDealerId() {
		return dealerId;
	}

	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getAName() {
		return aName;
	}

	public void setAName(String aName) {
		this.aName = aName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDealerType() {
		return dealerType;
	}

	public void setDealerType(String dealerType) {
		this.dealerType = dealerType;
	}

	public String getMainProduct() {
		return mainProduct;
	}

	public void setMainProduct(String mainProduct) {
		this.mainProduct = mainProduct;
	}

	public String getMainVehicle() {
		return mainVehicle;
	}

	public void setMainVehicle(String mainVehicle) {
		this.mainVehicle = mainVehicle;
	}

	public String getAuthentication() {
		return authentication;
	}

	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Short getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Short isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}