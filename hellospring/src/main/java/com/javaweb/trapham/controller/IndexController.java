package com.javaweb.trapham.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.javaweb.trapham.model.User;

@Controller
public class IndexController {
	
	private List<User> list = new ArrayList<User>();
	
	@Value("${my.key}")
	private String hello;
	
	@Autowired
	private Environment env;
	
	@Autowired
	MessageSource messageSource;
	
	@GetMapping({"/","/index"})
	public String index(HttpServletRequest request) {
		
//		System.out.println(hello);
//		System.out.println(env.getProperty("my.key"));
//		
//		System.out.println(messageSource.getMessage("my.name", null, null));
//		
//		request.setAttribute("msg", "Hello Spring Boot");
		
		return "index";
	}
	
	@GetMapping("/member")
	public String Member(Model model) {
		model.addAttribute("listUser", list);
	
		return "view_member";
	}
	
	@GetMapping("/add-user")
	public String AddUser(Model model) {
		model.addAttribute("user", new User());
		
		return "add_user";	
	}
	
	@PostMapping("/add-user")
	public String AddUser(@ModelAttribute(name="user") User user) {
		user.setId(list.size()+1);
		
		MultipartFile file = user.getImg();
		
		File newFile = new File("C:\\Users\\trabk\\eclipse-workspace\\hellospring\\hellospring\\src\\main\\resources\\static\\img\\" + file.getOriginalFilename());
		
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(newFile);
			
			fileOutputStream.write(file.getBytes());
			
			fileOutputStream.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		list.add(user);
		
		return "redirect:/member";
	}
	
	@GetMapping("/download-file")
	public void download(HttpServletRequest request, HttpServletResponse response) {
		String dir = "C:\\Users\\trabk\\eclipse-workspace\\hellospring\\hellospring\\src\\main\\resources\\static\\img\\";
		
		Path file = Paths.get(dir, "thinh96.jpg");
		
		if(Files.exists(file)) {
			response.setContentType("image/jpg");
			
			response.addHeader("Content-Disposition", "attachment; filename= anh.jpg");
			
			try {
				Files.copy(file, response.getOutputStream());
				
				response.getOutputStream().flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	
}
