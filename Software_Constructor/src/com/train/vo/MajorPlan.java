package com.train.vo;

/**
 * train_plan_item±íµÄvo
 * 
 * @author yachao
 *
 */
public class MajorPlan {
	private static int item_id;
	private String train_item_id;
	private String majorId;
	private String majorName;
	private String trainingPurpose;
	private String trainingContent;
	private String classHours;
	private String teacher;

	public MajorPlan() {
		++item_id;
		train_item_id = item_id + "";
	}

	public MajorPlan(String majorId, String majorName, String trainingPurpose,
			String trainingContent, String classHours, String teacher) {
		super();
		this.majorId = majorId;
		this.majorName = majorName;
		this.trainingPurpose = trainingPurpose;
		this.trainingContent = trainingContent;
		this.classHours = classHours;
		this.teacher = teacher;
	}

	public String getMajorId() {
		return majorId;
	}

	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getTrainingPurpose() {
		return trainingPurpose;
	}

	public void setTrainingPurpose(String trainingPurpose) {
		this.trainingPurpose = trainingPurpose;
	}

	public String getTrainingContent() {
		return trainingContent;
	}

	public void setTrainingContent(String trainingContent) {
		this.trainingContent = trainingContent;
	}

	public String getClassHours() {
		return classHours;
	}

	public void setClassHours(String classHours) {
		this.classHours = classHours;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public void setTrain_item_id(String train_item_id) {
		this.train_item_id = train_item_id;
	}

	public String getTrain_item_id() {
		return train_item_id;
	}

	@Override
	public String toString() {
		return "MajorPlan [majorId=" + majorId + ", majorName=" + majorName
				+ ", trainingPurpose=" + trainingPurpose + ", trainingContent="
				+ trainingContent + ", classHours=" + classHours + ", teacher="
				+ teacher + "]";
	}

}
