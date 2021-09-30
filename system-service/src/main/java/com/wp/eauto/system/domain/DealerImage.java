package com.wp.eauto.system.domain;

import java.util.Date;


/**
 * table name:  dealer_image
 * author name: Andy
 * create time: 2021-09-30 15:33:33
 */ 

public class DealerImage{
	private Long id;	//
	private String dealerImageId;	//
	private String dealerId;	//经销商id
	private String imageSuffix;	//图片后缀
	private String imageType;	//图片类型
	private String imageUrl;	//图片路径
	private Integer sort;	//排序
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

	public String getDealerImageId() {
		return dealerImageId;
	}

	public void setDealerImageId(String dealerImageId) {
		this.dealerImageId = dealerImageId;
	}

	public String getDealerId() {
		return dealerId;
	}

	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}

	public String getImageSuffix() {
		return imageSuffix;
	}

	public void setImageSuffix(String imageSuffix) {
		this.imageSuffix = imageSuffix;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
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