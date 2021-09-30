package com.wp.eauto.system.domain;



/**
 * table name:  employee_action
 * author name: Andy
 * create time: 2021-09-30 15:33:33
 */ 

public class EmployeeAction{
	private Long id;	//
	private String employeeActionId;	//
	private String employeeId;	//人员id
	private String actionId;	//活动id


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeActionId() {
		return employeeActionId;
	}

	public void setEmployeeActionId(String employeeActionId) {
		this.employeeActionId = employeeActionId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getActionId() {
		return actionId;
	}

	public void setActionId(String actionId) {
		this.actionId = actionId;
	}

}