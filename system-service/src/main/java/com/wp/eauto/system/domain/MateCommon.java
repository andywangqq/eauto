package com.wp.eauto.system.domain;



/**
 * table name:  mate_common
 * author name: Andy
 * create time: 2021-09-30 15:33:33
 */ 

public class MateCommon{
	private Integer id;	//
	private String mateCode;	//
	private String mateName;	//
	private String mateValue;	//
	private Integer sort;	//


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMateCode() {
		return mateCode;
	}

	public void setMateCode(String mateCode) {
		this.mateCode = mateCode;
	}

	public String getMateName() {
		return mateName;
	}

	public void setMateName(String mateName) {
		this.mateName = mateName;
	}

	public String getMateValue() {
		return mateValue;
	}

	public void setMateValue(String mateValue) {
		this.mateValue = mateValue;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}