package com.wp.eauto.system.domain;



/**
 * table name:  action_ranges
 * author name: Andy
 * create time: 2021-09-30 15:33:32
 */ 

public class ActionRanges{
	private Long id;	//
	private String actionRangesId;	//
	private String actionName;	//活动名称
	private String pid;	//父级id
	private String actionLeve;	//活动层级
	private String actionRul;	//活动地址
	private Integer sort;	//排序


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActionRangesId() {
		return actionRangesId;
	}

	public void setActionRangesId(String actionRangesId) {
		this.actionRangesId = actionRangesId;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getActionLeve() {
		return actionLeve;
	}

	public void setActionLeve(String actionLeve) {
		this.actionLeve = actionLeve;
	}

	public String getActionRul() {
		return actionRul;
	}

	public void setActionRul(String actionRul) {
		this.actionRul = actionRul;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}