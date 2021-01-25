package com.javaweb.trapham.admin.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaweb.trapham.model.CategoryDTO;
import com.javaweb.trapham.model.ProductDTO;
import com.javaweb.trapham.service.CategoryService;
import com.javaweb.trapham.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService; 
	
	@GetMapping("admin/list-product")
	public String getListProduct(HttpServletRequest request) {
		List<ProductDTO> list = productService.searchProductAll();
		
		request.setAttribute("list", list);
		
		return "admin/view-product";
	}
	
	@GetMapping("admin/add-product")
	public String getAddProduct(HttpServletRequest request,Model model) {
		model.addAttribute("product", new ProductDTO());
		
		List<CategoryDTO> list = categoryService.searchAllCategory();
		
		request.setAttribute("listCategory", list);
		
		return "admin/add-product";
	}
	
	@PostMapping("admin/add-product")
	public String postAddProduct(@ModelAttribute(name = "product") ProductDTO product ) {
		CategoryDTO category = categoryService.searchCategoryById(product.getCategory().getId());
		
		product.setCategory(category);
		
		product.setImg(product.getImgMultiPart().getOriginalFilename());
		
		MultipartFile file = product.getImgMultiPart();
		
		File dir = new File("C:\\Users\\trabk\\eclipse-workspace\\trapham\\src\\main\\resources\\static\\img\\category\\" + product.getCategory().getName() );
		
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		File newFile = new File("C:\\Users\\trabk\\eclipse-workspace\\trapham\\src\\main\\resources\\static\\img\\category\\" + product.getCategory().getName() + "\\" + file.getOriginalFilename());
		
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(newFile);
			
			fileOutputStream.write(file.getBytes());
			
			fileOutputStream.close();
			
			productService.insert(product);
			
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
		
		return "redirect:/admin/list-product";
	}
	
	@GetMapping("admin/delete-product")
	public String getDeleteProduct(@RequestParam(name = "id",required =  false) Integer id) {
		if(id == null) {
			return "redirect:/admin/list-product";
		}else {
			try {
				productService.delete(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "redirect:/admin/list-product";
		}	
	}
	
	@GetMapping("admin/update-product")
	public String getUpdateProduct(Model model,@RequestParam("id") int id) {
		ProductDTO product = productService.searchProductById(id);
		
		model.addAttribute("product", product);
		
		return "admin/update-product";
	}
	
	@PostMapping("admin/update-product")
	public String postUpdateProduct(@ModelAttribute(name = "product") ProductDTO product) {
		product.setCategory(productService.searchProductById(product.getId()).getCategory());
		
		MultipartFile file = product.getImgMultiPart();
		
		if(product.getImgMultiPart().getOriginalFilename().equals("")) {
			product.setImg((productService.searchProductById(product.getId()).getImg()));
		}else {
			product.setImg(product.getImgMultiPart().getOriginalFilename());
						
			File newFile = new File("C:\\Users\\trabk\\eclipse-workspace\\trapham\\src\\main\\resources\\static\\img\\category\\" + product.getCategory().getName() + "\\" + file.getOriginalFilename());
			
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
		}
		
		try {
			productService.update(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/admin/list-product";
	}
	
}
