package com.train.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.train.dto.DepartmentDTO;
import com.util.db.DBUtil;

public class DepartmentDao {
	private Connection conn;

	public DepartmentDao() {
		conn = DBUtil.getConnection();
	}

	/* 根据部门名称获取部门号 */
	public DepartmentDTO getUnit(String unit_name) {
		DepartmentDTO unit = null;
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM t_base_unit_info WHERE unit_name=?";

		try {
			unit = qr.query(conn, sql, new BeanHandler<DepartmentDTO>(
					DepartmentDTO.class), unit_name);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return unit;
	}

	public List<DepartmentDTO> getAllDepartment() {
		List<DepartmentDTO> allDepartment = null;
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM t_base_unit_info ORDER BY unit_id";

		try {
			allDepartment = qr.query(conn, sql,
					new BeanListHandler<DepartmentDTO>(DepartmentDTO.class));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allDepartment;
	}

	public List<DepartmentDTO> getAllDepartment(String up_unit_id) {
		List<DepartmentDTO> allDepartment = null;
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM t_base_unit_info WHERE up_unit_id=? ORDER BY unit_id;";

		try {
			allDepartment = qr.query(conn, sql,
					new BeanListHandler<DepartmentDTO>(DepartmentDTO.class),
					up_unit_id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allDepartment;
	}

	public DepartmentDTO getDepartmentById(String unit_id) {
		DepartmentDTO departmentDTO = null;
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM t_base_unit_info WHERE unit_id=?";

		try {
			departmentDTO = qr.query(conn, sql, new BeanHandler<DepartmentDTO>(
					DepartmentDTO.class), unit_id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return departmentDTO;
	}

	public String getDepartId(String up_unit_name, String unit_name) {
		String unit_id = null;
		String sql1 = "SELECT * FROM t_base_unit_info WHERE unit_name=?";
		String sql2 = "SELECT * FROM t_base_unit_info WHERE unit_id=?";
		List<DepartmentDTO> allDepart = null;
		DepartmentDTO unit = null;
		QueryRunner qr = new QueryRunner();

		try {
			/* 首先根据部门名查询全部部门信息 */
			allDepart = qr.query(conn, sql1,
					new BeanListHandler<DepartmentDTO>(DepartmentDTO.class),
					unit_name);
			if (allDepart.size() > 1) {
				/* 如果存在多个部门信息，即需要继续判断上级部门是否是已知的上级部门 */
				for (DepartmentDTO depart : allDepart) {
					unit = qr.query(conn, sql2, new BeanHandler<DepartmentDTO>(
							DepartmentDTO.class), depart.getUp_unit_id());
					if (unit.getUnit_name().equals(up_unit_name)) {
						/* 如果上级部门等同，则为所求，获取值并跳出循环 */
						unit_id = depart.getUnit_id();
						break;
					}
				}
			} else {
				unit_id = ((DepartmentDTO) allDepart.get(0)).getUnit_id();
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

		return unit_id;
	}

	public String getDepartCompleteName(String unit_id) {
		DepartmentDTO unit = null, up_unit = null;
		StringBuilder builder = new StringBuilder();

		unit = new DepartmentDao().getDepartmentById(unit_id);
		/* 当上级部门不存在时，对抛出的异常不进行处理，保证程序的正常运行 */
		try {
			up_unit = new DepartmentDao().getDepartmentById(unit
					.getUp_unit_id());
			if (up_unit.getUnit_name() != null
					&& !up_unit.getUnit_name().equals("太原第二热电厂")) {
				builder.append(up_unit.getUnit_name() + "-");
			}
			builder.append(unit.getUnit_name());
		} catch (Exception ex) {
			// 此处不进行相应处理
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return builder.toString();
	}

	public boolean saveDepart(DepartmentDTO depart) {
		boolean result = true;
		int saveRows = 0;
		QueryRunner qr = new QueryRunner();
		String sql = "INSERT INTO t_base_unit_info(unit_id, up_unit_id, unit_name, contact_person, "
				+ "header, address, telephone, remark, create_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Object[] params = new Object[9];
		params[0] = depart.getUnit_id();
		params[1] = depart.getUp_unit_id();
		params[2] = depart.getUnit_name();
		params[3] = depart.getContact_person();
		params[4] = depart.getHeader();
		params[5] = depart.getAddress();
		params[6] = depart.getTelephone();
		params[7] = depart.getRemark();
		params[8] = depart.getCreate_date();

		try {
			saveRows = qr.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		result = (saveRows == 0) ? false : true;
		return result;
	}

	/* 获取子部门的最大编号 */
	public String getDepartMaxId(String up_unit_id) {
		String maxDepartId = "";
		DepartmentDTO departDTO = null;
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT MAX(unit_id) AS unit_id FROM (SELECT * FROM t_base_unit_info WHERE up_unit_id='"
				+ up_unit_id + "') unit GROUP BY up_unit_id ";

		try {
			departDTO = qr.query(conn, sql, new BeanHandler<DepartmentDTO>(
					DepartmentDTO.class));
		} catch (SQLException e) {
			return maxDepartId;
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		maxDepartId = (departDTO != null) ? departDTO.getUnit_id() : "";
		return maxDepartId;
	}

	/* 删除部门信息 */
	public boolean deleteDepart(String unit_id) {
		boolean result = true;
		int deleteRows = 0;
		QueryRunner qr = new QueryRunner();
		String sql = "DELETE FROM t_base_unit_info WHERE unit_id=?";

		try {
			deleteRows = qr.update(conn, sql, unit_id);
		} catch (SQLException e) {
			return false;
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

	/* 修改部门信息 */
	public boolean updateDepart(DepartmentDTO departDTO) {
		boolean result = true;
		int updateRows = 0;
		QueryRunner qr = new QueryRunner();
		String sql = "UPDATE t_base_unit_info SET unit_name=?, address=?, telephone=?, contact_person=?,"
				+ "email=?, header=?, create_date=?, remark=? WHERE unit_id=?";
		Object[] params = new Object[9];
		params[0] = departDTO.getUnit_name();
		params[1] = departDTO.getAddress();
		params[2] = departDTO.getTelephone();
		params[3] = departDTO.getContact_person();
		params[4] = departDTO.getEmail();
		params[5] = departDTO.getHeader();
		params[6] = departDTO.getCreate_date();
		params[7] = departDTO.getRemark();
		params[8] = departDTO.getUnit_id();

		try {
			updateRows = qr.update(conn, sql, params);
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

	public List<String> getDepartName(List<String> unit_id) {
		List<String> allDepartName = new ArrayList<String>();

		for (int i = 0; i < unit_id.size(); i++) {
			String temp_departName = new DepartmentDao()
					.getDepartCompleteName(unit_id.get(i));
			allDepartName.add(temp_departName);
		}
		return allDepartName;
	}

	/* 检测是否存在下级部门 */
	public boolean existedDownDepart(String up_unit_id) {
		boolean result = false;
		int down_departCount = 0;
		String sql = "SELECT COUNT(*) FROM t_base_unit_info WHERE up_unit_id=?;";
		QueryRunner qr = new QueryRunner();

		try {
			down_departCount = ((Long) qr.query(conn, sql,
					new ScalarHandler(1), up_unit_id)).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		result = (down_departCount == 0) ? false : true;
		return result;
	}
}