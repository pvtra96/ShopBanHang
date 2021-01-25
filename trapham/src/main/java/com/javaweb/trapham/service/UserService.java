package com.javaweb.trapham.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.javaweb.trapham.model.UserDTO;

public interface UserService {
	void insert(UserDTO userDTO) throws SQLException;
	
	void update(UserDTO userDTO) throws SQLException;
	
	void delete(int id);
	
	UserDTO searchUserById(int id);
	
	UserDTO searchUserByUserName(String string);
	
	List<UserDTO> searchUserByName(String string);
	
	List<UserDTO> searchUserAll();
	
	List<UserDTO> searchUserMember();
	
	List<UserDTO> searchUserAdmin();
	
	void deleteImg(UserDTO userDTO);
	
	long countMemberUser();
}
