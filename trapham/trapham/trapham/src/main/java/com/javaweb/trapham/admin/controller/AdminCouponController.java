package com.javaweb.trapham.admin.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaweb.trapham.model.CouponDTO;
import com.javaweb.trapham.service.CouponService;


@Controller
public class AdminCouponController {
	
	@Autowired
	private CouponService couponService;
	
	@GetMapping({"admin/add-coupon"})
	public String getAddCoupon(Model model) {
		model.addAttribute("coupon", new CouponDTO());
		
		return "admin/add-coupon";
	}
	
	@PostMapping({"admin/add-coupon"})
	public String postAddCoupon(@ModelAttribute(name="coupon") CouponDTO couponDTO) {
		try {
			couponDTO.getName().toUpperCase();
			
			couponService.insert(couponDTO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "admin/add-coupon";
	}
	
	@GetMapping({"admin/list-coupon"})
	public String getListCoupon(HttpServletRequest request) {
		List<CouponDTO> list = couponService.searchCouponAll();
		
		request.setAttribute("list", list);
		
		return "admin/view-coupon";
	}
	
	@GetMapping({"admin/update-coupon"})
	public String getUpadteCoupon(Model model, @RequestParam(name = "id", required = false) Integer id) {
		if(id == null) {
			return "redirect:/admin/list-coupon";
		}else {
			model.addAttribute("coupon", couponService.searchCouponById(id));
			
			return "admin/update-coupon";
		}
	}
	
	@PostMapping({"admin/update-coupon"})
	public String postUpadteCoupon(@ModelAttribute(name = "coupon") CouponDTO couponDTO) {
		try {
			couponService.update(couponDTO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/admin/list-coupon";
	}
}
