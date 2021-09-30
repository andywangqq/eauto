package com.wp.eauto.system.domain;



/**
 * table name:  action_ranges_display
 * author name: Andy
 * create time: 2021-09-30 15:33:32
 */ 

public class ActionRangesDisplay{
	private Long id;	//
	private String actionRangesId;	//
	private String dealerId;	//
	private Integer displayPosition;	//显示位置


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

	public String getDealerId() {
		return dealerId;
	}

	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}

	public Integer getDisplayPosition() {
		return displayPosition;
	}

	public void setDisplayPosition(Integer displayPosition) {
		this.displayPosition = displayPosition;
	}

}