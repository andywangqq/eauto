package com.eauto.entity;

/**
 * table name:  base_role
 * author name: Andy
 * create time: 2021-09-27 22:32:05
 */ 
public class BaseRole extends EntityHelper{

	private long id;
	private String base_role_id;
	private String role_name;
	private String remark;

	public BaseRole() {
		super();
	}
	public BaseRole(long id,String base_role_id,String role_name,String remark) {
		this.id=id;
		this.base_role_id=base_role_id;
		this.role_name=role_name;
		this.remark=remark;
	}
	public void setId(long id){
		this.id=id;
	}
	public long getId(){
		return id;
	}
	public void setBase_role_id(String base_role_id){
		this.base_role_id=base_role_id;
	}
	public String getBase_role_id(){
		return base_role_id;
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
			", base_role_id=" + base_role_id + 
			", role_name=" + role_name + 
			", remark=" + remark + 
			"]";
	}
	@Override
	public String getPrimaryKey() {
		return "id";
	}
}

