package com.train.vo;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * 培训计划
 * 
 * @author yachao
 *
 */
public class TrainPlanItem {
	private String id; // 培训项目编号
	private String trainPlanId; // 培训计划编号
	private String zyDicId; // 专业字典编号
	private String zyName; // 专业名
	private String purpose; // 培训目的
	private String content; // 培训内容
	private String classCount; // 可是
	private String teacher; // 授课人
	private String resultSubmit; // 成绩是否提交
	private Timestamp createTime; // 创建时间
	private String place; // 培训地点
	private Date startDate; // 开始日期
	private Date endDate; // 结束日期
	private Time dayStartTime; // 日培训开始时间
	private Time dayEndTime; // 日培训结束时间
	private String remark; // 备注
	private String remark1; // 备注1

	public TrainPlanItem() {
	}

	public TrainPlanItem(String trainPlanId, String zyDicId, String zyName,
			String purpose, String content, String classCount, String teacher,
			String resultSubmit, Timestamp createTime, String place,
			Date startDate, Date endDate, Time dayStartTime, Time dayEndTime,
			String remark, String remark1) {
		super();
		this.trainPlanId = trainPlanId;
		this.zyDicId = zyDicId;
		this.zyName = zyName;
		this.purpose = purpose;
		this.content = content;
		this.classCount = classCount;
		this.teacher = teacher;
		this.resultSubmit = resultSubmit;
		this.createTime = createTime;
		this.place = place;
		this.startDate = startDate;
		this.endDate = endDate;
		this.dayStartTime = dayStartTime;
		this.dayEndTime = dayEndTime;
		this.remark = remark;
		this.remark1 = remark1;
	}

	public TrainPlanItem(String id, String trainPlanId, String zyDicId,
			String zyName, String purpose, String content, String classCount,
			String teacher, String resultSubmit, Timestamp createTime,
			String place, Date startDate, Date endDate, Time dayStartTime,
			Time dayEndTime, String remark, String remark1) {
		super();
		this.id = id;
		this.trainPlanId = trainPlanId;
		this.zyDicId = zyDicId;
		this.zyName = zyName;
		this.purpose = purpose;
		this.content = content;
		this.classCount = classCount;
		this.teacher = teacher;
		this.resultSubmit = resultSubmit;
		this.createTime = createTime;
		this.place = place;
		this.startDate = startDate;
		this.endDate = endDate;
		this.dayStartTime = dayStartTime;
		this.dayEndTime = dayEndTime;
		this.remark = remark;
		this.remark1 = remark1;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTrainplanId() {
		return trainPlanId;
	}

	public void setTrainplanId(String trainPlanId) {
		this.trainPlanId = trainPlanId;
	}

	public String getZydicId() {
		return zyDicId;
	}

	public void setZydicId(String zyDicId) {
		this.zyDicId = zyDicId;
	}

	public String getZyName() {
		return zyName;
	}

	public void setZyName(String zyName) {
		this.zyName = zyName;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getClassCount() {
		return classCount;
	}

	public void setClassCount(String classCount) {
		this.classCount = classCount;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getResultSubmit() {
		return resultSubmit;
	}

	public void setResultSubmit(String resultSubmit) {
		this.resultSubmit = resultSubmit;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Time getDayStartTime() {
		return dayStartTime;
	}

	public void setDayStartTime(Time dayStartTime) {
		this.dayStartTime = dayStartTime;
	}

	public Time getDayEndTime() {
		return dayEndTime;
	}

	public void setDayEndTime(Time dayEndTime) {
		this.dayEndTime = dayEndTime;
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
		return "trainPlanItem [id=" + id + ", trainPlanId=" + trainPlanId
				+ ", zyDicId=" + zyDicId + ", zyName=" + zyName + ", purpose="
				+ purpose + ", content=" + content + ", classCount="
				+ classCount + ", teacher=" + teacher + ", resultSubmit="
				+ resultSubmit + ", createTime=" + createTime + ", place="
				+ place + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", dayStartTime=" + dayStartTime + ", dayEndTime="
				+ dayEndTime + ", remark=" + remark + ", remark1=" + remark1
				+ "]";
	}

}
