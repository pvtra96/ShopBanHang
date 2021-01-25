package com.javaweb.trapham.model;

import org.springframework.web.multipart.MultipartFile;

public class User {
	private int id;
	private String name;
	private String userName;
	private String password;
	private String role;
	private MultipartFile img;
	//constructor
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(int id, String name, String userName, String password, String role, MultipartFile img) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.img = img;
	}

	//set-get
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public MultipartFile getImg() {
		return img;
	}

	public void setImg(MultipartFile img) {
		this.img = img;
	}
}
