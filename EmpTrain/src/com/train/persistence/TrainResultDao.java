package com.train.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.train.dto.TrainResultDTO;
import com.util.db.DBUtil;

public class TrainResultDao {
	private Connection conn;

	public TrainResultDao() {
		conn = DBUtil.getConnection();
	}

	public List<TrainResultDTO> getTrainResult(List<String> emp_id) {
		List<TrainResultDTO> allTrainResult = new ArrayList<TrainResultDTO>();
		TrainResultDTO resultDTO = null;
		String sql = "SELECT * FROM train_result WHERE train_emp_id=?";
		QueryRunner qr = new QueryRunner();

		try {
			for (int i = 0; i < emp_id.size(); i++) {
				resultDTO = qr.query(conn, sql,
						new BeanHandler<TrainResultDTO>(TrainResultDTO.class),
						emp_id.get(i));
				allTrainResult.add(resultDTO);
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

		return allTrainResult;
	}

	public boolean saveResult(TrainResultDTO resultDTO) {
		boolean result = true;
		int insertRows = 0;
		String sql = "INSERT INTO train_result VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		QueryRunner qr = new QueryRunner();

		Object[] params = new Object[10];
		params[0] = resultDTO.getTrain_result_id();
		params[1] = resultDTO.getTrain_emp_id();
		params[2] = resultDTO.getExam_result();
		params[3] = resultDTO.getAttendance_result();
		params[4] = resultDTO.getTotal_result();
		params[5] = resultDTO.getExam_time();
		params[6] = resultDTO.getInput_time();
		params[7] = resultDTO.getRemark();
		params[8] = resultDTO.getRemark1();
		params[9] = resultDTO.getRemark2();

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
		result = (insertRows == 0) ? false : true;
		return result;
	}

	public boolean updateResult(TrainResultDTO resultDTO) {
		boolean result = true;
		int updateRows = 0;
		String sql = "UPDATE train_result SET exam_result=?, attendance_result=?,"
				+ "total_result=?, exam_time=?, input_time=?, remark=?, remark1=?, remark2=? WHERE train_emp_id=?;";
		QueryRunner qr = new QueryRunner();

		Object[] params = new Object[9];
		params[0] = resultDTO.getExam_result();
		params[1] = resultDTO.getAttendance_result();
		params[2] = resultDTO.getTotal_result();
		params[3] = resultDTO.getExam_time();
		params[4] = resultDTO.getInput_time();
		params[5] = resultDTO.getRemark();
		params[6] = resultDTO.getRemark1();
		params[7] = resultDTO.getRemark2();
		params[8] = resultDTO.getTrain_emp_id();

		try {
			updateRows = qr.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		result = (updateRows == 0) ? false : true;
		return result;
	}
}
