package com.train.service;

import java.util.List;

import com.factory.dao.DaoFactory;
import com.train.dto.UserDTO;

public class User {
	private String user_name;
	private String password;

	public User() {
	}

	public User(String user_name, String password) {
		this.user_name = user_name;
		this.password = password;
	}

	public boolean findUser() {
		boolean result = false;

		result = DaoFactory.getUserDAO().findUser(user_name, password);
		return result;
	}

	public UserDTO findUserByName() {
		return DaoFactory.getUserDAO().findUserByName(user_name);
	}

	public boolean saveUser(UserDTO userDTO) {
		boolean success = false;

		success = DaoFactory.getUserDAO().saveUser(userDTO);
		return success;
	}

	public boolean saveEmployee(UserDTO employeeDTO) {
		boolean success = false;

		success = DaoFactory.getUserDAO().saveEmployee(employeeDTO);
		return success;
	}

	public boolean nameExisted(String user_name) {
		return (DaoFactory.getUserDAO().nameExisted(user_name));
	}

	public List<UserDTO> getAllUsers() {
		List<UserDTO> allUsers = null;

		allUsers = DaoFactory.getUserDAO().getAllUser(null);

		return allUsers;
	}

	public List<UserDTO> getAllUser(UserDTO userDTO) {
		List<UserDTO> allUser = null;
		allUser = DaoFactory.getUserDAO().getAllUser(userDTO);

		return allUser;
	}

	public List<String> getAllNames() {
		List<String> allNames = null;

		allNames = DaoFactory.getUserDAO().getAllNames();
		return allNames;
	}

	public UserDTO getEmployeeById(String employee_id) {
		UserDTO employee = null;

		employee = DaoFactory.getUserDAO().getEmployeeById(employee_id);
		return employee;
	}

	public boolean deleteEmployee(String employee_id) {
		return DaoFactory.getUserDAO().deleteEmployee(employee_id);
	}

	public boolean updateEmployee(UserDTO employee) {
		return DaoFactory.getUserDAO().updateEmployee(employee);
	}

	public List<UserDTO> findUnitEmp(String unit_id) {
		return DaoFactory.getUserDAO().findUnitEmp(unit_id);
	}

	public List<UserDTO> getEmpInfo(List<String> emp_id) {
		return DaoFactory.getUserDAO().getEmpInfo(emp_id);
	}

	public List<String> getDepartIdByEmpId(List<String> emp_id) {
		return DaoFactory.getUserDAO().getDepartIdByEmpId(emp_id);
	}

	public boolean updateCookie(UserDTO userDTO) {
		return DaoFactory.getUserDAO().updateCookie(userDTO);
	}
}
