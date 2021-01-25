package com.javaweb.trapham.admin.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;


import com.javaweb.trapham.model.UserDTO;
import com.javaweb.trapham.service.UserService;

@Controller
public class AdminUserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("admin/list-user")
	public String getListUser(HttpServletRequest request) {
		
		List<UserDTO> list = userService.searchUserMember();
		
		request.setAttribute("list", list);

		return "/admin/view-user";
	}
	
	@GetMapping("admin/list-admin")
	public String getListAdmin(HttpServletRequest request) {
		
		List<UserDTO> list = userService.searchUserAdmin();
		
		request.setAttribute("list", list);
		
		return "/admin/view-admin";
	}
	
	@GetMapping("admin/add-user")
	public String getAddUser(Model model, HttpServletRequest request) {
		model.addAttribute("userDTO", new UserDTO());
			
		return "/admin/add-user";	
	}

	@PostMapping("admin/add-user")
	public String postAddUser(@ModelAttribute UserDTO userDTO) {
		
		MultipartFile file = userDTO.getImgMulipart();
		
		if(file != null) {
			userDTO.setImg(userDTO.getImgMulipart().getOriginalFilename());
			
			File dir = new File("C:\\Users\\trabk\\eclipse-workspace\\trapham\\src\\main\\resources\\static\\img\\user\\" + userDTO.getUserName() );
			
			if(!dir.exists()) {
				dir.mkdir();
			}
			
			File newFile = new File("C:\\Users\\trabk\\eclipse-workspace\\trapham\\src\\main\\resources\\static\\img\\user\\" 
					+ userDTO.getUserName() + "\\" + file.getOriginalFilename());
			
			try {
				FileOutputStream fileOutputStream = new FileOutputStream(newFile);
				
				fileOutputStream.write(file.getBytes());
				
				fileOutputStream.close();
				
				userService.insert(userDTO);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				File dir = new File("C:\\Users\\trabk\\eclipse-workspace\\trapham\\src\\main\\resources\\static\\img\\user\\" + userDTO.getUserName() );
				
				if(!dir.exists()) {
					dir.mkdir();
				}
				
				userService.insert(userDTO);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "redirect:/admin/list-user";
	}
}
