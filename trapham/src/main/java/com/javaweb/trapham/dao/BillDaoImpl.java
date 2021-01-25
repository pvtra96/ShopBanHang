package com.javaweb.trapham.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.trapham.entity.Bill;
import com.javaweb.trapham.entity.Coupon;

@Repository
@Transactional
public class BillDaoImpl implements BillDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Bill insert(Bill bill) throws SQLException {
		entityManager.persist(bill);
		
		entityManager.flush();
		
		return bill;
	}

	@Override
	public void update(Bill bill) throws SQLException {
		entityManager.merge(bill);
	}

	@Override
	public void delete(int id) {
		entityManager.remove(id);
	}

	@Override
	public long countBill() {
		String jql = "SELECT COUNT(b.id) FROM Bill b";
		
		Long long1 = 0l;
		
		try {
			long1 = entityManager.createQuery(jql, Long.class).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return long1;
	}

	@Override
	public List<Bill> newBill() {
		String jql = "SELECT b FROM Bill b WHERE b.buyDate = (SELECT MAX(b.buyDate) FROM Bill b)";
		
		List<Bill> list = null;
		
		try {
			list = entityManager.createQuery(jql, Bill.class).getResultList();	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}

	@Override
	public List<Bill> searchAllBill() {
		String jql = "SELECT b FROM Bill b";
		
		List<Bill> list = null;
		
		try {
			list = entityManager.createQuery(jql, Bill.class).getResultList();	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}

	@Override
	public Bill searchBillById(int id) {
		String jql = "SELECT b FROM Bill b WHERE b.id = :id";
		
		Bill bill = null;
		
		try {
			bill = entityManager.createQuery(jql, Bill.class).setParameter("id", id).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return bill;
	}

	@Override
	public List<Bill> searchBillByUser(int id) {
		String jql = "SELECT b FROM Bill b WHERE b.idUser = :id";
		
		List<Bill> list = null;
		
		try {
			list = entityManager.createQuery(jql, Bill.class).setParameter("id", id).getResultList();	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}

}
