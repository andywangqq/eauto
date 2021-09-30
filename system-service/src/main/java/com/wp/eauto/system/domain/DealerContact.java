package com.wp.eauto.system.domain;



/**
 * table name:  dealer_contact
 * author name: Andy
 * create time: 2021-09-30 15:33:33
 */ 

public class DealerContact{
	private Long id;	//
	private String dealerContactId;	//
	private String dealerId;	//经销商id
	private String contactName;	//联系人名称
	private String phone;	//电话
	private String email;	//邮箱
	private String qq;	//


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDealerContactId() {
		return dealerContactId;
	}

	public void setDealerContactId(String dealerContactId) {
		this.dealerContactId = dealerContactId;
	}

	public String getDealerId() {
		return dealerId;
	}

	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

}