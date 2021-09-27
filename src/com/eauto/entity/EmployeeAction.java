package com.eauto.entity;

import java.util.Date;
import java.math.BigDecimal;
/**
 * table name:  employee_action
 * author name: Andy
 * create time: 2021-09-27 22:32:06
 */ 
public class EmployeeAction extends EntityHelper{

	private long id;
	private String employee_action_id;
	/*人员id*/
	private String employee_id;
	/*活动id*/
	private String action_id;

	public EmployeeAction() {
		super();
	}
	public EmployeeAction(long id,String employee_action_id,String employee_id,String action_id) {
		this.id=id;
		this.employee_action_id=employee_action_id;
		this.employee_id=employee_id;
		this.action_id=action_id;
	}
	public void setId(long id){
		this.id=id;
	}
	public long getId(){
		return id;
	}
	public void setEmployee_action_id(String employee_action_id){
		this.employee_action_id=employee_action_id;
	}
	public String getEmployee_action_id(){
		return employee_action_id;
	}
	public void setEmployee_id(String employee_id){
		this.employee_id=employee_id;
	}
	public String getEmployee_id(){
		return employee_id;
	}
	public void setAction_id(String action_id){
		this.action_id=action_id;
	}
	public String getAction_id(){
		return action_id;
	}
	@Override
	public String toString() {
		return "employee_action[" + 
			"id=" + id + 
			", employee_action_id=" + employee_action_id + 
			", employee_id=" + employee_id + 
			", action_id=" + action_id + 
			"]";
	}
	@Override
	public String getPrimaryKey() {
		return "id";
	}
}

