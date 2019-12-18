package com.train.vo;

import java.sql.Date;

/**
 * ������Ϣ
 * 
 * @author yachao
 *
 */
public class Unit {
	private String unitId; // ���ű��
	private String upUnitId; // �ϼ����ű��
	private String unitClass; // ��������
	private String unitName; // ��������
	private String address; // ��ַ
	private String telephone; // �绰
	private String contactPerson; // ��ϵ��
	private String email; // ��������
	private String header; // ���ż��
	private Date createDate; // ��������

	public Unit() {
	}

	public Unit(String unitId) {
		this.unitId = unitId;
	}

	public Unit(String unitId, String upUnitId, String unitClass,
			String unitName, String address, String telephone,
			String contactPerson, String email, String header, Date createDate) {
		super();
		this.unitId = unitId;
		this.upUnitId = upUnitId;
		this.unitClass = unitClass;
		this.unitName = unitName;
		this.address = address;
		this.telephone = telephone;
		this.contactPerson = contactPerson;
		this.email = email;
		this.header = header;
		this.createDate = createDate;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getUpUnitId() {
		return upUnitId;
	}

	public void setUpUnitId(String upUnitId) {
		this.upUnitId = upUnitId;
	}

	public String getUnitClass() {
		return unitClass;
	}

	public void setUnitClass(String unitClass) {
		this.unitClass = unitClass;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
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

	public String getContanctPerson() {
		return contactPerson;
	}

	public void setContanctPerson(String contactPerson) {
		this.contactPerson = contactPerson;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Unit [unitId=" + unitId + ", upUnitId=" + upUnitId
				+ ", unitClass=" + unitClass + ", unitName=" + unitName
				+ ", address=" + address + ", telephone=" + telephone
				+ ", contactPerson=" + contactPerson + ", email=" + email
				+ ", header=" + header + ", createDate=" + createDate + "]";
	}

}
