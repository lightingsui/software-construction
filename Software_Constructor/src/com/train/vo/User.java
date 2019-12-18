package com.train.vo;

import java.sql.Date;
import java.util.UUID;

/**
 * 用户类
 * 
 * @author yachao
 *
 */
public class User {
	private String id; 
	private String username; 
	private String sex; 
	private String name; 
	private String cardId; 
	private Date birthday;
	private Unit unit; 
	private String password;
	private String telephone;
	private String duty; 
	private String tecduty; 
	private String userComment; 
	private int inUse; 
	private String email; 
	private String createUnitId; 
	private String mobile;
	private Date createTime; 
	private Date lastLoginTime; 

	public User() {
		id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getTecduty() {
		return tecduty;
	}

	public void setTecduty(String tecduty) {
		this.tecduty = tecduty;
	}

	public String getUserComment() {
		return userComment;
	}

	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}

	public int getInUse() {
		return inUse;
	}

	public void setInUse(int inUse) {
		this.inUse = inUse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreateUnitId() {
		return createUnitId;
	}

	public void setCreateUnitId(String createUnitId) {
		this.createUnitId = createUnitId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", sex=" + sex
				+ ", name=" + name + ", cardId=" + cardId + ", birthday="
				+ birthday + ", unit=" + unit + ", password=" + password
				+ ", telephone=" + telephone + ", duty=" + duty + ", tecduty="
				+ tecduty + ", userComment=" + userComment + ", inUse=" + inUse
				+ ", email=" + email + ", createUnitId=" + createUnitId
				+ ", mobile=" + mobile + ", createTime=" + createTime
				+ ", lastLoginTime=" + lastLoginTime + "]";
	}

}
