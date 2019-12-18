package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.train.vo.User;

public interface UserDAO {
	public int add(User user) throws SQLException;
	
	public int delete(int id) throws SQLException;
	
	public int update(User user) throws SQLException;
	
	public User findById(int id) throws SQLException;
	
	public User findUser(String username, String password) throws SQLException;
	
	public List<User> find() throws SQLException;
	
}
