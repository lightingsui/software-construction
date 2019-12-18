package com.train.vo;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * 员工出勤
 * 
 * @author yachao
 *
 */
public class Attendance {
	private String id; // 员工出勤编号
	private String empId; // 员工编号
	private Date recordDate; // 出勤日期
	private Timestamp classStartTime; // 上课时间
	private Timestamp classEndTime; // 下课时间
	private String attendanceResult; // 出勤结果
	private String remark; // 备注
	private String remark1; // 备注1

	public Attendance() {
	}

	public Attendance(String empId, Date recordDate, Timestamp classStartTime,
			Timestamp classEndTime, String attendanceResult, String remark,
			String remark1) {
		super();
		this.empId = empId;
		this.recordDate = recordDate;
		this.classStartTime = classStartTime;
		this.classEndTime = classEndTime;
		this.attendanceResult = attendanceResult;
		this.remark = remark;
		this.remark1 = remark1;
	}

	public Attendance(String id, String empId, Date recordDate,
			Timestamp classStartTime, Timestamp classEndTime,
			String attendanceResult, String remark, String remark1) {
		super();
		this.id = id;
		this.empId = empId;
		this.recordDate = recordDate;
		this.classStartTime = classStartTime;
		this.classEndTime = classEndTime;
		this.attendanceResult = attendanceResult;
		this.remark = remark;
		this.remark1 = remark1;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public Timestamp getClassStartTime() {
		return classStartTime;
	}

	public void setClassStartTime(Timestamp classStartTime) {
		this.classStartTime = classStartTime;
	}

	public Timestamp getClassEndTime() {
		return classEndTime;
	}

	public void setClassEndTime(Timestamp classEndTime) {
		this.classEndTime = classEndTime;
	}

	public String getAttendanceResult() {
		return attendanceResult;
	}

	public void setAttendanceResult(String attendanceResult) {
		this.attendanceResult = attendanceResult;
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

	@Override
	public String toString() {
		return "Attendance [id=" + id + ", empId=" + empId + ", recordDate="
				+ recordDate + ", classStartTime=" + classStartTime
				+ ", classEndTime=" + classEndTime + ", attendanceResult="
				+ attendanceResult + ", remark=" + remark + ", remark1="
				+ remark1 + "]";
	}

}
