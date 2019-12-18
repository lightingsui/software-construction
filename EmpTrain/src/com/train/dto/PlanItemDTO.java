package com.train.dto;

import java.sql.Date;
import java.sql.Timestamp;

import com.util.tool.CommonUtil;

public class PlanItemDTO {
	private String plan_item_id = CommonUtil.getId();
	private String train_plan_id;
	private String zy_dic_id = CommonUtil.getId();
	private String zy_name;
	private String train_purpose;
	private String train_content;
	private String class_count;
	private String teacher;
	private String result_submit;
	private Timestamp create_time;
	private String train_plan;
	private Date start_date;
	private Date end_date;
	private Timestamp day_start_time;
	private Timestamp day_end_time;
	private String remark;

	public PlanItemDTO() {
	}

	public PlanItemDTO(String train_plan_id, String zy_name,
			String train_purpose, String train_content, String class_count,
			String teacher) {
		this.train_plan_id = train_plan_id;
		this.zy_name = zy_name;
		this.train_purpose = train_purpose;
		this.train_content = train_content;
		this.class_count = class_count;
		this.teacher = teacher;
	}

	public String getPlan_item_id() {
		return plan_item_id;
	}

	public void setPlan_item_id(String plan_item_id) {
		this.plan_item_id = plan_item_id;
	}

	public String getTrain_plan_id() {
		return train_plan_id;
	}

	public void setTrain_plan_id(String train_plan_id) {
		this.train_plan_id = train_plan_id;
	}

	public String getZy_dic_id() {
		return zy_dic_id;
	}

	public void setZy_dic_id(String zy_dic_id) {
		this.zy_dic_id = zy_dic_id;
	}

	public String getZy_name() {
		return zy_name;
	}

	public void setZy_name(String zy_name) {
		this.zy_name = zy_name;
	}

	public String getTrain_purpose() {
		return train_purpose;
	}

	public void setTrain_purpose(String train_purpose) {
		this.train_purpose = train_purpose;
	}

	public String getTrain_content() {
		return train_content;
	}

	public void setTrain_content(String train_content) {
		this.train_content = train_content;
	}

	public String getClass_count() {
		return class_count;
	}

	public void setClass_count(String class_count) {
		this.class_count = class_count;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getResult_submit() {
		return result_submit;
	}

	public void setResult_submit(String result_submit) {
		this.result_submit = result_submit;
	}

	public Timestamp getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	public String getTrain_plan() {
		return train_plan;
	}

	public void setTrain_plan(String train_plan) {
		this.train_plan = train_plan;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Timestamp getDay_start_time() {
		return day_start_time;
	}

	public void setDay_start_time(Timestamp day_start_time) {
		this.day_start_time = day_start_time;
	}

	public Timestamp getDay_end_time() {
		return day_end_time;
	}

	public void setDay_end_time(Timestamp day_end_time) {
		this.day_end_time = day_end_time;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "PlanItemDTO [plan_item_id=" + plan_item_id + ", train_plan_id="
				+ train_plan_id + "]";
	}
}
