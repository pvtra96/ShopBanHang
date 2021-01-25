package com.javaweb.trapham.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.trapham.dao.CouponDao;
import com.javaweb.trapham.entity.Coupon;
import com.javaweb.trapham.model.CouponDTO;

@Service
@Transactional
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponDao couponDao;
	
	@Override
	public void insert(CouponDTO couponDTO) throws SQLException, ParseException {
		Coupon coupon = new Coupon();
		
		coupon.setDiscount(couponDTO.getDiscount());
		coupon.setExpired(stringToDate(couponDTO.getExpired()));
		coupon.setName(couponDTO.getName());
		
		couponDao.insert(coupon);
	}

	@Override
	public void update(CouponDTO couponDTO) throws SQLException, ParseException {
		Coupon coupon = new Coupon();
		
		coupon.setDiscount(couponDTO.getDiscount());
		coupon.setExpired(stringToDate(couponDTO.getExpired()));
		coupon.setName(couponDTO.getName());
		coupon.setId(couponDTO.getId());
		
		couponDao.update(coupon);
	}

	@Override
	public void delete(int id) throws SQLException {
		couponDao.delete(id);
	}

	@Override
	public CouponDTO searchCouponById(int id) {
		Coupon coupon = couponDao.searchCouponById(id);
		
		if(coupon == null) {
			return null;
		}else {
			CouponDTO couponDTO = new CouponDTO();
			
			couponDTO.setId(coupon.getId());
			couponDTO.setDiscount(coupon.getDiscount());
			couponDTO.setExpired(dateToString(coupon.getExpired()));
			couponDTO.setName(coupon.getName());
			
			return couponDTO;
		}
		
	}

	@Override
	public CouponDTO searchCouponByName(String name) {
		Coupon coupon = couponDao.searchCouponByName(name);
		
		if(coupon == null) {
			return null;
		}else {
			CouponDTO couponDTO = new CouponDTO();
			
			couponDTO.setId(coupon.getId());
			couponDTO.setDiscount(coupon.getDiscount());
			couponDTO.setExpired(dateToString(coupon.getExpired()));
			couponDTO.setName(coupon.getName());
			
			return couponDTO;
		}
	}

	@Override
	public String dateToString(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		return dateFormat.format(date);
	}

	@Override
	public Date stringToDate(String string) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		return dateFormat.parse(string);
	}

	@Override
	public List<CouponDTO> searchCouponAll() {
		List<Coupon> listCoupons = couponDao.searchCouponAll();
		
		List<CouponDTO> list = new ArrayList<CouponDTO>();
		
		if(listCoupons == null) {
			return null;
		}else {
			for(Coupon coupon : listCoupons) {
				CouponDTO couponDTO = new CouponDTO();
				
				couponDTO.setId(coupon.getId());
				couponDTO.setDiscount(coupon.getDiscount());
				couponDTO.setExpired(dateToString(coupon.getExpired()));
				couponDTO.setName(coupon.getName());
				
				list.add(couponDTO);
			}
			
			return list;
		}
	}
}
