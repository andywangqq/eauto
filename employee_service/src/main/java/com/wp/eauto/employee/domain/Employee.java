package com.wp.eauto.employee.domain;

import java.util.Date;
import java.math.BigDecimal;
/**
 * table name:  employee
 * author name: Andy
 * create time: 2021-09-27 22:32:06
 */ 
public class Employee extends EntityHelper{

	private long id;
	private String employee_id;
	/*雇员名称*/
	private String employee_name;
	/*性别*/
	private byte gender;
	/*电话*/
	private String phone;
	/*部门id*/
	private String department_id;
	/*津贴*/
	private BigDecimal allowance;
	/*基本工资*/
	private BigDecimal base_pay;
	private String qq;
	/*身份证*/
	private String id_card_no;
	/*邮箱*/
	private String email;
	/*状态*/
	private byte employee_status;
	/*入职日期*/
	private Date hiredate;
	/*经销商id*/
	private String dealer_id;
	/*是否已删除*/
	private byte is_deleted;
	/*创建时间*/
	private Date create_time;
	/*创建人*/
	private String create_user_id;
	/*修改时间*/
	private Date update_time;
	/*修改人*/
	private String update_user_id;

	public Employee() {
		super();
	}
	public Employee(long id,String employee_id,String employee_name,byte gender,String phone,String department_id,BigDecimal allowance,BigDecimal base_pay,String qq,String id_card_no,String email,byte employee_status,Date hiredate,String dealer_id,byte is_deleted,Date create_time,String create_user_id,Date update_time,String update_user_id) {
		this.id=id;
		this.employee_id=employee_id;
		this.employee_name=employee_name;
		this.gender=gender;
		this.phone=phone;
		this.department_id=department_id;
		this.allowance=allowance;
		this.base_pay=base_pay;
		this.qq=qq;
		this.id_card_no=id_card_no;
		this.email=email;
		this.employee_status=employee_status;
		this.hiredate=hiredate;
		this.dealer_id=dealer_id;
		this.is_deleted=is_deleted;
		this.create_time=create_time;
		this.create_user_id=create_user_id;
		this.update_time=update_time;
		this.update_user_id=update_user_id;
	}
	public void setId(long id){
		this.id=id;
	}
	public long getId(){
		return id;
	}
	public void setEmployee_id(String employee_id){
		this.employee_id=employee_id;
	}
	public String getEmployee_id(){
		return employee_id;
	}
	public void setEmployee_name(String employee_name){
		this.employee_name=employee_name;
	}
	public String getEmployee_name(){
		return employee_name;
	}
	public void setGender(byte gender){
		this.gender=gender;
	}
	public byte getGender(){
		return gender;
	}
	public void setPhone(String phone){
		this.phone=phone;
	}
	public String getPhone(){
		return phone;
	}
	public void setDepartment_id(String department_id){
		this.department_id=department_id;
	}
	public String getDepartment_id(){
		return department_id;
	}
	public void setAllowance(BigDecimal allowance){
		this.allowance=allowance;
	}
	public BigDecimal getAllowance(){
		return allowance;
	}
	public void setBase_pay(BigDecimal base_pay){
		this.base_pay=base_pay;
	}
	public BigDecimal getBase_pay(){
		return base_pay;
	}
	public void setQq(String qq){
		this.qq=qq;
	}
	public String getQq(){
		return qq;
	}
	public void setId_card_no(String id_card_no){
		this.id_card_no=id_card_no;
	}
	public String getId_card_no(){
		return id_card_no;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public String getEmail(){
		return email;
	}
	public void setEmployee_status(byte employee_status){
		this.employee_status=employee_status;
	}
	public byte getEmployee_status(){
		return employee_status;
	}
	public void setHiredate(Date hiredate){
		this.hiredate=hiredate;
	}
	public Date getHiredate(){
		return hiredate;
	}
	public void setDealer_id(String dealer_id){
		this.dealer_id=dealer_id;
	}
	public String getDealer_id(){
		return dealer_id;
	}
	public void setIs_deleted(byte is_deleted){
		this.is_deleted=is_deleted;
	}
	public byte getIs_deleted(){
		return is_deleted;
	}
	public void setCreate_time(Date create_time){
		this.create_time=create_time;
	}
	public Date getCreate_time(){
		return create_time;
	}
	public void setCreate_user_id(String create_user_id){
		this.create_user_id=create_user_id;
	}
	public String getCreate_user_id(){
		return create_user_id;
	}
	public void setUpdate_time(Date update_time){
		this.update_time=update_time;
	}
	public Date getUpdate_time(){
		return update_time;
	}
	public void setUpdate_user_id(String update_user_id){
		this.update_user_id=update_user_id;
	}
	public String getUpdate_user_id(){
		return update_user_id;
	}
	@Override
	public String toString() {
		return "employee[" + 
			"id=" + id + 
			", employee_id=" + employee_id + 
			", employee_name=" + employee_name + 
			", gender=" + gender + 
			", phone=" + phone + 
			", department_id=" + department_id + 
			", allowance=" + allowance + 
			", base_pay=" + base_pay + 
			", qq=" + qq + 
			", id_card_no=" + id_card_no + 
			", email=" + email + 
			", employee_status=" + employee_status + 
			", hiredate=" + hiredate + 
			", dealer_id=" + dealer_id + 
			", is_deleted=" + is_deleted + 
			", create_time=" + create_time + 
			", create_user_id=" + create_user_id + 
			", update_time=" + update_time + 
			", update_user_id=" + update_user_id + 
			"]";
	}
	@Override
	public String getPrimaryKey() {
		return "id";
	}
}

