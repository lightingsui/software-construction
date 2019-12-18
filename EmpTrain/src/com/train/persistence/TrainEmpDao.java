package com.train.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.train.dto.TrainEmpDTO;
import com.util.db.DBUtil;

public class TrainEmpDao {
	private Connection conn;

	public TrainEmpDao() {
		conn = DBUtil.getConnection();
	}

	public boolean saveTrainEmp(TrainEmpDTO trainEmpDTO) {
		boolean result = true;
		int insertRows = 0;
		QueryRunner qr = new QueryRunner();
		String sql = "INSERT INTO train_emp VALUES(?, ?, ?, ?, ?, ?);";

		Object[] params = new Object[6];
		params[0] = trainEmpDTO.getTrain_emp_id();
		params[1] = trainEmpDTO.getTrain_item_id();
		params[2] = trainEmpDTO.getTrain_plan_id();
		params[3] = trainEmpDTO.getEmp_id();
		params[4] = trainEmpDTO.getCreate_time();
		params[5] = trainEmpDTO.getRemark();

		try {
			insertRows = qr.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		result = (insertRows != 0) ? true : false;
		return result;
	}

	/* 统计培训计划安排人数 */
	public Integer countNumOfEmp(String train_item_id) {
		Integer countResult = 0;
		String sql = "SELECT COUNT(emp_id) FROM "
				+ "(SELECT * FROM train_emp WHERE train_item_id='"
				+ train_item_id + "') new_train_emp;";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				countResult += rs.getInt(1);
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
		return countResult;
	}

	/* 获取相应的培训计划安排的学员信息 */
	public List<TrainEmpDTO> getTrainEmp(String train_item_id) {
		List<TrainEmpDTO> allTrainEmp = null;
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM train_emp WHERE train_item_id=?;";

		try {
			allTrainEmp = qr.query(conn, sql, new BeanListHandler<TrainEmpDTO>(
					TrainEmpDTO.class), train_item_id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allTrainEmp;
	}

	public boolean deleteTrainEmp(String train_item_id, String emp_id) {
		boolean result = false;
		int deleteRows = 0;
		String sql = "DELETE FROM train_emp WHERE train_item_id=? AND emp_id=?;";
		QueryRunner qr = new QueryRunner();

		try {
			deleteRows = qr.update(conn, sql, train_item_id, emp_id);
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

	/* 获取相应培训计划的全部学员编号 */
	public List<String> getTrainEmpId(String train_item_id) {
		List<String> emp_id = new ArrayList<String>();
		List<TrainEmpDTO> allTrainEmpDTO = null;
		String sql = "SELECT * FROM train_emp WHERE train_item_id=?";
		QueryRunner qr = new QueryRunner();

		try {
			allTrainEmpDTO = qr.query(conn, sql,
					new BeanListHandler<TrainEmpDTO>(TrainEmpDTO.class),
					train_item_id);

			for (int i = 0; i < allTrainEmpDTO.size(); i++) {
				TrainEmpDTO train_emp_dto = allTrainEmpDTO.get(i);
				String str_emp_id = train_emp_dto.getEmp_id();
				emp_id.add(str_emp_id);
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

		return emp_id;
	}
}
