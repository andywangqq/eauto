package com.wp.eauto.system.domain;

import java.util.Date;


/**
 * table name:  employee
 * author name: Andy
 * create time: 2021-09-30 15:33:33
 */ 

public class Employee{
	private Long id;	//
	private String employeeId;	//
	private String employeeName;	//雇员名称
	private Short gender;	//性别
	private String phone;	//电话
	private String departmentId;	//部门id
	private Double allowance;	//津贴
	private Double basePay;	//基本工资
	private String qq;	//
	private String idCardNo;	//身份证
	private String email;	//邮箱
	private Short employeeStatus;	//状态
	private Date hiredate;	//入职日期
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

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Short getGender() {
		return gender;
	}

	public void setGender(Short gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public Double getAllowance() {
		return allowance;
	}

	public void setAllowance(Double allowance) {
		this.allowance = allowance;
	}

	public Double getBasePay() {
		return basePay;
	}

	public void setBasePay(Double basePay) {
		this.basePay = basePay;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Short getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(Short employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
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