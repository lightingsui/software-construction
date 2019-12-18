package com.train.dto;

import java.sql.Date;

import com.util.tool.CommonUtil;

public class TrainEmpDTO {
	private String train_emp_id = CommonUtil.getId();
	private String train_item_id;
	private String train_plan_id;
	private String emp_id;
	private Date create_time = CommonUtil.getCurrentDate();
	private String remark;

	public TrainEmpDTO() {
	}

	public TrainEmpDTO(String train_item_id, String train_plan_id,
			String emp_id) {
		super();
		this.train_item_id = train_item_id;
		this.train_plan_id = train_plan_id;
		this.emp_id = emp_id;
	}

	public String getTrain_emp_id() {
		return train_emp_id;
	}

	public void setTrain_emp_id(String train_emp_id) {
		this.train_emp_id = train_emp_id;
	}

	public String getTrain_item_id() {
		return train_item_id;
	}

	public void setTrain_item_id(String train_item_id) {
		this.train_item_id = train_item_id;
	}

	public String getTrain_plan_id() {
		return train_plan_id;
	}

	public void setTrain_plan_id(String train_plan_id) {
		this.train_plan_id = train_plan_id;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "TrainEmpDTO [train_emp_id=" + train_emp_id + ", train_item_id="
				+ train_item_id + ", train_plan_id=" + train_plan_id
				+ ", emp_id=" + emp_id + ", create_time=" + create_time
				+ ", remark=" + remark + "]";
	}

}
