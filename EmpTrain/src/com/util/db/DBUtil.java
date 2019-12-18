package com.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBUtil {
	private static ResourceBundle rb;
	private static String DB_DRIVER;
	private static String DB_URL;
	private static String DB_USERNAME;
	private static String DB_PASSWORD;

	public static void initParam(String paramFile) throws Exception {
		rb = ResourceBundle.getBundle(paramFile);
		DB_DRIVER = rb.getString("db_driver");
		DB_URL = rb.getString("db_url");
		DB_USERNAME = rb.getString("db_username");
		DB_PASSWORD = rb.getString("db_password");
	}

	public static Connection getConnection() {
		Connection conn = null;

		try {
			initParam("com.util.db.db_config");
			Class.forName(DB_DRIVER);
			conn = DriverManager
					.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (Exception e) {
			System.out.println("数据库连接失败！");
		}
		return conn;
	}

	public static void executeSql(String sql) throws SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = null;

		boolean hasResultSet = stmt.execute(sql);
		if (hasResultSet) {
			rs = stmt.getResultSet();

			// ResultSetMetaData是用于分析结果集的元数据接口
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while (rs.next()) {
				for (int i = 0; i < columnCount; i++) {
					System.out.print(rs.getString(i + 1) + "\t");
				}
				System.out.println();
			}
			close(conn, stmt, rs);
		} else {
			System.out.println("该SQL语句影响的记录有" + stmt.getUpdateCount() + "条");
			close(conn, stmt);
		}
	}

	/* 关闭资源 */
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		close(conn, stmt);
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public static void close(Connection conn, Statement stmt) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
