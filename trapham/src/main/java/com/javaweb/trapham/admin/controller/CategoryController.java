package com.javaweb.trapham.admin.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.javaweb.trapham.model.CategoryDTO;
import com.javaweb.trapham.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("admin/list-category")
	public String getListCategory(HttpServletRequest request) {
		List<CategoryDTO> list = categoryService.searchAllCategory();
		
		request.setAttribute("list", list);
		
		return "/admin/view-category";
	}
	
	@GetMapping("admin/add-category")
	public String getAddCategory(Model model) {
		model.addAttribute("category", new CategoryDTO());
		
		return "/admin/add-category";
	}
	
	@PostMapping("admin/add-category")
	public String postAddCategory(@ModelAttribute(name = "category") CategoryDTO category) { 
		try {
			categoryService.insert(category);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/admin/list-category";
	}
	
//	@GetMapping("admin/update-category")
//	public String getUpdateCategory(Model model,@RequestParam("id") int id ) {
//		CategoryDTO category =  categoryService.searchCategoryById(id);
//		
//		model.addAttribute("category", category);
//		
//		return "admin/update-category";
//	}
//	
//	@PostMapping("admin/update-category")
//	public String postUpdateCategory(@ModelAttribute(name = "category") CategoryDTO category) {
//		try {
//			categoryService.update(category);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return "redirect:/admin/list-category";
//	}
//	
//	@GetMapping("admin/delete-category")
//	public String getDeleteCategory(@RequestParam("id") int id) {
//		try {
//			categoryService.delete(id);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return "redirect:/admin/list-category";
//	}
}
