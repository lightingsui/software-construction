package com.train.vo;

/**
 * 部门角色表
 * 
 * @author yachao
 *
 */
public class Role {
	private String unitId;
	private String roleId;
	private String name;
	private String createTime;
	private String description;
	private int inUse;

	public Role() {
		super();
	}

	public Role(String unitId, String roleId, String name, String createTime,
			String description, int inUse) {
		super();
		this.unitId = unitId;
		this.roleId = roleId;
		this.name = name;
		this.createTime = createTime;
		this.description = description;
		this.inUse = inUse;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getInUse() {
		return inUse;
	}

	public void setInUse(int inUse) {
		this.inUse = inUse;
	}

	@Override
	public String toString() {
		return "Role [unitId=" + unitId + ", roleId=" + roleId + ", name="
				+ name + ", createTime=" + createTime + ", description="
				+ description + ", inUse=" + inUse + "]";
	}
}
