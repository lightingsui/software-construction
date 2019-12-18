package com.train.dto;

import java.sql.Timestamp;

import com.util.tool.CommonUtil;

public class TrainResultDTO {
	private String train_result_id = CommonUtil.getId();
	private String train_emp_id;
	private float exam_result;
	private float attendance_result;
	private float total_result;
	private Timestamp exam_time = CommonUtil.getCurrenTime();
	private Timestamp input_time = CommonUtil.getCurrenTime();
	private String remark;
	private String remark1;
	private String remark2;

	public TrainResultDTO() {
	}

	public TrainResultDTO(String train_emp_id, float exam_result,
			float attendance_result, float total_result) {
		super();
		this.train_emp_id = train_emp_id;
		this.exam_result = exam_result;
		this.attendance_result = attendance_result;
		this.total_result = total_result;
	}

	public String getTrain_result_id() {
		return train_result_id;
	}

	public void setTrain_result_id(String train_result_id) {
		this.train_result_id = train_result_id;
	}

	public String getTrain_emp_id() {
		return train_emp_id;
	}

	public void setTrain_emp_id(String train_emp_id) {
		this.train_emp_id = train_emp_id;
	}

	public float getExam_result() {
		return exam_result;
	}

	public void setExam_result(float exam_result) {
		this.exam_result = exam_result;
	}

	public float getAttendance_result() {
		return attendance_result;
	}

	public void setAttendance_result(float attendance_result) {
		this.attendance_result = attendance_result;
	}

	public float getTotal_result() {
		return total_result;
	}

	public void setTotal_result(float total_result) {
		this.total_result = total_result;
	}

	public Timestamp getExam_time() {
		return exam_time;
	}

	public void setExam_time(Timestamp exam_time) {
		this.exam_time = exam_time;
	}

	public Timestamp getInput_time() {
		return input_time;
	}

	public void setInput_time(Timestamp input_time) {
		this.input_time = input_time;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
		return "TrainResult [train_result_id=" + train_result_id
				+ ", train_emp_id=" + train_emp_id + ", exam_result="
				+ exam_result + ", attendance_result=" + attendance_result
				+ ", total_result=" + total_result + ", exam_time=" + exam_time
				+ ", input_time=" + input_time + ", remark=" + remark
				+ ", remark1=" + remark1 + ", remark2=" + remark2 + "]";
	}

}
