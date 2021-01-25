package com.javaweb.trapham.dao;

import java.sql.SQLException;
import java.util.List;

import com.javaweb.trapham.entity.BillProduct;

public interface BillProductDao {
	void insert(BillProduct billProduct) throws SQLException;
	
	void update(BillProduct billProduct) throws SQLException;
	
	void delete(int id) throws SQLException;
	
	List<BillProduct> searchBillProductByIdBill(int id);
}
