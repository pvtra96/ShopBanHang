package com.javaweb.trapham.dao;

import java.sql.SQLException;
import java.util.List;

import com.javaweb.trapham.entity.Product;

public interface ProductDao {
	void insert(Product product) throws SQLException;
	
	void update(Product product) throws SQLException;
	
	void delete(Product product) throws SQLException;
	
	Product searchProductById(int id);
	
	List<Product> searchProductByName(String string);
	
	List<Product> searchProductAll();
	
	void deleteImg(Product product);

	List<Product> searchProductByNameCategory(String string);
	
	long countProduct();
	
	List<Product> searchProductLastLimit4();
	
	List<Product> searchProductLastLimit3(String string);
	
	List<Product> searchProductLastLimit6();
	
	List<Product> searchProductLastLimit4Next();
	
	List<Product> searchBestSell5();
	
	List<Product> searchProductByIdPage(int id);
	
	List<Product> searchProduct(String string);
}
