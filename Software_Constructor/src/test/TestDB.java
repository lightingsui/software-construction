package test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.train.base.ResultSetHandler;
import com.train.vo.User;
import com.util.db.JdbcTemplate;

public class TestDB {

	public TestDB() {
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
//		UserDAOImpl dao = new UserDAOImpl();
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT * FROM t_base_user_info";
		
		List<User> users = (List<User>)jdbcTemplate.query(sql, new ResultSetHandler() {
			
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				List<User> users = new ArrayList<User>();
				User user = null;
				if(rs.next()) {
					user = new User();
					user.setUsername(rs.getString("USER_NAME"));
					user.setPassword(rs.getString("PASSWORD"));
					users.add(user);
				}
				return users;
			}
		});
		
		for (User user : users) {
			System.out.println(user.getUsername() + "-" + user.getPassword());
		}
//		try {
//			dao.findUser("张亚超", "359099631");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
}
