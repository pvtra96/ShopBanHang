package com.javaweb.trapham.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.javaweb.trapham.entity.Bill;

public interface BillDao {
	Bill insert(Bill bill) throws SQLException;
	
	void update(Bill bill) throws SQLException;
	
	void delete(int id);
	
	long countBill();
	
	List<Bill> newBill();
	
	List<Bill> searchAllBill();
	
	Bill searchBillById(int id);
	
	List<Bill> searchBillByUser(int id);
}
