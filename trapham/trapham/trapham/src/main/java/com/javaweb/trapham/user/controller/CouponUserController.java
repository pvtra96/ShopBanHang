package com.javaweb.trapham.user.controller;

import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaweb.trapham.model.CouponDTO;
import com.javaweb.trapham.service.CouponService;

@Controller
public class CouponUserController {
	
	@Autowired
	private CouponService couponService;
	
	@PostMapping("/coupon")
	public String PostCoupon(HttpSession httpSession,@RequestParam(name="name", required = true) String string) throws ParseException {
		CouponDTO couponDTO = couponService.searchCouponByName(string);
		
		if(couponDTO != null) {
			Date date = new Date();
			
			if(couponService.stringToDate(couponDTO.getExpired()).after(date)) {
				httpSession.setAttribute("coupon", couponDTO);
				
				return "redirect:/bill-product";
			}else {
				return "redirect:/bill-product?c=error";
			}	
		}else {
			return "redirect:/bill-product?c=error";
		}
	}
}
