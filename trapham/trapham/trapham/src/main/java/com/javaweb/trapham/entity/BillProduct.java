package com.javaweb.trapham.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "billproduct")
public class BillProduct implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="price")
	private int price;
	
	@Column(name="idbill")
	private Integer idBill;
	
	@Column(name="idproduct")
	private Integer idProduct;

	public BillProduct() {
		super();
	}

	public BillProduct(int id, int quantity, int price, Integer idBill, Integer idProduct) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.idBill = idBill;
		this.idProduct = idProduct;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getIdBill() {
		return idBill;
	}

	public void setIdbill(int idBill) {
		this.idBill = idBill;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
}
