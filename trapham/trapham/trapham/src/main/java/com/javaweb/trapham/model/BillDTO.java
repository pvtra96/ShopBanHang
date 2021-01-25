package com.javaweb.trapham.model;

import java.util.Date;

public class BillDTO {
	private int id;
	private UserDTO user;
	private String buyDate;
	private int totalPrice;
	private CouponDTO coupon;
	private int discount;
	
	public BillDTO() {
		super();
	}

	public BillDTO(int id, UserDTO user, String buyDate, int totalPrice, CouponDTO coupon, int discount) {
		super();
		this.id = id;
		this.user = user;
		this.buyDate = buyDate;
		this.totalPrice = totalPrice;
		this.coupon = coupon;
		this.discount = discount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public String getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public CouponDTO getCoupon() {
		return coupon;
	}

	public void setCoupon(CouponDTO coupon) {
		this.coupon = coupon;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
}
