package com.train.vo;

import java.sql.Timestamp;

/**
 * Ա����ѵ
 * 
 * @author yachao
 *
 */
public class TrainEmp {
	private String trainEmpId; // ��ѵԱ���
	private String empId; // ְԱ���
	private Timestamp createTime; // ����ʱ��
	private String remark; // ��ע

	public TrainEmp() {
	}

	public TrainEmp(String trainEmpId, String empId, Timestamp createTime,
			String remark) {
		super();
		this.trainEmpId = trainEmpId;
		this.empId = empId;
		this.createTime = createTime;
		this.remark = remark;
	}

	public String getTriainEmpId() {
		return trainEmpId;
	}

	public void setTriainEmpId(String trainEmpId) {
		this.trainEmpId = trainEmpId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "TrainEmp [trainEmpId=" + trainEmpId + ", empId=" + empId
				+ ", createTime=" + createTime + ", remark=" + remark + "]";
	}

}
