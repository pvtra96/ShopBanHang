package com.javaweb.trapham.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.trapham.entity.Coupon;
import com.javaweb.trapham.model.CouponDTO;

public interface CouponService {
	void insert(CouponDTO couponDTO) throws SQLException, ParseException;
	
	void update(CouponDTO couponDTO) throws SQLException, ParseException;
	
	void delete(int id) throws SQLException;
	
	CouponDTO searchCouponById(int id);
	
	CouponDTO searchCouponByName(String name);
	
	String dateToString(Date date);
	
	Date stringToDate(String string) throws ParseException;
	
	List<CouponDTO> searchCouponAll();
}
