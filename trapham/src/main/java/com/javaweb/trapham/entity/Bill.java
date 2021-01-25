package com.javaweb.trapham.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class Bill implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "iduser")
	private int idUser;
	
	@Column(name = "buydate")
	private Date buyDate;
	
	@Column(name = "totalprice")
	private int totalPrice;
	
	@Column(name = "idcoupon")
	private Integer idCoupon;
	
	@Column(name = "discount")
	private Integer discount;

	public Bill() {
		super();
	}

	public Bill(int id, int idUser, Date buyDate, int totalPrice, Integer idCoupon, Integer discount) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.buyDate = buyDate;
		this.totalPrice = totalPrice;
		this.idCoupon = idCoupon;
		this.discount = discount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public Date getBuydate() {
		return buyDate;
	}

	public void setBuydate(Date buydate) {
		this.buyDate = buydate;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getIdCoupon() {
		return idCoupon;
	}

	public void setIdCoupon(Integer idCoupon) {
		this.idCoupon = idCoupon;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}	
	
}
