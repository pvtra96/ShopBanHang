package com.javaweb.trapham.service;

import java.sql.SQLException;
import java.util.List;

import com.javaweb.trapham.model.CategoryDTO;

public interface CategoryService {
	void insert(CategoryDTO categoryDTO) throws SQLException;
	
	void update(CategoryDTO categoryDTO) throws SQLException;
	
	void delete(int id) throws SQLException;
	
	List<CategoryDTO> searchAllCategory();
	
	CategoryDTO searchCategoryById(int id); 
	
	long countCategory();
	
}
