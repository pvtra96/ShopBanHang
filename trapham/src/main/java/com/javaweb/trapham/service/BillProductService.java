package com.javaweb.trapham.service;

import java.sql.SQLException;
import java.util.List;

import com.javaweb.trapham.model.BillProductDTO;

public interface BillProductService {
	void insert(BillProductDTO billProductDTO) throws SQLException;
	
	void update(BillProductDTO billProductDTO) throws SQLException;
	
	void delete(int id) throws SQLException;
	
	List<BillProductDTO> searchBillProductByIdBill(int id);
}
