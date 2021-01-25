package com.javaweb.trapham.model;

import org.springframework.web.multipart.MultipartFile;

public class UserDTO {
	private int id;
	private String name;
	private String userName;
	private String password;
	private String role;
	private String img;
	private MultipartFile imgMulipart;
	
	public UserDTO() {
		super();
	}

	public UserDTO(int id, String name, String userName, String password, String role, String img,
			MultipartFile imgMulipart) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.img = img;
		this.imgMulipart = imgMulipart;
	}

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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public MultipartFile getImgMulipart() {
		return imgMulipart;
	}

	public void setImgMulipart(MultipartFile imgMulipart) {
		this.imgMulipart = imgMulipart;
	}
	
	
}
