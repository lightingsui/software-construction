package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.UserDAO;
import com.train.base.ResultSetHandler;
import com.train.vo.Unit;
import com.train.vo.User;
import com.util.db.JdbcTemplate;

public class UserDAOImpl implements UserDAO {
	private JdbcTemplate jdbcTemplate;

	public UserDAOImpl() {
		jdbcTemplate = new JdbcTemplate();
	}

	@Override
	public int add(User user) throws SQLException {
		String sql = "INSERT INTO t_base_user_info VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		int k = jdbcTemplate.update(sql, user.getId(), user.getUsername(),
				user.getSex(), user.getName(), user.getCardId(),
				user.getBirthday(), user.getUnit().getUnitId(),
				user.getPassword(), user.getTelephone(), user.getDuty(),
				user.getTecduty(), user.getUserComment(), user.getInUse(),
				user.getEmail(), user.getCreateUnitId(), user.getMobile(),
				user.getCreateTime(), user.getLastLoginTime());

		return k;
	}

	@Override
	public int delete(int id) throws SQLException {
		String sql = "DELETE FROM t_base_user_info WHERE USER_ID=?";
		int k = jdbcTemplate.update(sql, id);

		return k;
	}

	@Override
	public int update(User user) throws SQLException {
		String sql = "UPDATE t_base_user_info SET USER_ID=?, USER_NAME=?, SEX=?, NAME=?, CARD_ID=?, BIRTHDAY=?, UNIT_ID=?, PASSWORD=?, TELEPHONE WHERE USER_ID=?";
		jdbcTemplate.update(sql, user.getId(), user.getUsername(),
				user.getSex(), user.getName(), user.getCardId(),
				user.getBirthday(), user.getUnit().getUnitId(),
				user.getPassword(), user.getTelephone(), user.getDuty(),
				user.getTecduty(), user.getUserComment(), user.getInUse(),
				user.getEmail(), user.getCreateUnitId(), user.getMobile(),
				user.getCreateTime(), user.getLastLoginTime());
		return 0;
	}

	@Override
	public User findById(int id) throws SQLException {
		String sql = "SELECT * FROM t_base_user_info WHERE USER_ID=?";
		User user = (User) jdbcTemplate.query(sql, new ResultSetHandler() {

			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				User user = null;

				if (rs.next()) {
					user = new User();
					user.setId(rs.getString("USER_ID"));
					user.setUsername(rs.getString("USER_NAME"));
					user.setSex(rs.getString("SEX"));
					user.setName(rs.getString("NAME"));
					user.setCardId(rs.getString("CARD_ID"));
					user.setBirthday(rs.getDate("BIRTHDAY"));
					user.setUnit(new Unit(rs.getString("UNIT_ID")));
					user.setPassword(rs.getString("PASSWORD"));
					user.setTelephone(rs.getString("TELEPHONE"));
					user.setDuty(rs.getString("DUTY"));
					user.setTecduty(rs.getString("TECDUTY"));
					user.setUserComment(rs.getString("USER_COMMENT"));
					user.setInUse(rs.getInt("INUSE"));
					user.setEmail(rs.getString("EMAIL"));
					user.setCreateUnitId(rs.getString("CREATE_UNIT_ID"));
					user.setMobile(rs.getString("MOBILE"));
					user.setCreateTime(rs.getDate("CREATE_TIME"));
					user.setLastLoginTime(rs.getDate("LAST_LOGIN_TIME"));
				}

				return user;
			}
		}, id);

		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> find() throws SQLException {
		String sql = "SELECT * FROM t_base_user_info";

		List<User> users = (List<User>) jdbcTemplate.query(sql,
				new ResultSetHandler() {
					@Override
					public Object doHandler(ResultSet rs) throws SQLException {
						List<User> users = new ArrayList<User>();
						User user = null;

						if (rs.next()) {
							user = new User();
							user.setId(rs.getString("USER_ID"));
							user.setUsername(rs.getString("USER_NAME"));
							user.setSex(rs.getString("SEX"));
							user.setName(rs.getString("NAME"));
							user.setCardId(rs.getString("CARD_ID"));
							user.setBirthday(rs.getDate("BIRTHDAY"));
							user.setUnit(new Unit(rs.getString("UNIT_ID")));
							user.setPassword(rs.getString("PASSWORD"));
							user.setTelephone(rs.getString("TELEPHONE"));
							user.setDuty(rs.getString("DUTY"));
							user.setTecduty(rs.getString("TECDUTY"));
							user.setUserComment(rs.getString("USER_COMMENT"));
							user.setInUse(rs.getInt("INUSE"));
							user.setEmail(rs.getString("EMAIL"));
							user.setCreateUnitId(rs.getString("CREATE_UNIT_ID"));
							user.setMobile(rs.getString("MOBILE"));
							user.setCreateTime(rs.getDate("CREATE_TIME"));
							user.setLastLoginTime(rs.getDate("LAST_LOGIN_TIME"));
							users.add(user);
						}

						return users;
					}
				});

		return users;
	}

	@Override
	public User findUser(String username, String password) throws SQLException {
		String sql = "SELECT * FROM t_base_user_info WHERE USER_NAME=? AND PASSWORD=?";
		User user = (User) jdbcTemplate.query(sql, new ResultSetHandler() {

			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				User user = null;

				if (rs.next()) {
					user = new User();
					user.setId(rs.getString("USER_ID"));
					user.setUsername(rs.getString("USER_NAME"));
					user.setSex(rs.getString("SEX"));
					user.setName(rs.getString("NAME"));
					user.setCardId(rs.getString("CARD_ID"));
					user.setBirthday(rs.getDate("BIRTHDAY"));
					user.setUnit(new Unit(rs.getString("UNIT_ID")));
					user.setPassword(rs.getString("PASSWORD"));
					user.setTelephone(rs.getString("TELEPHONE"));
					user.setDuty(rs.getString("DUTY"));
					user.setTecduty(rs.getString("TECDUTY"));
					user.setUserComment(rs.getString("USER_COMMENT"));
					user.setInUse(rs.getInt("INUSE"));
					user.setEmail(rs.getString("EMAIL"));
					user.setCreateUnitId(rs.getString("CREATE_UNIT_ID"));
					user.setMobile(rs.getString("MOBILE"));
					user.setCreateTime(rs.getDate("CREATE_TIME"));
					user.setLastLoginTime(rs.getDate("LAST_LOGIN_TIME"));
				}
				return user;
			}
		}, username, password);

		return user;
	}

}
