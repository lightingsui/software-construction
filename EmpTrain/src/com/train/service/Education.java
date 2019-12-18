package com.train.service;

import java.util.Vector;

public enum Education {
	DOCTOR("博士", "1"), MASTER("硕士", "2"), UNDERGRADUATE("本科", "3"), JUNIOR(
			"专科", "4");

	/* 成员变量 */
	private String education; // 学历
	private String index;

	private Education(String education, String index) {
		this.education = education;
		this.index = index;
	}

	/* common method */
	public static Vector<String> getEducationNames() {
		Vector<String> names = new Vector<String>();

		for (Education e : Education.values()) {
			names.add(e.education);
		}
		return names;
	}

	public static String getEducationName(String index) {
		for (Education e : Education.values()) {
			if (e.index.equals(index)) {
				return e.education;
			}
		}
		return null;
	}

	public static String getIndex(String education) {
		for (Education e : Education.values()) {
			if (e.education.equals(education)) {
				return e.index;
			}
		}
		return null;
	}

	/* Getter and Setter method */
	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}
}
