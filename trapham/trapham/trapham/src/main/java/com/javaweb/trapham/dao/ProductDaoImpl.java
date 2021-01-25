package com.javaweb.trapham.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.trapham.entity.Product;


@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insert(Product product) throws SQLException {
		entityManager.persist(product);
	}

	@Override
	public void update(Product product) throws SQLException {
		entityManager.merge(product);
	}

	@Override
	public void delete(Product product) throws SQLException {
		entityManager.remove(product);
	}

	@Override
	public Product searchProductById(int id) {
		String jql = "SELECT p FROM Product p WHERE p.id = :id";
		
		Product product = null;
		
		try {
			product = entityManager.createQuery(jql, Product.class).setParameter("id", id).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return product;
	}

	@Override
	public List<Product> searchProductByName(String string) {
		String jql = "SELECT p FROM Product p WHERE p.name = :string";
		
		List<Product> list = null;
		
		try {
			list = entityManager.createQuery(jql, Product.class).setParameter("string", string).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}

	@Override
	public List<Product> searchProductAll() {
		String jql = "SELECT p FROM Product p";
		
		List<Product> list = null;
		
		try {
			list = entityManager.createQuery(jql, Product.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}

	@Override
	public void deleteImg(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> searchProductByNameCategory(String string) {
		String jql = "SELECT p FROM Product p INNER JOIN Category c ON p.idCategory = c.id WHERE c.name = :string";
		
		List<Product> list = null;
		
		try {
			list = entityManager.createQuery(jql, Product.class).setParameter("string", string).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}

	@Override
	public long countProduct() {
		String jql = "SELECT COUNT(p.id) FROM Product p";
		
		Long long1 = 0l;
		
		try {
			long1 = entityManager.createQuery(jql, Long.class).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return long1;
	}

	@Override
	public List<Product> searchProductLastLimit4() {
		String jql = "SELECT p FROM Product p ORDER BY p.id DESC";
		
		List<Product> list = null;
		
		try {
			list = entityManager.createQuery(jql, Product.class).setMaxResults(4).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	
	@Override
	public List<Product> searchProductLastLimit3(String string) {
		String jql = "SELECT p FROM Product p INNER JOIN Category c ON p.idCategory = c.id WHERE c.name = :string ORDER BY RAND() ";

		List<Product> list = null;
		
		try {
			list = entityManager.createQuery(jql, Product.class).setParameter("string", string).setMaxResults(3).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	
	@Override
	public List<Product> searchProductLastLimit6() {
		String jql = "SELECT p FROM Product p ORDER BY p.id";
		
		List<Product> list = null;
		
		try {
			list = entityManager.createQuery(jql, Product.class).setMaxResults(6).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	
	@Override
	public List<Product> searchProductLastLimit4Next() {
		String jql = "SELECT p FROM Product p ORDER BY p.id DESC";
		
		List<Product> list = null;
		
		try {
			list = entityManager.createQuery(jql, Product.class).setFirstResult(4).setMaxResults(4).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}


	@Override
	public List<Product> searchBestSell5() {
		String jql = "SELECT p FROM Product p INNER JOIN BillProduct b ON p.id = b.idProduct GROUP BY p ORDER BY COUNT(b.id) DESC";
		
		List<Product> list = null;
		
		try {
			list = entityManager.createQuery(jql, Product.class).setMaxResults(5).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}

	@Override
	public List<Product> searchProductByIdPage(int id) {
		String jql = "SELECT p FROM Product p ORDER BY ID";
		
		List<Product> list = null;
		
		try {
			list = entityManager.createQuery(jql, Product.class).setFirstResult((id-1)*9).setMaxResults(9).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	
	@Override
	public List<Product> searchProduct(String string) {
		String jql = "SELECT p FROM Product p WHERE p.name LIKE :string";
		
		List<Product> list = null;
		
		try {
			list = entityManager.createQuery(jql, Product.class).setParameter("string", "%" + string + "%").getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
}
