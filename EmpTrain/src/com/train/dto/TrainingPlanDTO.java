package com.train.dto;

import java.sql.Date;
import java.sql.Timestamp;

import com.util.tool.CommonUtil;

/**
 * 操作对象TrainingPlan
 * 
 * @author Sui
 *
 */
public class TrainingPlanDTO {
	private String train_plan_id = CommonUtil.getId(); // 培训计划编号
	private String train_plan_name; // 培训计划名称
	private String train_plan_type; // 培训计划类型
	private String train_plan_year; // 培训计划年度
	private Date start_time; // 开始时间
	private Date end_time; // 结束时间
	private String is_finish = "未培训"; // 完成情况
	private Timestamp create_time; // 创建时间
	private String remark1; // 备注1
	private String remark2; // 备注2

	public TrainingPlanDTO() {
	}

	public TrainingPlanDTO(String train_plan_name, String train_plan_year,
			Date start_time, Date end_time) {
		this.train_plan_name = train_plan_name;
		this.train_plan_year = train_plan_year;
		this.start_time = start_time;
		this.end_time = end_time;
	}

	public String getTrain_plan_id() {
		return train_plan_id;
	}

	public void setTrain_plan_id(String train_plan_id) {
		this.train_plan_id = train_plan_id;
	}

	public String getTrain_plan_name() {
		return train_plan_name;
	}

	public void setTrain_plan_name(String train_plan_name) {
		this.train_plan_name = train_plan_name;
	}

	public String getTrain_plan_type() {
		return train_plan_type;
	}

	public void setTrain_plan_type(String train_plan_type) {
		this.train_plan_type = train_plan_type;
	}

	public String getTrain_plan_year() {
		return train_plan_year;
	}

	public void setTrain_plan_year(String train_plan_year) {
		this.train_plan_year = train_plan_year;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public String getIs_finish() {
		return is_finish;
	}

	public void setIs_finish(String is_finish) {
		this.is_finish = is_finish;
	}

	public Timestamp getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	@Override
	public String toString() {
		return "TrainingPlanDTO [train_plan_id=" + train_plan_id + "]";
	}
}
