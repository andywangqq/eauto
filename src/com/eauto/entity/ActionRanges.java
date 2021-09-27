package com.eauto.entity;

/**
 * table name:  action_ranges
 * author name: Andy
 * create time: 2021-09-27 22:32:03
 */ 
public class ActionRanges extends EntityHelper{

	private long id;
	private String action_ranges_id;
	/*活动名称*/
	private String action_name;
	/*父级id*/
	private String pid;
	/*活动层级*/
	private String action_leve;
	/*排序*/
	private int sort;

	public ActionRanges() {
		super();
	}
	public ActionRanges(long id,String action_ranges_id,String action_name,String pid,String action_leve,int sort) {
		this.id=id;
		this.action_ranges_id=action_ranges_id;
		this.action_name=action_name;
		this.pid=pid;
		this.action_leve=action_leve;
		this.sort=sort;
	}
	public void setId(long id){
		this.id=id;
	}
	public long getId(){
		return id;
	}
	public void setAction_ranges_id(String action_ranges_id){
		this.action_ranges_id=action_ranges_id;
	}
	public String getAction_ranges_id(){
		return action_ranges_id;
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
	public void setSort(int sort){
		this.sort=sort;
	}
	public int getSort(){
		return sort;
	}
	@Override
	public String toString() {
		return "action_ranges[" + 
			"id=" + id + 
			", action_ranges_id=" + action_ranges_id + 
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

