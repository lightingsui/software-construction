package com.train.service;

import java.util.List;

import com.factory.dao.DaoFactory;
import com.train.dto.DepartmentDTO;

public class Department {

	public Department() {

	}

	public DepartmentDTO getUnit(String unit_name) {
		return DaoFactory.getDepartmentDAO().getUnit(unit_name);
	}

	public List<DepartmentDTO> getAllDepartment() {
		return DaoFactory.getDepartmentDAO().getAllDepartment();
	}

	public List<DepartmentDTO> getAllDepartment(String up_unit_id) {
		return DaoFactory.getDepartmentDAO().getAllDepartment(up_unit_id);
	}

	public DepartmentDTO getDepartmentById(String unit_id) {
		return DaoFactory.getDepartmentDAO().getDepartmentById(unit_id);
	}

	public String getDepartId(String up_unit_name, String unit_name) {
		String unit_id = null;

		unit_id = DaoFactory.getDepartmentDAO().getDepartId(up_unit_name,
				unit_name);
		return unit_id;
	}

	public String getDepartCompleteName(String unit_id) {
		return DaoFactory.getDepartmentDAO().getDepartCompleteName(unit_id);
	}

	public boolean saveDepart(DepartmentDTO depart) {
		boolean result = true;

		result = DaoFactory.getDepartmentDAO().saveDepart(depart);
		return result;
	}

	/* 获取子部门的最大编号 */
	public String getDepartMaxId(String up_unit_id) {
		return DaoFactory.getDepartmentDAO().getDepartMaxId(up_unit_id);
	}

	/* 删除部门信息 */
	public boolean deleteDepart(String unit_id) {
		return DaoFactory.getDepartmentDAO().deleteDepart(unit_id);
	}

	/* 修改部门信息 */
	public boolean updateDepart(DepartmentDTO departDTO) {
		return DaoFactory.getDepartmentDAO().updateDepart(departDTO);
	}

	/* 获取部门名称 */
	public List<String> getDepartName(List<String> unit_id) {
		return DaoFactory.getDepartmentDAO().getDepartName(unit_id);
	}

	/* 检测是否存在下级部门 */
	public boolean existedDownDepart(String up_unit_id) {
		return DaoFactory.getDepartmentDAO().existedDownDepart(up_unit_id);
	}
}
