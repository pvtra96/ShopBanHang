package com.javaweb.trapham.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.trapham.entity.Coupon;

@Repository
@Transactional
public class CouponDaoImpl implements CouponDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insert(Coupon coupon) throws SQLException {
		entityManager.persist(coupon);
	}

	@Override
	public void update(Coupon coupon) throws SQLException {
		entityManager.merge(coupon);
	}

	@Override
	public void delete(int id) throws SQLException {
		entityManager.remove(id);
	}

	@Override
	public Coupon searchCouponById(int id) {
		String jql = "SELECT c FROM Coupon c WHERE c.id = :id";
		
		Coupon coupon = null;
		
		try {
			coupon = entityManager.createQuery(jql, Coupon.class).setParameter("id", id).getSingleResult();
		} catch (Exception e) {
		
		}
		
		return coupon;
	}

	@Override
	public Coupon searchCouponByName(String name) {
		String jql = "SELECT c FROM Coupon c WHERE c.name = :name";
		
		Coupon coupon = null;
		
		try {
			coupon = entityManager.createQuery(jql, Coupon.class).setParameter("name", name).getSingleResult();
		} catch (Exception e) {
		
		}
		
		return coupon;
	}
	@Override
	public List<Coupon> searchCouponAll(){
		String jql = "SELECT c FROM Coupon c";
		
		List<Coupon> list = null;
		
		try {
			list = entityManager.createQuery(jql, Coupon.class).getResultList();
		} catch (Exception e) {
		
		}
		
		return list;
	}
}
