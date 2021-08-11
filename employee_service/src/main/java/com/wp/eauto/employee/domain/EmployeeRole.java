package com.wp.eauto.employee.domain;

import java.util.Date;
import java.math.BigDecimal;
/**
 * table name:  employee_role
 * author name: 呐喊
 * create time: 2021-06-09 22:59:08
 */ 
public class EmployeeRole extends EntityHelper{

	private String id;
	/*角色id*/
	private String role_id;
	/*人员id*/
	private String employee_id;

	public EmployeeRole() {
		super();
	}
	public EmployeeRole(String id,String role_id,String employee_id) {
		this.id=id;
		this.role_id=role_id;
		this.employee_id=employee_id;
	}
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setRole_id(String role_id){
		this.role_id=role_id;
	}
	public String getRole_id(){
		return role_id;
	}
	public void setEmployee_id(String employee_id){
		this.employee_id=employee_id;
	}
	public String getEmployee_id(){
		return employee_id;
	}
	@Override
	public String toString() {
		return "employee_role[" + 
			"id=" + id + 
			", role_id=" + role_id + 
			", employee_id=" + employee_id + 
			"]";
	}
	@Override
	public String getPrimaryKey() {
		return "id";
	}
}

