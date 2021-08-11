package com.wp.eauto.employee.domain;

import java.util.Date;
import java.math.BigDecimal;
/**
 * table name:  mate_common
 * author name: 呐喊
 * create time: 2021-06-09 22:59:08
 */ 
public class MateCommon extends EntityHelper{

	/*字典名称*/
	private String mate_name;
	/*字典code*/
	private String mate_code;
	/*code中文*/
	private String code_cn_desc;
	/*code英文*/
	private String code_en_desc;
	/*字典排序*/
	private byte mate_sort;

	public MateCommon() {
		super();
	}
	public MateCommon(String mate_name,String mate_code,String code_cn_desc,String code_en_desc,byte mate_sort) {
		this.mate_name=mate_name;
		this.mate_code=mate_code;
		this.code_cn_desc=code_cn_desc;
		this.code_en_desc=code_en_desc;
		this.mate_sort=mate_sort;
	}
	public void setMate_name(String mate_name){
		this.mate_name=mate_name;
	}
	public String getMate_name(){
		return mate_name;
	}
	public void setMate_code(String mate_code){
		this.mate_code=mate_code;
	}
	public String getMate_code(){
		return mate_code;
	}
	public void setCode_cn_desc(String code_cn_desc){
		this.code_cn_desc=code_cn_desc;
	}
	public String getCode_cn_desc(){
		return code_cn_desc;
	}
	public void setCode_en_desc(String code_en_desc){
		this.code_en_desc=code_en_desc;
	}
	public String getCode_en_desc(){
		return code_en_desc;
	}
	public void setMate_sort(byte mate_sort){
		this.mate_sort=mate_sort;
	}
	public byte getMate_sort(){
		return mate_sort;
	}
	@Override
	public String toString() {
		return "mate_common[" + 
			"mate_name=" + mate_name + 
			", mate_code=" + mate_code + 
			", code_cn_desc=" + code_cn_desc + 
			", code_en_desc=" + code_en_desc + 
			", mate_sort=" + mate_sort + 
			"]";
	}
	@Override
	public String getPrimaryKey() {
		return "id";
	}
}

