package com.javaweb.trapham.service;

import java.sql.SQLException;
import java.util.List;

import com.javaweb.trapham.model.ProductDTO;

public interface ProductService {
void insert(ProductDTO productDTO) throws SQLException;
	
	void update(ProductDTO productDTO) throws SQLException;
	
	void delete(int id) throws SQLException;
	
	ProductDTO searchProductById(int id);
	
	List<ProductDTO> searchProductByName(String string);
	
	List<ProductDTO> searchProductAll();
	
	void deleteImg(ProductDTO product);

	List<ProductDTO> searchProductByNameCategory(String string);
	
	long countProduct();
	
	List<ProductDTO> searchProductLastLimit4();
	
	List<ProductDTO> searchProductLastLimit4Next();
	
	List<ProductDTO> searchProductLastLimit3(String string);
	
	
	List<ProductDTO> searchProductLastLimit6();
	
	List<ProductDTO> searchBestSell5();
	
	List<ProductDTO> searchProductByIdPage(int id);
	
	List<Integer> pages(int pages);
	
	List<ProductDTO> searchProduct(String string);
}
