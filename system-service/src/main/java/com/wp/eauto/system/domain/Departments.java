package com.wp.eauto.system.domain;

import java.util.Date;


/**
 * table name:  departments
 * author name: Andy
 * create time: 2021-09-30 15:33:33
 */ 

public class Departments{
	private Long id;	//
	private String departmentsId;	//
	private String departmentName;	//部门名称
	private String remark;	//备注
	private String dealerId;	//经销商id
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

	public String getDepartmentsId() {
		return departmentsId;
	}

	public void setDepartmentsId(String departmentsId) {
		this.departmentsId = departmentsId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDealerId() {
		return dealerId;
	}

	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
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