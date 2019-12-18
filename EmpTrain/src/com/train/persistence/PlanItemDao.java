package com.train.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import com.train.dto.PlanItemDTO;
import com.util.db.DBUtil;
import com.util.tool.CommonUtil;

public class PlanItemDao {
	private Connection conn;

	public PlanItemDao() {
		conn = DBUtil.getConnection();
	}

	public boolean savePlanItem(PlanItemDTO planItemDTO) {
		boolean result = false;
		int insertRows = 0;
		QueryRunner qr = new QueryRunner();
		String sql = "INSERT INTO train_plan_item(train_item_id, train_plan_id, zy_dic_id, "
				+ "zy_name, train_purpose, train_content, class_count, teacher) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
		Object[] params = new Object[8];
		planItemDTO.setPlan_item_id(CommonUtil.getId());
		params[0] = planItemDTO.getPlan_item_id();
		params[1] = planItemDTO.getTrain_plan_id();
		params[2] = planItemDTO.getZy_dic_id();
		params[3] = planItemDTO.getZy_name();
		params[4] = planItemDTO.getTrain_purpose();
		params[5] = planItemDTO.getTrain_content();
		params[6] = planItemDTO.getClass_count();
		params[7] = planItemDTO.getTeacher();

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

		result = (insertRows == 1) ? true : false;
		return result;
	}

	public boolean deletePlanItem(String train_item_id) {
		QueryRunner qr = new QueryRunner();
		String sql = "DELETE FROM train_plan_item WHERE train_plan_id=?;";

		try {
			qr.update(conn, sql, train_item_id);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public boolean updatePlanItem(PlanItemDTO planItemDTO) {
		QueryRunner qr = new QueryRunner();
		String sql = "UPDATE train_plan_item SET zy_dic_id=?, zy_name=?, "
				+ "train_purpose=?, train_content=?, class_count=?, teacher=? "
				+ " WHERE train_plan_id=?;";
		Object[] params = new Object[7];
		params[0] = planItemDTO.getZy_dic_id();
		params[1] = planItemDTO.getZy_name();
		params[2] = planItemDTO.getTrain_purpose();
		params[3] = planItemDTO.getTrain_content();
		params[4] = planItemDTO.getClass_count();
		params[5] = planItemDTO.getTeacher();
		params[6] = planItemDTO.getTrain_plan_id();

		try {
			qr.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return true;
	}

	public PlanItemDTO getPlanItem(String train_plan_id, String zy_name) {
		Statement stmt = null;
		ResultSet rs = null;
		PlanItemDTO planItem = null;
		// QueryRunner qr = new QueryRunner();
		StringBuilder sql = new StringBuilder(
				"SELECT * FROM train_plan_item WHERE");

		sql.append(" train_plan_id='" + train_plan_id + "'");

		if (zy_name != null && !"".equals(zy_name)) {
			sql.append(" AND zy_name='" + zy_name + "'");
		}

		sql.append(";");
		// System.out.println("sql/>" + sql.toString());
		// System.out.println("sql执行前/>" + train_plan_id);
		try {
			// planItem = qr.query(conn, sql.toString(),
			// new BeanHandler<PlanItemDTO>(PlanItemDTO.class));
			// System.out.println("sql执行后/>" + planItem);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql.toString());
			if (rs.next()) {
				planItem = new PlanItemDTO();
				planItem.setPlan_item_id(rs.getString("train_item_id"));
				planItem.setTrain_plan_id(rs.getString("train_plan_id"));
				planItem.setZy_name(rs.getString("zy_name"));
				planItem.setTrain_purpose(rs.getString("train_purpose"));
				planItem.setTrain_content(rs.getString("train_content"));
				planItem.setClass_count(rs.getString("class_count"));
				planItem.setTeacher(rs.getString("teacher"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				DbUtils.close(rs);
				DbUtils.close(stmt);
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return planItem;
	}
}
