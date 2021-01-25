package com.javaweb.trapham.dao;

import java.sql.SQLException;
import java.util.List;

import com.javaweb.trapham.entity.User;

public interface UserDao {
	void insert(User user) throws SQLException;
	
	void update(User user) throws SQLException;
	
	void delete(User user);
	
	User searchUserById(int id);
	
	User searchUserByUserName(String string);
	
	List<User> searchUserByName(String string);
	
	List<User> searchUserAll();
	
	List<User> searchUserMember();
	
	List<User> searchUserAdmin();
	
	void deleteImg(User user);
	
	long countMemberUser();
}
