package com.train.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.train.dto.UserDTO;
import com.util.db.DBUtil;

/**
 * 一致的抽象
 * 
 * @author Sui
 *
 */
public class UserDao {
	private Connection conn;

	public UserDao() {
		conn = DBUtil.getConnection();
	}

	public boolean findUser(String username, String password) {
		boolean result = false;
		QueryRunner qr = new QueryRunner();
		UserDTO userDTO = null;

		String sql = "SELECT user_id, user_name, password FROM t_base_user_info WHERE user_name=? AND password=?";
		Object[] params = new Object[2];
		params[0] = username;
		params[1] = password;

		try {
			userDTO = qr.query(conn, sql, new BeanHandler<UserDTO>(
					UserDTO.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (userDTO != null) {
			result = true;
			/* print the getting result */
			// System.out.println("UserDAO:findUser/>" + userDTO.getUser_name()
			// + "-" + userDTO.getPassword());
		}

		return result;
	}

	public UserDTO findUserByName(String username) {
		UserDTO userDTO = null;
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM t_base_user_info WHERE user_name=?";

		try {
			userDTO = qr.query(conn, sql, new BeanHandler<UserDTO>(
					UserDTO.class), username);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userDTO;
	}

	public List<UserDTO> getAllUser(UserDTO userDTO) {
		List<UserDTO> allUsers = null;
		QueryRunner qr = new QueryRunner();
		StringBuilder sql = new StringBuilder(
				"SELECT * FROM t_base_user_info WHERE 1=1 ");

		if (userDTO.getUser_name() != null
				&& !"".equals(userDTO.getUser_name())) {
			sql.append(" AND user_name='" + userDTO.getUser_name() + "'");
		}
		if (userDTO.getSex() != null && !"".equals(userDTO.getSex())) {
			sql.append(" AND sex='" + userDTO.getSex() + "'");
		}

		if (userDTO.getUnit_id() != null && !"".equals(userDTO.getUnit_id())) {
			sql.append(" AND unit_id='" + userDTO.getUnit_id() + "'");
		}
		sql.append(";");

		try {
			allUsers = qr.query(conn, sql.toString(),
					new BeanListHandler<UserDTO>(UserDTO.class));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allUsers;
	}

	public List<String> getAllNames() {
		List<String> allNames = new ArrayList<String>();
		List<UserDTO> allUser = null;
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT user_name FROM t_base_user_info";

		try {
			allUser = qr.query(conn, sql, new BeanListHandler<UserDTO>(
					UserDTO.class));

			for (int i = 0; i < allUser.size(); i++) {
				allNames.add(allUser.get(i).getUser_name());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return allNames;
	}

	public boolean saveUser(UserDTO userDTO) {
		boolean result = false;
		int insertRows = 0;
		QueryRunner qr = new QueryRunner();

		String sql = "INSERT INTO t_base_user_info(user_id, user_name, name, password) VALUES(?, ?, ?, ?)";
		String userId = userDTO.getUser_id();

		try {
			insertRows = qr.update(conn, sql, userId, userDTO.getUser_name(),
					userDTO.getUser_name(), userDTO.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		result = (insertRows == 1) ? true : false;
		return result;
	}

	public boolean saveEmployee(UserDTO employeeDTO) {
		boolean result = false;
		int insertRows = 0;
		QueryRunner qr = new QueryRunner();

		String sql = "INSERT INTO t_base_user_info"
				+ "(user_id, user_name, name, sex, birthday, card_id, unit_id, telephone, duty, tecduty, password) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			insertRows = qr.update(conn, sql, employeeDTO.getUser_id(),
					employeeDTO.getUser_name(), employeeDTO.getUser_name(),
					employeeDTO.getSex(), employeeDTO.getBirthday(),
					employeeDTO.getCard_id(), employeeDTO.getUnit_id(),
					employeeDTO.getTelephone(), employeeDTO.getDuty(),
					employeeDTO.getTecduty(), employeeDTO.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		result = (insertRows == 1) ? true : false;

		return result;
	}

	public boolean nameExisted(String username) {
		boolean existed = false;
		UserDTO userDTO = null;

		QueryRunner qr = new QueryRunner();
		String sql = "SELECT user_id, user_name, password FROM t_base_user_info WHERE user_name=?";
		try {
			userDTO = qr.query(conn, sql, new BeanHandler<UserDTO>(
					UserDTO.class), username);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		existed = (userDTO == null) ? false : true;
		return existed;
	}

	public UserDTO getEmployeeById(String employee_id) {
		UserDTO employee = null;
		String sql = "SELECT * FROM t_base_user_info WHERE user_id=?";
		QueryRunner qr = new QueryRunner();

		try {
			employee = qr.query(conn, sql, new BeanHandler<UserDTO>(
					UserDTO.class), employee_id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return employee;
	}

	public boolean deleteEmployee(String employee_id) {
		boolean result = true;
		int deleteRows = 0;
		String sql = "DELETE FROM t_base_user_info WHERE user_id=?";
		QueryRunner qr = new QueryRunner();

		try {
			deleteRows = qr.update(conn, sql, employee_id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		result = (deleteRows == 0) ? false : true;
		return result;
	}

	public boolean updateEmployee(UserDTO employee) {
		boolean result = false;
		int updateRows = 0;
		StringBuilder sql = new StringBuilder("UPDATE t_base_user_info ");
		QueryRunner qr = new QueryRunner();

		sql.append("SET user_name='" + employee.getUser_name() + "',");
		sql.append(" name='" + employee.getName() + "',");
		sql.append(" sex='" + employee.getSex() + "',");
		sql.append(" birthday='" + employee.getBirthday() + "',");
		sql.append(" card_id='" + employee.getCard_id() + "',");
		sql.append(" unit_id='" + employee.getUnit_id() + "',");
		sql.append(" telephone='" + employee.getTelephone() + "',");
		sql.append(" duty='" + employee.getDuty() + "',");
		sql.append(" tecduty='" + employee.getTecduty() + "',");
		sql.append(" password='" + employee.getPassword() + "'");
		sql.append(" WHERE user_id='" + employee.getUser_id() + "'");
		sql.append(";");

		try {
			updateRows = qr.update(conn, sql.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		result = (updateRows == 0) ? false : true;
		return result;
	}

	public List<UserDTO> findUnitEmp(String unit_id) {
		List<UserDTO> allUnitEmp = null;
		String sql = "SELECT * FROM t_base_user_info WHERE unit_id=?";
		QueryRunner qr = new QueryRunner();

		try {
			allUnitEmp = qr.query(conn, sql, new BeanListHandler<UserDTO>(
					UserDTO.class), unit_id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allUnitEmp;
	}

	public List<UserDTO> getEmpInfo(List<String> emp_id) {
		List<UserDTO> allEmp = new ArrayList<UserDTO>();

		for (int i = 0; i < emp_id.size(); i++) {
			String employee_id = emp_id.get(i);
			UserDTO empDTO = new UserDao().getEmployeeById(employee_id);
			allEmp.add(empDTO);
		}

		return allEmp;
	}

	public List<String> getDepartIdByEmpId(List<String> emp_id) {
		List<String> allDepartId = new ArrayList<String>();
		UserDTO emp_dto = null;

		for (int i = 0; i < emp_id.size(); i++) {
			emp_dto = new UserDao().getEmployeeById(emp_id.get(i));
			allDepartId.add(emp_dto.getUnit_id());
		}
		return allDepartId;
	}

	public boolean updateCookie(UserDTO userDTO) {
		boolean result = true;
		int updateRows = 0;
		String sql = "UPDATE t_base_user_info SET rem_password=?, auto_login=? WHERE user_id=?";
		QueryRunner qr = new QueryRunner();

		try {
			updateRows = qr.update(conn, sql, userDTO.getRem_password(),
					userDTO.getAuto_login(), userDTO.getUser_id());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		result = (updateRows == 0) ? false : true;
		return result;
	}
}