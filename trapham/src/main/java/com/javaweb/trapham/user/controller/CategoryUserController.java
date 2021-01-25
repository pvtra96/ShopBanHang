package com.javaweb.trapham.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.javaweb.trapham.model.CategoryDTO;
import com.javaweb.trapham.model.ProductDTO;
import com.javaweb.trapham.service.CategoryService;
import com.javaweb.trapham.service.ProductService;

@Controller
public class CategoryUserController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/category")
	public String getCategory(HttpServletRequest request) {
		List<CategoryDTO> listCategory = categoryService.searchAllCategory();
		
		List<ProductDTO> listProduct = productService.searchProductAll();
		
		request.setAttribute("listCategory", listCategory);
		request.setAttribute("listProduct", listProduct);
		
		return "user/view-category";
	}
}
