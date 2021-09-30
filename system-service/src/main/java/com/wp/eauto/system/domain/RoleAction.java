package com.wp.eauto.system.domain;



/**
 * table name:  role_action
 * author name: Andy
 * create time: 2021-09-30 15:33:33
 */ 

public class RoleAction{
	private Long id;	//
	private String roleActionId;	//
	private String roleId;	//角色id
	private String actionId;	//活动id
	private String dealerId;	//经销商id


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleActionId() {
		return roleActionId;
	}

	public void setRoleActionId(String roleActionId) {
		this.roleActionId = roleActionId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getActionId() {
		return actionId;
	}

	public void setActionId(String actionId) {
		this.actionId = actionId;
	}

	public String getDealerId() {
		return dealerId;
	}

	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}

}