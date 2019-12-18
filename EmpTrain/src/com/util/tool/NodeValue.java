package com.util.tool;

import com.train.dto.DepartmentDTO;

public class NodeValue {
	private String name;
	private DepartmentDTO departDTO;

	public NodeValue() {
	}

	public NodeValue(String name, DepartmentDTO departDTO) {
		super();
		this.name = name;
		this.departDTO = departDTO;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DepartmentDTO getDepartDTO() {
		return departDTO;
	}

	public void setDepartDTO(DepartmentDTO departDTO) {
		this.departDTO = departDTO;
	}

	public String toString() {
		return this.name;
	}
}
