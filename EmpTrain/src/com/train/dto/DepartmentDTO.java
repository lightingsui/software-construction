package com.train.dto;

import java.sql.Date;

import com.util.tool.CommonUtil;

public class DepartmentDTO {
	private String unit_id;
	private String up_unit_id;
	private String unit_class;
	private String unit_name;
	private String address = "太原";
	private String telephone = "66282823";
	private String contact_person = "吴浩";
	private String email;
	private String header;
	private Date create_date = CommonUtil.getCurrentDate();
	private String remark;

	public DepartmentDTO() {
	}

	public DepartmentDTO(String unit_id, String up_unit_id, String unit_name,
			String header, String remark) {
		super();
		this.unit_id = unit_id;
		this.up_unit_id = up_unit_id;
		this.unit_name = unit_name;
		this.header = header;
		this.remark = remark;
	}

	public DepartmentDTO(String unit_id, String up_unit_id, String unit_name,
			String address, String telephone, String contact_person,
			String email, String header, Date create_date, String remark) {
		super();
		this.unit_id = unit_id;
		this.up_unit_id = up_unit_id;
		this.unit_name = unit_name;
		this.address = address;
		this.telephone = telephone;
		this.contact_person = contact_person;
		this.email = email;
		this.header = header;
		this.create_date = create_date;
		this.remark = remark;
	}

	public String getUnit_id() {
		return unit_id;
	}

	public void setUnit_id(String unit_id) {
		this.unit_id = unit_id;
	}

	public String getUp_unit_id() {
		return up_unit_id;
	}

	public void setUp_unit_id(String up_unit_id) {
		this.up_unit_id = up_unit_id;
	}

	public String getUnit_class() {
		return unit_class;
	}

	public void setUnit_class(String unit_class) {
		this.unit_class = unit_class;
	}

	public String getUnit_name() {
		return unit_name;
	}

	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getContact_person() {
		return contact_person;
	}

	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "DepartmentDTO [unit_id=" + unit_id + ", up_unit_id="
				+ up_unit_id + ", unit_name=" + unit_name + ", telephone="
				+ telephone + ", header=" + header + ", remark=" + remark + "]";
	}

}
