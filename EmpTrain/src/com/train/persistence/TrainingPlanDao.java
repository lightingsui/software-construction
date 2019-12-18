package com.train.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.train.dto.TrainingPlanDTO;
import com.util.db.DBUtil;

public class TrainingPlanDao {
	private Connection conn;

	public TrainingPlanDao() {
		conn = DBUtil.getConnection();
	}

	public boolean saveTrainingPlan(TrainingPlanDTO planDTO) {
		boolean success = false;
		int insertRows = 0;
		QueryRunner qr = new QueryRunner();
		String sql = "INSERT INTO train_plan_info(train_plan_id, train_plan_name, train_plan_type, train_plan_year, start_time, end_time, is_finish)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
		Object[] params = new Object[7];
		params[0] = planDTO.getTrain_plan_id();
		params[1] = planDTO.getTrain_plan_name();
		params[2] = params[1];
		params[3] = planDTO.getTrain_plan_year();
		params[4] = planDTO.getStart_time();
		params[5] = planDTO.getEnd_time();
		params[6] = planDTO.getIs_finish();

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
		success = (insertRows == 1) ? true : false;
		return success;
	}

	public boolean deleteTrainingPlan(String train_plan_id) {
		boolean success = false;
		int deleteRows = 0;
		QueryRunner qr = new QueryRunner();
		String sql1 = "SET FOREIGN_KEY_CHECKS = 0;";
		String sql = "DELETE FROM train_plan_info WHERE train_plan_id=?;";
		String sql2 = "SET FOREIGN_KEY_CHECKS = 1;";

		try {
			qr.update(conn, sql1);
			deleteRows = qr.update(conn, sql, train_plan_id);
			qr.update(conn, sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		success = (deleteRows == 1) ? true : false;
		return success;
	}

	public boolean updateTrainingPlan(TrainingPlanDTO planDTO) {
		boolean success = false;
		int updateRows = 0;
		QueryRunner qr = new QueryRunner();
		String sql = "UPDATE train_plan_info SET train_plan_name=?, train_plan_type=?, train_plan_year=?, start_time=?, end_time=?, is_finish=? WHERE train_plan_id=?";

		Object[] params = new Object[7];
		params[0] = planDTO.getTrain_plan_name();
		params[1] = params[0];
		params[2] = planDTO.getTrain_plan_year();
		params[3] = planDTO.getStart_time();
		params[4] = planDTO.getEnd_time();
		params[5] = planDTO.getIs_finish();
		params[6] = planDTO.getTrain_plan_id();

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

		success = (updateRows == 1) ? true : false;
		return success;
	}

	public TrainingPlanDTO getTrainingPlan(TrainingPlanDTO planDTO) {
		QueryRunner qr = new QueryRunner();
		TrainingPlanDTO trainingPlanDTO = null;

		String sql = "SELECT * FROM train_plan_info WHERE train_plan_name=?"
				+ " AND train_plan_type=? AND train_plan_year=? AND start_time=?"
				+ " AND end_time=? AND is_finish=?;";

		try {
			trainingPlanDTO = qr.query(conn, sql,
					new BeanHandler<TrainingPlanDTO>(TrainingPlanDTO.class),
					planDTO.getTrain_plan_name(), planDTO.getTrain_plan_type(),
					planDTO.getTrain_plan_year(), planDTO.getStart_time(),
					planDTO.getEnd_time(), planDTO.getIs_finish());
		} catch (SQLException e) {
			// e.printStackTrace();
			return null;
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return trainingPlanDTO;
	}

	public TrainingPlanDTO getPlan(String train_plan_id) {
		QueryRunner qr = new QueryRunner();
		TrainingPlanDTO trainingPlanDTO = null;

		String sql = "SELECT * FROM train_plan_info WHERE train_plan_id=?;";

		try {
			trainingPlanDTO = qr.query(conn, sql,
					new BeanHandler<TrainingPlanDTO>(TrainingPlanDTO.class),
					train_plan_id);
		} catch (SQLException e) {
			// e.printStackTrace();
			return null;
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return trainingPlanDTO;
	}

	public List<TrainingPlanDTO> getAllTrianingPlan(Object... params) {
		QueryRunner qr = new QueryRunner();
		List<TrainingPlanDTO> allPlan = null;

		StringBuilder sql = new StringBuilder(
				"SELECT * FROM train_plan_info WHERE 1=1 ");

		if (params[0] != null && !"".equals(params[0])) {
			sql.append(" AND train_plan_year='" + (String) params[0] + "'");
		}
		if (params[1] != null && !"".equals(params[1])) {
			sql.append(" AND train_plan_type='" + (String) params[1] + "'");
		}
		if (params[2] != null && !"".equals(params[2])) {
			sql.append(" AND is_finish='" + (String) params[2] + "'");
		}
		sql.append(";");
		try {
			allPlan = qr
					.query(conn, sql.toString(),
							new BeanListHandler<TrainingPlanDTO>(
									TrainingPlanDTO.class));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allPlan;
	}
}
