package com.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBUtil {
	private static ResourceBundle rb;
	private static String DB_DRIVER;
	private static String DB_URL;
	private static String DB_USERNAME;
	private static String DB_PASSWORD;

	static {
		rb = ResourceBundle.getBundle("com.util.db.db_config");
		DB_DRIVER = rb.getString("db_driver");
		DB_URL = rb.getString("db_url");
		DB_USERNAME = rb.getString("db_username");
		DB_PASSWORD = rb.getString("db_password");
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载失败！");
		}
	}

	public static Connection getConnection() {
		Connection conn = null;

		try {
			conn = DriverManager
					.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (SQLException e) {
			System.out.println("数据库连接失败！");
		}
		return conn;
	}

	public static void close(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null) {
				stmt.close();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
