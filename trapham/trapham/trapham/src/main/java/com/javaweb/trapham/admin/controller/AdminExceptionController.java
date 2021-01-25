package com.javaweb.trapham.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdminExceptionController {
	
	@ExceptionHandler(Exception.class)
	public String exception(Exception e, HttpServletRequest request) {
		if(request.isUserInRole("ADMIN") ) {
			e.printStackTrace();
			return "admin/exception";
		}else {
			e.printStackTrace();
			return "user/exception";
		}
		
		
	}
}
