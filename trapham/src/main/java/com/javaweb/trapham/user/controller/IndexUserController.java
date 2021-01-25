package com.javaweb.trapham.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaweb.trapham.model.ProductDTO;
import com.javaweb.trapham.service.ProductService;

@Controller
public class IndexUserController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping({"/","/index","user/"})
	public String index(HttpServletRequest request) {
		List<ProductDTO> list = productService.searchProductLastLimit4();
		
		request.setAttribute("list", list);
		
		return "user/index";
	}
	
	@GetMapping("/login")
	public String getLogin(HttpServletRequest request, @RequestParam(name = "e", required = false) String string) {
		if (string != null) {
			request.setAttribute("e", string);
		}

		return "user/login";
	}
}
