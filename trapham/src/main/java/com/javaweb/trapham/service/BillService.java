package com.javaweb.trapham.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.javaweb.trapham.model.BillDTO;

public interface BillService {
	void insert(BillDTO billDTO) throws SQLException, ParseException ;
	
	void update(BillDTO billDTO) throws SQLException, ParseException ;
	
	void delete(int id);
	
	Long countBill();
	
	List<BillDTO> newBill();
	
	List<BillDTO> searchAllBill();
	
	BillDTO searchBillById(int id);
	
	List<BillDTO> searchBillByUser(int id);
	
	String dateToString(Date date);
	
	Date stringToDate(String string) throws ParseException;
}
