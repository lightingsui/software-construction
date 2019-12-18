package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;

import com.util.db.DBUtil;

public class TestCount {
	public static void main(String[] args) {
		String unit_id = "001011";
		Connection conn = DBUtil.getConnection();
		String sql = "SELECT COUNT(user_name) FROM (SELECT * FROM t_base_user_info WHERE unit_id='"
				+ unit_id + "') user_info;";
		int count = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				count += rs.getInt(1);
			}
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
