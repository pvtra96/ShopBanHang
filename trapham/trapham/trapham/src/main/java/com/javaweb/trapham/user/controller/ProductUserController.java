package com.javaweb.trapham.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaweb.trapham.entity.Product;
import com.javaweb.trapham.model.ProductDTO;
import com.javaweb.trapham.service.ProductService;

@Controller
public class ProductUserController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping({"/list-product"})
	public String getListProduct(HttpServletRequest request,@RequestParam(name ="id", required = false) Integer id) {
		
		if(id == null || id<=0) {
			id = 1;
		}
		
		int count = (int) productService.countProduct();
		
		int page = count/9 + ((count % 9 == 0) ? 0 : 1);
		
		if(id>page) {
			id = page;
		}
		
		List<Integer> listPage = productService.pages(page);
		List<ProductDTO> list = productService.searchProductByIdPage(id);
		List<ProductDTO> listBest5 = productService.searchBestSell5();
		
		request.setAttribute("listPage", listPage);
		request.setAttribute("list", list);
		request.setAttribute("listBest5", listBest5);
		request.setAttribute("currentPage", id);

		return "user/view-product";
	}
	
	@GetMapping("/detail-product")
	public String getDetailProduct(HttpServletRequest request, @RequestParam(name = "id", required = false) Integer id, @RequestParam(name = "e", required = false) String e) {
		if(id == null) {
			return "redirect:/list-product";
		}else {
			ProductDTO productDTO = productService.searchProductById(id);
			
			if(productDTO == null) {
				return "redirect:/list-product";
			}else {
				List<ProductDTO> list = productService.searchProductLastLimit3(productDTO.getCategory().getName());
				
				if(e!= null) {
					request.setAttribute("e", e);
				}
				List<ProductDTO> listBest5 = productService.searchBestSell5();
				
				request.setAttribute("product", productDTO);
				request.setAttribute("listBest5", listBest5);
				request.setAttribute("list", list);
				
				return "user/detail-product";
			}
		}
	}
	
	
	
}
