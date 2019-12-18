package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import com.util.db.DBUtil;

public class TestStatement {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	public TestStatement() {

	}

	public void executeSql(String sql) throws SQLException {
		conn = DBUtil.getConnection();
		stmt = conn.createStatement();
		boolean hasResultSet = stmt.execute(sql);
		if (hasResultSet) {
			rs = stmt.getResultSet();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while (rs.next()) {
				for (int i = 0; i < columnCount; i++) {
					System.out.print(rs.getString(i + 1) + "\t");
				}
				System.out.println();
			}
			DBUtil.close(conn, stmt, rs);
		} else {
			System.out.println("该SQL语句影响的记录有：" + stmt.getUpdateCount() + "条");
			DBUtil.close(conn, stmt);
		}
	}

	public static void main(String[] args) {
		TestStatement ts = new TestStatement();
		// String sql = "SELECT * FROM t_base_user_info";
		String name = "乔磊";
		String sex = "男";
		String password = "361849544";
		String sql = "INSERT INTO t_base_user_info(user_id, user_name, sex, name, password) VALUES"
				+ "('"
				+ UUID.randomUUID().toString()
				+ "', '"
				+ name
				+ "','"
				+ sex + "','" + name + "','" + password + "')";
		try {
			ts.executeSql(sql);
			System.out.println("->" + ts.stmt.getUpdateCount());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// for(int i = 0; i < 10; i++) {
		// System.out.println(UUID.randomUUID().toString());
		// }
	}
}
