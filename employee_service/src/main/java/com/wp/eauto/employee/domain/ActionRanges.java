package com.wp.eauto.employee.domain;

/**
 * table name:  action_ranges
 * author name: 呐喊
 * create time: 2021-06-09 22:59:08
 */ 
public class ActionRanges extends EntityHelper{

	private String id;
	/*活动名称*/
	private String action_name;
	/*父级id*/
	private String pid;
	/*活动层级*/
	private String action_leve;
	/*排序*/
	private String sort;

	public ActionRanges() {
		super();
	}
	public ActionRanges(String id,String action_name,String pid,String action_leve,String sort) {
		this.id=id;
		this.action_name=action_name;
		this.pid=pid;
		this.action_leve=action_leve;
		this.sort=sort;
	}
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setAction_name(String action_name){
		this.action_name=action_name;
	}
	public String getAction_name(){
		return action_name;
	}
	public void setPid(String pid){
		this.pid=pid;
	}
	public String getPid(){
		return pid;
	}
	public void setAction_leve(String action_leve){
		this.action_leve=action_leve;
	}
	public String getAction_leve(){
		return action_leve;
	}
	public void setSort(String sort){
		this.sort=sort;
	}
	public String getSort(){
		return sort;
	}
	@Override
	public String toString() {
		return "action_ranges[" + 
			"id=" + id + 
			", action_name=" + action_name + 
			", pid=" + pid + 
			", action_leve=" + action_leve + 
			", sort=" + sort + 
			"]";
	}
	@Override
	public String getPrimaryKey() {
		return "id";
	}
}

