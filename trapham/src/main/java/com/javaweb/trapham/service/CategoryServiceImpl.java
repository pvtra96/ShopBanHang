package com.javaweb.trapham.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.trapham.dao.CategoryDao;
import com.javaweb.trapham.entity.Category;
import com.javaweb.trapham.model.CategoryDTO;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public void insert(CategoryDTO categoryDTO) throws SQLException {
		Category category = new Category();
		
		category.setName(categoryDTO.getName());
		
		categoryDao.insert(category);
	}

	@Override
	public void update(CategoryDTO categoryDTO) throws SQLException {
		Category category = new Category();
		
		category.setId(categoryDTO.getId());
		category.setName(categoryDTO.getName());
		
		categoryDao.update(category);
	}

	@Override
	public void delete(int id) throws SQLException {
		Category category = categoryDao.searchCategoryById(id);

		categoryDao.delete(category);
	}

	@Override
	public List<CategoryDTO> searchAllCategory() {
		List<Category> listCategory = categoryDao.searchAllCategory();
		
		if(listCategory == null) {
			return null;
		}else {
			List<CategoryDTO> listCategoryDTO = new ArrayList<CategoryDTO>();
			
			for(Category category : listCategory) {
				CategoryDTO categoryDTO = new CategoryDTO();
				
				categoryDTO.setId(category.getId());
				categoryDTO.setName(category.getName());
				
				listCategoryDTO.add(categoryDTO);
			}
			
			return listCategoryDTO;
		}
	}

	@Override
	public CategoryDTO searchCategoryById(int id) {
		Category category = categoryDao.searchCategoryById(id);
		
		if(category == null) {
			return null;
		}else {
			CategoryDTO categoryDTO = new CategoryDTO();
			
			categoryDTO.setId(category.getId());
			categoryDTO.setName(category.getName());
			
			return categoryDTO;
		}
	}

	@Override
	public long countCategory() {
		return categoryDao.countCategory();
	}
}
