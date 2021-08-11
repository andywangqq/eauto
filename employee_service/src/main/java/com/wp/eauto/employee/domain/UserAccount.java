package com.wp.eauto.employee.domain;

import java.util.Date;
import java.math.BigDecimal;
/**
 * table name:  user_account
 * author name: 呐喊
 * create time: 2021-06-09 22:59:08
 */ 
public class UserAccount extends EntityHelper{

	private String id;
	/*用户名*/
	private String user_name;
	/*密码*/
	private String password;
	/*人员id*/
	private String employee_id;
	/*账号状态*/
	private byte account_status;
	/*是否已删除*/
	private byte is_deleted;

	public UserAccount() {
		super();
	}
	public UserAccount(String id,String user_name,String password,String employee_id,byte account_status,byte is_deleted) {
		this.id=id;
		this.user_name=user_name;
		this.password=password;
		this.employee_id=employee_id;
		this.account_status=account_status;
		this.is_deleted=is_deleted;
	}
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setUser_name(String user_name){
		this.user_name=user_name;
	}
	public String getUser_name(){
		return user_name;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return password;
	}
	public void setEmployee_id(String employee_id){
		this.employee_id=employee_id;
	}
	public String getEmployee_id(){
		return employee_id;
	}
	public void setAccount_status(byte account_status){
		this.account_status=account_status;
	}
	public byte getAccount_status(){
		return account_status;
	}
	public void setIs_deleted(byte is_deleted){
		this.is_deleted=is_deleted;
	}
	public byte getIs_deleted(){
		return is_deleted;
	}
	@Override
	public String toString() {
		return "user_account[" + 
			"id=" + id + 
			", user_name=" + user_name + 
			", password=" + password + 
			", employee_id=" + employee_id + 
			", account_status=" + account_status + 
			", is_deleted=" + is_deleted + 
			"]";
	}
	@Override
	public String getPrimaryKey() {
		return "id";
	}
}

