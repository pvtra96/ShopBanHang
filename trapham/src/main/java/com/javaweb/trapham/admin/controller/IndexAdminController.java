package com.javaweb.trapham.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaweb.trapham.entity.Bill;
import com.javaweb.trapham.model.BillDTO;
import com.javaweb.trapham.service.BillService;
import com.javaweb.trapham.service.CategoryService;
import com.javaweb.trapham.service.ProductService;
import com.javaweb.trapham.service.UserService;

@Controller
public class IndexAdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private BillService billService;

	@GetMapping({ "member/" })
	public String index(HttpServletRequest request) {
		if (request.isUserInRole("ADMIN")) {
			return "redirect:/admin/";

		}
		return "redirect:/user/";
	}

	@GetMapping({ "admin/", "admin/index" })
	public String home(HttpServletRequest request) {
		long countMember = userService.countMemberUser();
		long countCategory = categoryService.countCategory();
		long countProduct = productService.countProduct();
		long countBill = billService.countBill();
		
		List<BillDTO> list = billService.newBill();

		request.setAttribute("countMember", countMember);
		request.setAttribute("countCategory", countCategory);
		request.setAttribute("countProduct", countProduct);
		request.setAttribute("countBill", countBill);
		request.setAttribute("list", list);
		

		return "admin/index";
	}
}
