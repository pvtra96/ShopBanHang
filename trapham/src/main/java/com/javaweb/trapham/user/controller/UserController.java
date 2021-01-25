package com.javaweb.trapham.user.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaweb.trapham.model.PasswordGenerator;
import com.javaweb.trapham.model.UserDTO;
import com.javaweb.trapham.service.MailService;
import com.javaweb.trapham.service.MailServiceImpl;
import com.javaweb.trapham.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MailService mailService;
	
	@GetMapping({"/add-user"})
	public String getAddUser(Model model, HttpServletRequest request, @RequestParam(name = "e", required = false) String string) {
		if(request.isUserInRole("ADMIN") || request.isUserInRole("USER") ) {
			return "redirect:/";
		}else {
			if(string !=null) {
				request.setAttribute("e", string);
			}
			
			model.addAttribute("user", new UserDTO());
			
			return "user/add-user";
		}
	}
	
	@PostMapping({"/add-user"})
	public String postAddUser(@ModelAttribute(name="user") UserDTO userDTO) {
		userDTO.setRole("ROLE_USER");
		
		MultipartFile file = userDTO.getImgMulipart();
		
		if(file.getSize()>0) {
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
			
			return "redirect:/login";
	}
	
	@GetMapping({"/user/change-password"})
	public String getChangePassword(HttpServletRequest request,@RequestParam(name ="c", required = false) String string) {
		if(string != null) {
			request.setAttribute("c", string);
		}
		
		return "user/change-password";
	}
	
	@PostMapping({"/user/change-password"})
	public String postChangePassword(@RequestParam(name = "password", required = false) String password,@RequestParam(name = "newpassword") String newPassword) {
		if(password != null && newPassword != null) {
			UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			UserDTO userDTO = userService.searchUserByUserName(userDetails.getUsername());
			
			if(PasswordGenerator.checkHashStrings(password, userDTO.getPassword())) {
				userDTO.setPassword(newPassword);
				
				try {
					userService.update(userDTO);
					
					return "redirect:/user/change-password?c=ok";
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				return "redirect:/user/change-password?c=error";
			}
			
			
		}
		return "redirect:/user/change-password?c=error";
	}
	
//	@GetMapping({"/mail"})
//	public String getMail() {
//		
//		mailService.sendSimpleMessage("trabk307@gmail.com", "hi ban", "test");
//		
//		return "redirect:/";
//	}
	
}
