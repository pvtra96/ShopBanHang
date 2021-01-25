package com.javaweb.trapham.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.javaweb.trapham.entity.Coupon;

public interface CouponDao {
	void insert(Coupon coupon) throws SQLException;
	
	void update(Coupon coupon) throws SQLException;
	
	void delete(int id) throws SQLException;
	
	List<Coupon> searchCouponAll();
	
	Coupon searchCouponById(int id);
	
	Coupon searchCouponByName(String name);
}
