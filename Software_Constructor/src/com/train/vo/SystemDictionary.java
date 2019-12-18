package com.train.vo;

/**
 * ϵͳ�ֵ�
 * 
 * @author yachao
 *
 */
public class SystemDictionary {
	private String optionId; // �ֵ�ѡ����
	private String optionName; // �ֵ�ѡ������
	private String upOptionId; // �ϼ��ֵ�ѡ����
	private int isUse; // �Ƿ�����
	private String description; // ����
	private int sortNo; // ����
	private int flag; // ��־
	private String englishName; // Ӣ����
	private String dataType; // ��������
	private String remark1; // ��ע1
	private String remark2; // ��ע2
	private String marchDicId; // ƥ���ֵ���

	public SystemDictionary() {
	}

	public SystemDictionary(String optionId, String optionName,
			String upOptionId, int isUse, String description, int sortNo,
			int flag, String englishName, String dataType, String remark1,
			String remark2, String marchDicId) {
		super();
		this.optionId = optionId;
		this.optionName = optionName;
		this.upOptionId = upOptionId;
		this.isUse = isUse;
		this.description = description;
		this.sortNo = sortNo;
		this.flag = flag;
		this.englishName = englishName;
		this.dataType = dataType;
		this.remark1 = remark1;
		this.remark2 = remark2;
		this.marchDicId = marchDicId;
	}

	public String getOptionId() {
		return optionId;
	}

	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public String getUpOptionId() {
		return upOptionId;
	}

	public void setUpOptionId(String upOptionId) {
		this.upOptionId = upOptionId;
	}

	public int getIsUse() {
		return isUse;
	}

	public void setIsUse(int isUse) {
		this.isUse = isUse;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSortNo() {
		return sortNo;
	}

	public void setSortNo(int sortNo) {
		this.sortNo = sortNo;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
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

	public String getMarchDicId() {
		return marchDicId;
	}

	public void setMarchDicId(String marchDicId) {
		this.marchDicId = marchDicId;
	}

	@Override
	public String toString() {
		return "SystemDictionary [optionId=" + optionId + ", optionName="
				+ optionName + ", upOptionId=" + upOptionId + ", isUse="
				+ isUse + ", description=" + description + ", sortNo=" + sortNo
				+ ", flag=" + flag + ", englishName=" + englishName
				+ ", dataType=" + dataType + ", remark1=" + remark1
				+ ", remark2=" + remark2 + ", marchDicId=" + marchDicId + "]";
	}

}
