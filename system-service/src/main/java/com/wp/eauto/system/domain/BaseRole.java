package com.wp.eauto.system.domain;



/**
 * table name:  base_role
 * author name: Andy
 * create time: 2021-09-30 15:33:32
 */ 

public class BaseRole{
	private Long id;	//
	private String baseRoleId;	//
	private String roleName;	//
	private String remark;	//


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBaseRoleId() {
		return baseRoleId;
	}

	public void setBaseRoleId(String baseRoleId) {
		this.baseRoleId = baseRoleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}