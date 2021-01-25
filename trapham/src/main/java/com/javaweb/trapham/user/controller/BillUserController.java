package com.javaweb.trapham.user.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaweb.trapham.entity.Bill;
import com.javaweb.trapham.model.BillDTO;
import com.javaweb.trapham.model.BillProductDTO;
import com.javaweb.trapham.model.CouponDTO;
import com.javaweb.trapham.model.ProductDTO;
import com.javaweb.trapham.model.UserDTO;
import com.javaweb.trapham.service.BillProductService;
import com.javaweb.trapham.service.BillService;
import com.javaweb.trapham.service.ProductService;
import com.javaweb.trapham.service.UserService;

@Controller
public class BillUserController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private BillService billService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BillProductService billProductService;
	
	@GetMapping({"/bill-product"})
	public String getBillProduct(HttpServletRequest request, HttpSession httpSession, @RequestParam(name ="b", required = false) String b, @RequestParam(name ="c", required = false) String c) {
		Map<Integer, BillProductDTO> map = (Map<Integer, BillProductDTO>) httpSession.getAttribute("cart");
		
		if(c != null) {
			request.setAttribute("c", c);
		}
		if(b != null) {
			request.setAttribute("b", b);
		}
		
		request.setAttribute("cart", map);
		
		CouponDTO couponDTO = (CouponDTO) httpSession.getAttribute("coupon");
		
		if(couponDTO != null) {
			request.setAttribute("coupon", couponDTO);
		}
		
		int total =  0;
		
		if(map != null) {
			for(Map.Entry<Integer, BillProductDTO> entry : map.entrySet()) {
				total += entry.getValue().getQuantity() * entry.getValue().getPrice();
			}
		}
		
		request.setAttribute("total", total);
		
		
		return "user/cart";
	}
	
	@PostMapping({"/add-to-cart"})
	public String addToCart(@RequestParam("id") int id,@RequestParam("quantityBill") int quantityBill, HttpSession httpSession, HttpServletRequest request) {
		ProductDTO productDTO = productService.searchProductById(id);
		
		if(quantityBill > productDTO.getQuantity()) {
			return "redirect:/detail-product?id=" + id + "&e=error" ;
		}else {
			Object object = httpSession.getAttribute("cart");
			
			if(object == null) {
				Map<Integer, BillProductDTO> map = new HashMap<Integer, BillProductDTO>();
				
				BillProductDTO billProductDTO = new BillProductDTO();
				
				billProductDTO.setProduct(productDTO);
				billProductDTO.setQuantity(quantityBill);
				billProductDTO.setPrice(productDTO.getPrice());
				
				map.put(productDTO.getId(), billProductDTO);
				
				httpSession.setAttribute("cart", map);
			}else {
				Map<Integer, BillProductDTO> map = (Map<Integer, BillProductDTO>) object;
				
				BillProductDTO billProductDTO = map.get(id);
				
				if(billProductDTO == null) {
					billProductDTO = new BillProductDTO();
					
					billProductDTO.setProduct(productDTO);
					billProductDTO.setQuantity(quantityBill);
					billProductDTO.setPrice(productDTO.getPrice());
					
					map.put(productDTO.getId(), billProductDTO);
				}else {
					billProductDTO.setQuantity(billProductDTO.getQuantity() + quantityBill);
					
					map.put(productDTO.getId(), billProductDTO);
				}
				
				httpSession.setAttribute("cart", map);
			}
			
			return "redirect:/bill-product";
		}
	}
	
	@GetMapping({"/user/list-bill"})
	public String getListBill(HttpServletRequest request) {
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		UserDTO userDTO = userService.searchUserByUserName(userDetails.getUsername());
		
		List<BillDTO> list = billService.searchBillByUser(userDTO.getId());
		
		request.setAttribute("list", list);
		
		return "user/list-bill";
	}
	
	@GetMapping({"/user/detail-bill"})
	public String getDetailBill(HttpServletRequest request,@RequestParam(name="id", required = false) Integer id) {
		if(id == null) {
			return "redirect:/user/list-bill";
		}else {
			UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			BillDTO billDTO = billService.searchBillById(id);
			
			if(!billDTO.getUser().getUserName().equals(userDetails.getUsername())) {
				return "redirect:/user/list-bill";
			}else {
				List<BillProductDTO> list = billProductService.searchBillProductByIdBill(id);
				
				request.setAttribute("list", list);
				
				return "user/detail-billproduct";
			}
		}
	}
	
	@GetMapping({"/user/bill"})
	public String getBill(HttpSession httpSession) {
		Map<Integer, BillProductDTO> map = (Map<Integer, BillProductDTO>) httpSession.getAttribute("cart");
		CouponDTO couponDTO = (CouponDTO) httpSession.getAttribute("coupon");
		
		if(map == null) {
			return "redirect:/list-product";
		}else {
			int D = 0;
			
			for(Map.Entry<Integer, BillProductDTO> entry : map.entrySet()) {
				BillProductDTO billProductDTO = entry.getValue();
				
				if(billProductDTO.getQuantity() > productService.searchProductById(billProductDTO.getProduct().getId()).getQuantity()) {
					D = 1;
					break;
				}
			}
			
			if(D != 0) {
				return "redirect:/bill-product?b=error";
			}else {

				UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				
				BillDTO billDTO = new BillDTO();
				
				billDTO.setUser(userService.searchUserByUserName(userDetails.getUsername()));
				
				int total =  0;
				
				for(Map.Entry<Integer, BillProductDTO> entry : map.entrySet()) {
					total += entry.getValue().getQuantity() * entry.getValue().getPrice();
				}
				
				billDTO.setTotalPrice(total);
				
				if(couponDTO != null) {
					billDTO.setCoupon(couponDTO);
					billDTO.setDiscount(couponDTO.getDiscount());	
				}
				
				try {
					billService.insert(billDTO);
					
					for(Map.Entry<Integer, BillProductDTO> entry : map.entrySet()) {
						BillProductDTO billProductDTO = entry.getValue();
						
						billProductDTO.setBill(billDTO);
						
						billProductService.insert(billProductDTO);
						
						ProductDTO productDTO = billProductDTO.getProduct();
						
						productDTO.setQuantity(productDTO.getQuantity() - billProductDTO.getQuantity());
						
						productService.update(productDTO);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				httpSession.removeAttribute("cart");
				httpSession.removeAttribute("coupon");
				
				return "redirect:/user/detail-bill?id=" + billDTO.getId();
			}
		}
	}
	
	@GetMapping({"/delete-cart-product"})
	public String getDeleteCartProduct(HttpSession httpSession,@RequestParam(name = "id", required = false) Integer id) {
		Map<Integer, BillProductDTO> map = (Map<Integer, BillProductDTO>) httpSession.getAttribute("cart");
		
		if(map != null) {
			if(id!= null) {
				map.remove(id);
			}
		}
		
		httpSession.setAttribute("cart", map);
		
		return "redirect:/bill-product";
	}
}
