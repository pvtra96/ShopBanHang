package com.javaweb.trapham.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.trapham.entity.Category;
import com.javaweb.trapham.model.CategoryDTO;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insert(Category category) throws SQLException {
		entityManager.persist(category);
	}

	@Override
	public void update(Category category) throws SQLException {
		entityManager.merge(category);
	}

	@Override
	public void delete(Category category) throws SQLException {
		entityManager.remove(category);
	}

	@Override
	public List<Category> searchAllCategory() {
		String jql = "SELECT c FROM Category c";
		
		List<Category> list = null;
		
		try {
			list = entityManager.createQuery(jql, Category.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}

	@Override
	public Category searchCategoryById(int id) {
		String jql = "SELECT c FROM Category c WHERE c.id = :id";
		
		Category category = null;
		
		try {
			category = entityManager.createQuery(jql, Category.class).setParameter("id",id).getSingleResult();	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return category;
	}

	@Override
	public long countCategory() {
		String jql = "SELECT COUNT(c.id) FROM Category c";
		
		Long long1 = 0l;
		
		try {
			long1 = entityManager.createQuery(jql, Long.class).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return long1;
	}
}
