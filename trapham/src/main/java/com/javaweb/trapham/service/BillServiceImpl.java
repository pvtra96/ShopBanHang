package com.javaweb.trapham.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.trapham.dao.BillDao;
import com.javaweb.trapham.dao.UserDao;
import com.javaweb.trapham.entity.Bill;
import com.javaweb.trapham.model.BillDTO;

@Service
@Transactional
public class BillServiceImpl implements BillService {

	@Autowired
	private BillDao billDao;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CouponService couponService;
	
	@Override
	public void insert(BillDTO billDTO) throws SQLException, ParseException {
		Bill bill = new Bill();
		
		Date date = new Date();
		
		bill.setIdUser(billDTO.getUser().getId());
		bill.setBuydate(date);
		bill.setTotalPrice(billDTO.getTotalPrice());
		
		if(billDTO.getCoupon() != null) {
			bill.setIdCoupon(billDTO.getCoupon().getId());
			bill.setDiscount(billDTO.getDiscount());
		}
		
		bill =  billDao.insert(bill);
		
		billDTO.setId(bill.getId());
	}

	@Override
	public void update(BillDTO billDTO) throws SQLException, ParseException{
		Bill bill = new Bill();
		
		bill.setId(billDTO.getId());
		bill.setIdUser(billDTO.getUser().getId());
		bill.setBuydate(stringToDate(billDTO.getBuyDate()));
		bill.setTotalPrice(billDTO.getTotalPrice());
		if(billDTO.getCoupon() != null) {
			bill.setIdCoupon(billDTO.getCoupon().getId());
			bill.setDiscount(billDTO.getDiscount());
		}
		
		billDao.update(bill);
	}

	@Override
	public void delete(int id) {
		billDao.delete(id);
	}
	
	@Override
	public Long countBill() {
		return billDao.countBill();
	}

	@Override
	public List<BillDTO> newBill() {
		List<Bill> listBill = billDao.newBill();
		
		if(listBill == null) {
			return null;
		}else {
			List<BillDTO> listBillDTO = new ArrayList<BillDTO>();
			
			for(Bill bill : listBill) {
				BillDTO billDTO = new BillDTO();
				
				billDTO.setId(bill.getId());
				billDTO.setUser(userService.searchUserById(bill.getIdUser()));
				billDTO.setBuyDate(dateToString(bill.getBuydate()));
				billDTO.setTotalPrice(bill.getTotalPrice());
				
				if(bill.getIdCoupon() != null){
					billDTO.setCoupon(couponService.searchCouponById(bill.getIdCoupon()));
					billDTO.setDiscount(bill.getDiscount());
				}
				
				listBillDTO.add(billDTO);
			}
			
			return listBillDTO;
		}
	}

	@Override
	public List<BillDTO> searchAllBill() {
		List<Bill> listBill = billDao.searchAllBill();
		
		if(listBill == null) {
			return null;
		}else {
			List<BillDTO> listBillDTO = new ArrayList<BillDTO>();
			
			for(Bill bill : listBill) {
				BillDTO billDTO = new BillDTO();
				
				billDTO.setId(bill.getId());
				billDTO.setUser(userService.searchUserById(bill.getIdUser()));
				billDTO.setBuyDate(dateToString(bill.getBuydate()));
				billDTO.setTotalPrice(bill.getTotalPrice());
				
				if(bill.getIdCoupon() != null){
					billDTO.setCoupon(couponService.searchCouponById(bill.getIdCoupon()));
					billDTO.setDiscount(bill.getDiscount());
				}
				
				listBillDTO.add(billDTO);
			}
			
			return listBillDTO;
		}
	}

	@Override
	public BillDTO searchBillById(int id) {
		Bill bill = billDao.searchBillById(id);
		
		if(bill == null) {
			return null;
		}else {
			BillDTO billDTO = new BillDTO();
			
			billDTO.setId(bill.getId());
			billDTO.setUser(userService.searchUserById(bill.getIdUser()));
			billDTO.setBuyDate(dateToString(bill.getBuydate()));
			billDTO.setTotalPrice(bill.getTotalPrice());
			
			if(bill.getIdCoupon() != null ){
				billDTO.setCoupon(couponService.searchCouponById(bill.getIdCoupon()));
				billDTO.setDiscount(bill.getDiscount());
			}
			
			return billDTO;
		}
	}

	@Override
	public List<BillDTO> searchBillByUser(int id) {
		List<Bill> listBill = billDao.searchBillByUser(id);
		
		if(listBill == null) {
			return null;
		}else {
			List<BillDTO> listBillDTO = new ArrayList<BillDTO>();
			
			for(Bill bill : listBill) {
				BillDTO billDTO = new BillDTO();
				
				billDTO.setId(bill.getId());
				billDTO.setId(bill.getId());
				billDTO.setUser(userService.searchUserById(bill.getIdUser()));
				billDTO.setBuyDate(dateToString(bill.getBuydate()));
				billDTO.setTotalPrice(bill.getTotalPrice());
				
				if(bill.getIdCoupon() != null){
					billDTO.setCoupon(couponService.searchCouponById(bill.getIdCoupon()));
					billDTO.setDiscount(bill.getDiscount());
				}
				
				listBillDTO.add(billDTO);
			}
			
			return listBillDTO;
		}
	}
	
	@Override
	public String dateToString(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		return dateFormat.format(date);
	}

	@Override
	public Date stringToDate(String string) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		return dateFormat.parse(string);
	}

}
