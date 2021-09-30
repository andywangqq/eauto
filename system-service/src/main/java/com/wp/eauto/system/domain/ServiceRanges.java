package com.wp.eauto.system.domain;

import java.util.Date;


/**
 * table name:  service_ranges
 * author name: Andy
 * create time: 2021-09-30 15:33:33
 */ 

public class ServiceRanges{
	private Long id;	//
	private String serviceRangesId;	//
	private String serviceName;	//服务名称
	private Short isDeleted;	//是否已删除
	private Date createTime;	//创建时间
	private String createUserId;	//创建人
	private Date updateTime;	//修改时间
	private String updateUserId;	//修改人


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServiceRangesId() {
		return serviceRangesId;
	}

	public void setServiceRangesId(String serviceRangesId) {
		this.serviceRangesId = serviceRangesId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Short getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Short isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

}