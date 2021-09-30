package com.wp.eauto.system.domain;



/**
 * table name:  employee_role
 * author name: Andy
 * create time: 2021-09-30 15:33:33
 */ 

public class EmployeeRole{
	private Long id;	//
	private String employeeRoleId;	//
	private String roleId;	//角色id
	private String employeeId;	//人员id


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeRoleId() {
		return employeeRoleId;
	}

	public void setEmployeeRoleId(String employeeRoleId) {
		this.employeeRoleId = employeeRoleId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

}