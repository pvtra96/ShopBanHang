package com.javaweb.trapham.service;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.trapham.dao.UserDao;
import com.javaweb.trapham.entity.User;
import com.javaweb.trapham.model.PasswordGenerator;
import com.javaweb.trapham.model.UserDTO;
import com.javaweb.trapham.model.UserPrincipal;

@Transactional
@Service
public class UserServiceImpl implements UserService, UserDetailsService{

	@Autowired
	private UserDao userDao;

	@Override
	public void insert(UserDTO userDTO) throws SQLException {
		User user = new User();
		
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setUserName(userDTO.getUserName());
		user.setPassword(PasswordGenerator.getHashString(userDTO.getPassword()));
		user.setRole(userDTO.getRole());
		user.setImg(userDTO.getImg());
		
		userDao.insert(user);
	}

	@Override
	public void update(UserDTO userDTO) throws SQLException {
		User user = new User();
		
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setUserName(userDTO.getUserName());
		user.setPassword(PasswordGenerator.getHashString(userDTO.getPassword()));
		user.setRole(userDTO.getRole());
		user.setImg(userDTO.getImg());
		
		userDao.update(user);
	}

	@Override
	public void delete(int id) {
		User user = userDao.searchUserById(id);
		
		userDao.delete(user);
	}

	@Override
	public UserDTO searchUserById(int id) {
		User user = userDao.searchUserById(id);
		
		if(user == null) {
			return null;
		}else {
			UserDTO userDTO = new UserDTO();
			
			userDTO.setId(user.getId());
			userDTO.setName(user.getName());
			userDTO.setUserName(user.getUserName());
			userDTO.setPassword(user.getPassword());
			userDTO.setRole(user.getRole());
			userDTO.setImg(user.getImg());
			
			return userDTO;
		}	
	}

	@Override
	public UserDTO searchUserByUserName(String string) {
		User user = userDao.searchUserByUserName(string);
		
		if(user != null) {
			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setName(user.getName());
			userDTO.setUserName(user.getUserName());
			userDTO.setPassword(user.getPassword());
			userDTO.setRole(user.getRole());
			userDTO.setImg(user.getImg());
			
			return userDTO;
		}else {
			return null;
		}
	}

	@Override
	public List<UserDTO> searchUserByName(String string) {
		List<User> listUser = userDao.searchUserByName(string);
		
		if(listUser == null) {
			return null;
		}else {
			List<UserDTO> listUserDTO = new ArrayList<UserDTO>();
			
			for(User user : listUser) {
				UserDTO userDTO = new UserDTO();
				
				userDTO.setId(user.getId());
				userDTO.setName(user.getName());
				userDTO.setUserName(user.getUserName());
				userDTO.setPassword(user.getPassword());
				userDTO.setRole(user.getRole());
				userDTO.setImg(user.getImg());
				
				listUserDTO.add(userDTO);
			}
		
			return listUserDTO;
		}
	}

	@Override
	public List<UserDTO> searchUserAll() {
		List<User> listUser = userDao.searchUserAll();
		
		if(listUser == null) {
			return null;
		}else {
			List<UserDTO> listUserDTO = new ArrayList<UserDTO>();
			
			for(User user : listUser) {
				UserDTO userDTO = new UserDTO();
				
				userDTO.setId(user.getId());
				userDTO.setName(user.getName());
				userDTO.setUserName(user.getUserName());
				userDTO.setPassword(user.getPassword());
				userDTO.setRole(user.getRole());
				userDTO.setImg(user.getImg());
				
				listUserDTO.add(userDTO);
			}
		
			return listUserDTO;
		}
	}

	@Override
	public List<UserDTO> searchUserMember() {
		List<User> listUser = userDao.searchUserMember();
		
		if(listUser == null) {
			return null;
		}else {
			List<UserDTO> listUserDTO = new ArrayList<UserDTO>();
			
			for(User user : listUser) {
				UserDTO userDTO = new UserDTO();
				
				userDTO.setId(user.getId());
				userDTO.setName(user.getName());
				userDTO.setUserName(user.getUserName());
				userDTO.setPassword(user.getPassword());
				userDTO.setRole(user.getRole());
				userDTO.setImg(user.getImg());
				
				listUserDTO.add(userDTO);
			}
		
			return listUserDTO;
		}
	}

	@Override
	public List<UserDTO> searchUserAdmin() {
		List<User> listUser = userDao.searchUserAdmin();
		
		if(listUser == null) {
			return null;
		}else {
			List<UserDTO> listUserDTO = new ArrayList<UserDTO>();
			
			for(User user : listUser) {
				UserDTO userDTO = new UserDTO();
				
				userDTO.setId(user.getId());
				userDTO.setName(user.getName());
				userDTO.setUserName(user.getUserName());
				userDTO.setPassword(user.getPassword());
				userDTO.setRole(user.getRole());
				userDTO.setImg(user.getImg());
				
				listUserDTO.add(userDTO);
			}
		
			return listUserDTO;
		}
	}

	@Override
	public void deleteImg(UserDTO userDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long countMemberUser() {
		return userDao.countMemberUser();
	}	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.searchUserByUserName(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Not User");
		}
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
			
		authorities.add(new SimpleGrantedAuthority(user.getRole()));
		
		UserPrincipal userPrincipal = new UserPrincipal(user.getUserName(), user.getPassword(), true, true, true, true, authorities);
		
		userPrincipal.setId(user.getId());
		userPrincipal.setUserName(user.getUserName());
		userPrincipal.setPassword(user.getPassword());
		userPrincipal.setName(user.getName());
		userPrincipal.setRole(user.getRole());
		userPrincipal.setImg(user.getImg());
		
		return userPrincipal;
	}
}
