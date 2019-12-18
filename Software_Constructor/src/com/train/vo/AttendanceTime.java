package com.train.vo;

import java.sql.Timestamp;

/**
 * ����ʱ��
 * 
 * @author yachao
 *
 */
public class AttendanceTime {
	private String id; // ����ʱ����
	private String title; // ����
	private Timestamp startTime; // ��ʼʱ��
	private Timestamp endTime; // ����ʱ��
	private String remark; // ��ע

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
