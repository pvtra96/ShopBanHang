package com.javaweb.trapham.dao;

import java.sql.SQLException;
import java.util.List;

import com.javaweb.trapham.entity.Category;

public interface CategoryDao {
	void insert(Category category) throws SQLException;
	
	void update(Category category) throws SQLException;
	
	void delete(Category category) throws SQLException;
	
	List<Category> searchAllCategory();
	
	Category searchCategoryById(int id); 
	
	long countCategory();
}
