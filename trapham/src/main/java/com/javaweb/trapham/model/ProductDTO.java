package com.javaweb.trapham.model;

import org.springframework.web.multipart.MultipartFile;

public class ProductDTO {
	private int id;
	private String name;
	private int quantity;
	private int price;
	private String img;
	private MultipartFile imgMultiPart;
	private CategoryDTO category;
	private String description;
	
	public ProductDTO() {
		super();
	}

	public ProductDTO(int id, String name, int quantity, int price, String img, MultipartFile imgMultiPart,
			CategoryDTO category, String description) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.img = img;
		this.imgMultiPart = imgMultiPart;
		this.category = category;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public MultipartFile getImgMultiPart() {
		return imgMultiPart;
	}

	public void setImgMultiPart(MultipartFile imgMultiPart) {
		this.imgMultiPart = imgMultiPart;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
