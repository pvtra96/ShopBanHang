package com.javaweb.trapham.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.trapham.entity.BillProduct;
import com.javaweb.trapham.entity.Coupon;

@Repository
@Transactional
public class BillProductDaoImpl implements BillProductDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insert(BillProduct billProduct) throws SQLException {
		entityManager.persist(billProduct);
	}

	@Override
	public void update(BillProduct billProduct) throws SQLException {
		entityManager.merge(billProduct);
	}

	@Override
	public void delete(int id) throws SQLException {
		entityManager.remove(id);
	}

	@Override
	public List<BillProduct> searchBillProductByIdBill(int id) {
		String jql = "SELECT b FROM BillProduct b WHERE b.idBill = :id";
		
		List<BillProduct> list = null;
		
		try {
			list = entityManager.createQuery(jql, BillProduct.class).setParameter("id", id).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}

}
