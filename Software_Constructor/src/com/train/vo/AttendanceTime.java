package com.train.vo;

import java.sql.Timestamp;

/**
 * 考勤时间
 * 
 * @author yachao
 *
 */
public class AttendanceTime {
	private String id; // 考勤时间编号
	private String title; // 标题
	private Timestamp startTime; // 开始时间
	private Timestamp endTime; // 结束时间
	private String remark; // 备注

	public AttendanceTime() {
	}

	public AttendanceTime(String title, Timestamp startTime, Timestamp endTime,
			String remark) {
		super();
		this.title = title;
		this.startTime = startTime;
		this.endTime = endTime;
		this.remark = remark;
	}

	public AttendanceTime(String id, String title, Timestamp startTime,
			Timestamp endTime, String remark) {
		super();
		this.id = id;
		this.title = title;
		this.startTime = startTime;
		this.endTime = endTime;
		this.remark = remark;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "AttendanceTime [id=" + id + ", title=" + title + ", startTime="
				+ startTime + ", endTime=" + endTime + ", remark=" + remark
				+ "]";
	}

}
