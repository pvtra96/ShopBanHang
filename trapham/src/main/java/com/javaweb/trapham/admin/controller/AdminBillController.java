package com.javaweb.trapham.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaweb.trapham.model.BillDTO;
import com.javaweb.trapham.model.BillProductDTO;
import com.javaweb.trapham.service.BillProductService;
import com.javaweb.trapham.service.BillService;

@Controller
public class AdminBillController {
	
	@Autowired
	private BillService billService;
	
	@Autowired
	private BillProductService billProductService;
	
	@GetMapping({"admin/list-bill"})
	public String getListBill(HttpServletRequest request) {
		List<BillDTO> list = billService.searchAllBill();
		
		request.setAttribute("list", list);
		
		return "admin/view-bill";
	}
	
	@GetMapping({"admin/detail-bill"})
	public String getDetailBill(HttpServletRequest request,@RequestParam(name="id",required = false) Integer id) {
		if(id == null) {
			return "redirect:/admin/list-bill";
		}else {
			List<BillProductDTO> list = billProductService.searchBillProductByIdBill(id);
			
			if(list == null) {
				return "redirect:/admin/list-bill";
			}else {
				request.setAttribute("list", list);
				
				return "admin/detail-bill";
			}
		}
	}
}
