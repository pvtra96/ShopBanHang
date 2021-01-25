package com.javaweb.trapham.model;

public class BillProductDTO {
	private int id;
	private int quantity;
	private int price;
	private BillDTO bill;
	private ProductDTO product;
	
	public BillProductDTO() {
		super();
	}

	public BillProductDTO(int id, int quantity, int price, BillDTO bill, ProductDTO product) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.bill = bill;
		this.product = product;
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

	public BillDTO getBill() {
		return bill;
	}

	public void setBill(BillDTO bill) {
		this.bill = bill;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}
}
