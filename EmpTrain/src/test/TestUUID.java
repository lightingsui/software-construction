package test;

import java.sql.Connection;
import java.util.UUID;

public class TestUUID {
	private String driver;
	private String url;
	private String user;
	private String password;
	private Connection conn;

	public static void main(String[] args) {
		String[] ids = new String[5];
		for (int i = 0; i < ids.length; i++) {
			ids[i] = UUID.randomUUID().toString();
			System.out.println(i + " : " + ids[i]);
		}

		// new TestUUID();
	}

	// public TestUUID() {
	// driver = "com.mysql.jdbc.Driver";
	// url = "jdbc:mysql://localhost:3306/user";
	// user = "root";
	// password = "3590";
	//
	// findById();
	// }
	//
	// public void findById() {
	// try {
	// Class.forName(driver);
	// conn = DriverManager.getConnection(url, user, password);
	// String sql = "SELECT * FROM userinfo WHERE id2=?";
	// QueryRunner qr = new QueryRunner();
	// UserInfo userInfo = qr.query(conn, sql, new BeanHandler<UserInfo>(
	// UserInfo.class), "09e38c4e-8185-4016-bc78-94ad7d1312c3");
	// System.out.println("09e38c4e-8185-4016-bc78-94ad7d1312c3");
	// System.out.println(userInfo);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
}
