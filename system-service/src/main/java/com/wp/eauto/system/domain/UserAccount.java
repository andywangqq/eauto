package com.wp.eauto.system.domain;



/**
 * table name:  user_account
 * author name: Andy
 * create time: 2021-09-30 15:33:33
 */ 

public class UserAccount{
	private Long id;	//
	private String userAccountId;	//
	private String userName;	//用户名
	private String password;	//密码
	private String employeeId;	//人员id
	private Short accountStatus;	//账号状态 1:正常 2:停用
	private Short isDeleted;	//是否已删除


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserAccountId() {
		return userAccountId;
	}

	public void setUserAccountId(String userAccountId) {
		this.userAccountId = userAccountId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Short getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(Short accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Short getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Short isDeleted) {
		this.isDeleted = isDeleted;
	}

}