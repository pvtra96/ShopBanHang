package com.javaweb.trapham.model;

import java.util.Date;

public class CouponDTO {
	private int id;
	private int discount;
	private String expired;
	private String name;
	
	public CouponDTO() {
		super();
	}

	public CouponDTO(int id, int discount, String expired, String name) {
		super();
		this.id = id;
		this.discount = discount;
		this.expired = expired;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getExpired() {
		return expired;
	}

	public void setExpired(String expired) {
		this.expired = expired;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
