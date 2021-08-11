package com.wp.eauto.employee.domain;

/**
 * table name:  base_role
 * author name: 呐喊
 * create time: 2021-06-09 22:59:08
 */ 
public class BaseRole extends EntityHelper{

	private String id;
	private String role_name;
	private String remark;

	public BaseRole() {
		super();
	}
	public BaseRole(String id,String role_name,String remark) {
		this.id=id;
		this.role_name=role_name;
		this.remark=remark;
	}
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setRole_name(String role_name){
		this.role_name=role_name;
	}
	public String getRole_name(){
		return role_name;
	}
	public void setRemark(String remark){
		this.remark=remark;
	}
	public String getRemark(){
		return remark;
	}
	@Override
	public String toString() {
		return "base_role[" + 
			"id=" + id + 
			", role_name=" + role_name + 
			", remark=" + remark + 
			"]";
	}
	@Override
	public String getPrimaryKey() {
		return "id";
	}
}

