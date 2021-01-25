package com.javaweb.trapham.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.trapham.dao.BillProductDao;
import com.javaweb.trapham.entity.BillProduct;
import com.javaweb.trapham.model.BillProductDTO;

@Service
@Transactional
public class BillProductServiceImpl implements BillProductService{

	@Autowired
	private BillProductDao billProductDao;
	
	@Autowired
	private BillService billService;
	
	@Autowired
	private ProductService productService;
	
	@Override
	public void insert(BillProductDTO billProductDTO) throws SQLException {
		BillProduct billProduct = new BillProduct();
		
		billProduct.setQuantity(billProductDTO.getQuantity());
		billProduct.setPrice(billProductDTO.getPrice());
		billProduct.setIdbill(billProductDTO.getBill().getId());
		billProduct.setIdProduct(billProductDTO.getProduct().getId());
		
		billProductDao.insert(billProduct);
	}

	@Override
	public void update(BillProductDTO billProductDTO) throws SQLException {
		BillProduct billProduct = new BillProduct();
		
		billProduct.setId(billProductDTO.getId());
		billProduct.setQuantity(billProductDTO.getQuantity());
		billProduct.setPrice(billProductDTO.getPrice());
		billProduct.setIdbill(billProductDTO.getBill().getId());
		billProduct.setIdProduct(billProductDTO.getProduct().getId());
		
		billProductDao.update(billProduct);
	}

	@Override
	public void delete(int id) throws SQLException {
		billProductDao.delete(id);
	}

	@Override
	public List<BillProductDTO> searchBillProductByIdBill(int id) {
		List<BillProduct> listBillProduct = billProductDao.searchBillProductByIdBill(id);
		
		if(listBillProduct == null) {
			return null;
		}else {
			List<BillProductDTO> listBillProductDTO = new ArrayList<BillProductDTO>();
			
			for(BillProduct billProduct : listBillProduct) {
				BillProductDTO billProductDTO = new BillProductDTO();
				
				billProductDTO.setId(billProduct.getId());
				billProductDTO.setQuantity(billProduct.getQuantity());
				billProductDTO.setPrice(billProduct.getPrice());
				billProductDTO.setBill(billService.searchBillById(billProduct.getIdBill()));
				billProductDTO.setProduct(productService.searchProductById(billProduct.getIdProduct()));
				
				listBillProductDTO.add(billProductDTO);
			}
			
			return listBillProductDTO;
		}
	}
}
