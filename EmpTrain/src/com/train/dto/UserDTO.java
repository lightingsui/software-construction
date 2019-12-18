package com.train.dto;

import java.sql.Date;

import com.util.tool.CommonUtil;

public class UserDTO {
	private String user_id = CommonUtil.getId();;
	private String user_name;
	private String sex;
	private String name;
	private String card_id;
	private String birthday;
	private String unit_id;
	private String password = "123456";
	private String telephone;
	private String duty;
	private String tecduty;
	private String user_comment;
	private int inuse;
	private String email;
	private String create_unit_id;
	private String mobile;
	private Date create_time;
	private Date last_login_time;
	private int rem_password = 0;
	private int auto_login = 0;

	public UserDTO() {
	}

	public UserDTO(String user_name, String password) {
		this.user_name = user_name;
		this.password = password;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
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

	public String getCard_id() {
		return card_id;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getUnit_id() {
		return unit_id;
	}

	public void setUnit_id(String unit_id) {
		this.unit_id = unit_id;
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

	public String getUser_comment() {
		return user_comment;
	}

	public void setUser_comment(String user_comment) {
		this.user_comment = user_comment;
	}

	public int getInuse() {
		return inuse;
	}

	public void setInuse(int inuse) {
		this.inuse = inuse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreate_unit_id() {
		return create_unit_id;
	}

	public void setCreate_unit_id(String create_unit_id) {
		this.create_unit_id = create_unit_id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getLast_login_time() {
		return last_login_time;
	}

	public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	}

	public int getRem_password() {
		return rem_password;
	}

	public void setRem_password(int rem_password) {
		this.rem_password = rem_password;
	}

	public int getAuto_login() {
		return auto_login;
	}

	public void setAuto_login(int auto_login) {
		this.auto_login = auto_login;
	}

	@Override
	public String toString() {
		return "UserDTO [user_id=" + user_id + ", user_name=" + user_name + "]";
	}

}
