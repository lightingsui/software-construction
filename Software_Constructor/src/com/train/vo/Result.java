package com.train.vo;

import java.sql.Timestamp;

/**
 * ��ѵ���
 * 
 * @author yachao
 *
 */
public class Result {
	private String id; // ��ѵ�ɼ����
	private double examResult; // ���Գɼ�
	private double attendanceResult; // ���ڳɼ�
	private double totalResult; // �ܳɼ�
	private Timestamp examTime; // ����ʱ��
	private Timestamp inputTime; // ¼��ʱ��
	private String remark; // ��ע
	private String remark1; // ��ע1
	private String remark2; // ��ע2

	public Result() {
	}

	public Result(double examResult, double attendanceResult,
			double totalResult, Timestamp examTime, Timestamp inputTime,
			String remark, String remark1, String remark2) {
		super();
		this.examResult = examResult;
		this.attendanceResult = attendanceResult;
		this.totalResult = totalResult;
		this.examTime = examTime;
		this.inputTime = inputTime;
		this.remark = remark;
		this.remark1 = remark1;
		this.remark2 = remark2;
	}

	public Result(String id, double examResult, double attendanceResult,
			double totalResult, Timestamp examTime, Timestamp inputTime,
			String remark, String remark1, String remark2) {
		super();
		this.id = id;
		this.examResult = examResult;
		this.attendanceResult = attendanceResult;
		this.totalResult = totalResult;
		this.examTime = examTime;
		this.inputTime = inputTime;
		this.remark = remark;
		this.remark1 = remark1;
		this.remark2 = remark2;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getExamResult() {
		return examResult;
	}

	public void setExamResult(double examResult) {
		this.examResult = examResult;
	}

	public double getAttendanceResult() {
		return attendanceResult;
	}

	public void setAttendanceResult(double attendanceResult) {
		this.attendanceResult = attendanceResult;
	}

	public double getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(double totalResult) {
		this.totalResult = totalResult;
	}

	public Timestamp getExamTime() {
		return examTime;
	}

	public void setExamTime(Timestamp examTime) {
		this.examTime = examTime;
	}

	public Timestamp getInputTime() {
		return inputTime;
	}

	public void setInputTime(Timestamp inputTime) {
		this.inputTime = inputTime;
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
		return "Result [id=" + id + ", examResult=" + examResult
				+ ", attendanceResult=" + attendanceResult + ", totalResult="
				+ totalResult + ", examTime=" + examTime + ", inputTime="
				+ inputTime + ", remark=" + remark + ", remark1=" + remark1
				+ ", remark2=" + remark2 + "]";
	}

}
