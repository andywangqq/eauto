package com.wp.eauto.employee.domain;

import java.util.Date;
import java.math.BigDecimal;
/**
 * table name:  employee_role
 * author name: Andy
 * create time: 2021-09-27 22:32:06
 */ 
public class EmployeeRole extends EntityHelper{

	private long id;
	private String employee_role_id;
	/*角色id*/
	private String role_id;
	/*人员id*/
	private String employee_id;

	public EmployeeRole() {
		super();
	}
	public EmployeeRole(long id,String employee_role_id,String role_id,String employee_id) {
		this.id=id;
		this.employee_role_id=employee_role_id;
		this.role_id=role_id;
		this.employee_id=employee_id;
	}
	public void setId(long id){
		this.id=id;
	}
	public long getId(){
		return id;
	}
	public void setEmployee_role_id(String employee_role_id){
		this.employee_role_id=employee_role_id;
	}
	public String getEmployee_role_id(){
		return employee_role_id;
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
			", employee_role_id=" + employee_role_id + 
			", role_id=" + role_id + 
			", employee_id=" + employee_id + 
			"]";
	}
	@Override
	public String getPrimaryKey() {
		return "id";
	}
}

