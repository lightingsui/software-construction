package com.train.vo;

import java.sql.Date;

/**
 * train_plan_info���vo
 * 
 * @author yachao
 *
 */
public class TrainingPlan {
	private static int max_id;
	private String id;// ��ѵ�ƻ����
	private String name;// ��ѵ�ƻ�����
	private String planYear;// ��ѵ�ƻ����
	private Date startDate; // ��ʼ����
	private Date endDate; // ��������
	private String finish = "��"; // �Ƿ����
	private MajorPlan majorPlan;

	public TrainingPlan() {
		++max_id;
		id = max_id + "";
	}

	public TrainingPlan(String id, String name, String planYear,
			Date startDate, Date endDate, String finish) {
		super();
		this.id = id;
		this.name = name;
		this.planYear = planYear;
		this.startDate = startDate;
		this.endDate = endDate;
		this.finish = finish;
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

	public String getPlanYear() {
		return planYear;
	}

	public void setPlanYear(String planYear) {
		this.planYear = planYear;
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

	public String getFinish() {
		return finish;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}

	public MajorPlan getMajorPlan() {
		return majorPlan;
	}

	public void setMajorPlan(MajorPlan majorPlan) {
		this.majorPlan = majorPlan;
	}

	@Override
	public String toString() {
		return "TrainingPlan [id=" + id + ", name=" + name + ", planYear="
				+ planYear + ", startDate=" + startDate + ", endDate="
				+ endDate + ", finish=" + finish + "]";
	}
}
