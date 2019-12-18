package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.DbUtils;

import com.util.db.DBUtil;

public class TestItem {

	public TestItem() {
	}

	public static void main(String[] args) {
		String train_plan_id = "1c1d87a5-8eef-42fe-9577-569a9a887dcc";
		String zy_name = "电气";

		String sql = "SELECT * FROM train_plan_item WHERE train_plan_id='"
				+ train_plan_id + "' AND zy_name='" + zy_name + "'";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("train_plan_id") + "---"
						+ rs.getString("train_item_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(rs);
				DbUtils.close(stmt);
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// QueryRunner qr = new QueryRunner();

		// try {
		// item = qr.query(conn, sql, new BeanHandler<PlanItemDTO>(
		// PlanItemDTO.class), train_plan_id, zy_name);
		// } catch (SQLException e) {
		// e.printStackTrace();
		// } finally {
		// try {
		// DbUtils.close(conn);
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		// }
	}
}
