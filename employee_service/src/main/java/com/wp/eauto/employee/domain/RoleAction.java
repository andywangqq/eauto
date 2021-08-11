package com.wp.eauto.employee.domain;

import java.util.Date;
import java.math.BigDecimal;
/**
 * table name:  role_action
 * author name: 呐喊
 * create time: 2021-06-09 22:59:08
 */ 
public class RoleAction extends EntityHelper{

	private String id;
	/*角色id*/
	private String role_id;
	/*活动id*/
	private String action_id;
	/*经销商id*/
	private String dealer_id;

	public RoleAction() {
		super();
	}
	public RoleAction(String id,String role_id,String action_id,String dealer_id) {
		this.id=id;
		this.role_id=role_id;
		this.action_id=action_id;
		this.dealer_id=dealer_id;
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
	public void setAction_id(String action_id){
		this.action_id=action_id;
	}
	public String getAction_id(){
		return action_id;
	}
	public void setDealer_id(String dealer_id){
		this.dealer_id=dealer_id;
	}
	public String getDealer_id(){
		return dealer_id;
	}
	@Override
	public String toString() {
		return "role_action[" + 
			"id=" + id + 
			", role_id=" + role_id + 
			", action_id=" + action_id + 
			", dealer_id=" + dealer_id + 
			"]";
	}
	@Override
	public String getPrimaryKey() {
		return "id";
	}
}

