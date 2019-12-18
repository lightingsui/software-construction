package com.train.vo;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * 培训计划信息
 * 
 * @author yachao
 *
 */
public class TrainPlan {
	private String id; // 培训计划编号
	private String name;// 培训计划名称
	private String type; // 培训类型
	private String year; // 培训计划年度
	private Date startTime; // 开始日期
	private Date endTime; // 结束日期
	private String finish; // 完成情况
	private Timestamp createTime; // 创建时间
	private String remark1; // 备注1
	private String remark2; // 备注2
	

	public TrainPlan() {

	}

	public TrainPlan(String name, String type, String year, Date startTime,
			Date endTime, String finish, Timestamp createTime, String remark1,
			String remark2) {
		super();
		this.name = name;
		this.type = type;
		this.year = year;
		this.startTime = startTime;
		this.endTime = endTime;
		this.finish = finish;
		this.createTime = createTime;
		this.remark1 = remark1;
		this.remark2 = remark2;
	}

	public TrainPlan(String id, String name, String type, String year,
			Date startTime, Date endTime, String finish, Timestamp createTime,
			String remark1, String remark2) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.year = year;
		this.startTime = startTime;
		this.endTime = endTime;
		this.finish = finish;
		this.createTime = createTime;
		this.remark1 = remark1;
		this.remark2 = remark2;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getFinish() {
		return finish;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
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
		return "TrainPlan [id=" + id + ", name=" + name + ", type=" + type
				+ ", year=" + year + ", startTime=" + startTime + ", endTime="
				+ endTime + ", finish=" + finish + ", createTime=" + createTime
				+ ", remark1=" + remark1 + ", remark2=" + remark2 + "]";
	}

}
