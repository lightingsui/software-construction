package com.train.service;

import java.util.Vector;

public enum Duty {
	FACTORY_MANAGER("厂长", "1"), HEAD("主任", "2"), TEAM_LEADER("班长", "3"), TEAM_EMP(
			"员工", "4");

	/* 成员变量 */
	private String duty;
	private String index;

	/* 构造方法 */
	private Duty(String duty, String index) {
		this.duty = duty;
		this.index = index;
	}

	/* common method */
	public static Vector<String> getDutyNames() {
		Vector<String> names = new Vector<String>();

		for (Duty d : Duty.values()) {
			names.add(d.duty);
		}
		return names;
	}

	public static String getDutyName(String index) {
		for (Duty d : Duty.values()) {
			if (d.index.equals(index)) {
				return d.duty;
			}
		}
		return null;
	}

	public static String getIndex(String duty) {
		for (Duty d : Duty.values()) {
			if (d.duty.equals(duty)) {
				return d.index;
			}
		}
		return null;
	}

	/* Getter and Setter method */
	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

}
