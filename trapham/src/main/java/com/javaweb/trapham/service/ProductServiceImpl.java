package com.javaweb.trapham.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.trapham.dao.ProductDao;
import com.javaweb.trapham.entity.Product;
import com.javaweb.trapham.model.ProductDTO;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CategoryService categoryService;

	@Override
	public void insert(ProductDTO productDTO) throws SQLException {
		Product product = new Product();
		
		product.setId(productDTO.getId());
		product.setName(productDTO.getName());
		product.setQuantity(productDTO.getQuantity());
		product.setPrice(productDTO.getPrice());
		product.setImg(productDTO.getImg());
		product.setIdCategory(productDTO.getCategory().getId());
		product.setDescription(productDTO.getDescription());
		
		productDao.insert(product);
	}

	@Override
	public void update(ProductDTO productDTO) throws SQLException {
		Product product = new Product();
		
		product.setId(productDTO.getId());
		product.setName(productDTO.getName());
		product.setQuantity(productDTO.getQuantity());
		product.setPrice(productDTO.getPrice());
		product.setImg(productDTO.getImg());
		product.setIdCategory(productDTO.getCategory().getId());
		product.setDescription(productDTO.getDescription());
		
		productDao.update(product);
	}

	@Override
	public void delete(int id) throws SQLException {
		Product product = productDao.searchProductById(id);
				
		productDao.delete(product);
	}

	@Override
	public ProductDTO searchProductById(int id) {
		Product product = productDao.searchProductById(id);
	
		if(product == null) {
			return null;
		}else {
			ProductDTO productDTO = new ProductDTO();
			
			productDTO.setId(product.getId());
			productDTO.setName(product.getName());
			productDTO.setQuantity(product.getQuantity());
			productDTO.setPrice(product.getPrice());
			productDTO.setImg(product.getImg());
			productDTO.setCategory(categoryService.searchCategoryById(product.getIdCategory()));
			productDTO.setDescription(product.getDescription());
			
			return productDTO;
		}
	}

	@Override
	public List<ProductDTO> searchProductByName(String string) {
		List<Product> listProduct = productDao.searchProductByName(string);
		
		if(listProduct == null) {
			return null;
		}else {
			List<ProductDTO> listProductDTO = new ArrayList<ProductDTO>();
			
			for(Product product : listProduct) {
				ProductDTO productDTO = new ProductDTO();
				
				productDTO.setId(product.getId());
				productDTO.setName(product.getName());
				productDTO.setQuantity(product.getQuantity());
				productDTO.setPrice(product.getPrice());
				productDTO.setImg(product.getImg());
				productDTO.setCategory(categoryService.searchCategoryById(product.getIdCategory()));
				productDTO.setDescription(product.getDescription());
				
				listProductDTO.add(productDTO);
			}
			
			return listProductDTO;
		}
	}

	@Override
	public List<ProductDTO> searchProductAll() {
		List<Product> listProduct = productDao.searchProductAll();
		
		if(listProduct == null) {
			return null;
		}else {
			List<ProductDTO> listProductDTO = new ArrayList<ProductDTO>();
			
			for(Product product : listProduct) {
				ProductDTO productDTO = new ProductDTO();
				
				productDTO.setId(product.getId());
				productDTO.setName(product.getName());
				productDTO.setQuantity(product.getQuantity());
				productDTO.setPrice(product.getPrice());
				productDTO.setImg(product.getImg());
				productDTO.setCategory(categoryService.searchCategoryById(product.getIdCategory()));
				productDTO.setDescription(product.getDescription());
				
				listProductDTO.add(productDTO);
			}
			
			return listProductDTO;
		}
	}

	@Override
	public void deleteImg(ProductDTO product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductDTO> searchProductByNameCategory(String string) {
		List<Product> listProduct = productDao.searchProductByNameCategory(string);
		
		if(listProduct == null) {
			return null;
		}else {
			List<ProductDTO> listProductDTO = new ArrayList<ProductDTO>();
			
			for(Product product : listProduct) {
				ProductDTO productDTO = new ProductDTO();
				
				productDTO.setId(product.getId());
				productDTO.setName(product.getName());
				productDTO.setQuantity(product.getQuantity());
				productDTO.setPrice(product.getPrice());
				productDTO.setImg(product.getImg());
				productDTO.setCategory(categoryService.searchCategoryById(product.getIdCategory()));
				productDTO.setDescription(product.getDescription());
				
				listProductDTO.add(productDTO);
			}
			
			return listProductDTO;
		}
	}

	@Override
	public long countProduct() {
		return productDao.countProduct();
	}

	@Override
	public List<ProductDTO> searchProductLastLimit4() {
		List<Product> listProduct = productDao.searchProductLastLimit4();
		
		if(listProduct == null) {
			return null;
		}else {
			List<ProductDTO> listProductDTO = new ArrayList<ProductDTO>();
			
			for(Product product : listProduct) {
				ProductDTO productDTO = new ProductDTO();
				
				productDTO.setId(product.getId());
				productDTO.setName(product.getName());
				productDTO.setQuantity(product.getQuantity());
				productDTO.setPrice(product.getPrice());
				productDTO.setImg(product.getImg());
				productDTO.setCategory(categoryService.searchCategoryById(product.getIdCategory()));
				productDTO.setDescription(product.getDescription());
				
				listProductDTO.add(productDTO);
			}
			
			return listProductDTO;
		}
	}
	
	@Override
	public List<ProductDTO> searchProductLastLimit4Next() {
		List<Product> listProduct = productDao.searchProductLastLimit4Next();
		
		if(listProduct == null) {
			return null;
		}else {
			List<ProductDTO> listProductDTO = new ArrayList<ProductDTO>();
			
			for(Product product : listProduct) {
				ProductDTO productDTO = new ProductDTO();
				
				productDTO.setId(product.getId());
				productDTO.setName(product.getName());
				productDTO.setQuantity(product.getQuantity());
				productDTO.setPrice(product.getPrice());
				productDTO.setImg(product.getImg());
				productDTO.setCategory(categoryService.searchCategoryById(product.getIdCategory()));
				productDTO.setDescription(product.getDescription());
				
				listProductDTO.add(productDTO);
			}
			
			return listProductDTO;
		}
	}
	
	@Override
	public List<ProductDTO> searchProductLastLimit3(String string) {
		List<Product> listProduct = productDao.searchProductLastLimit3(string);
		
		if(listProduct == null) {
			return null;
		}else {
			List<ProductDTO> listProductDTO = new ArrayList<ProductDTO>();
			
			for(Product product : listProduct) {
				ProductDTO productDTO = new ProductDTO();
				
				productDTO.setId(product.getId());
				productDTO.setName(product.getName());
				productDTO.setQuantity(product.getQuantity());
				productDTO.setPrice(product.getPrice());
				productDTO.setImg(product.getImg());
				productDTO.setCategory(categoryService.searchCategoryById(product.getIdCategory()));
				productDTO.setDescription(product.getDescription());
				
				listProductDTO.add(productDTO);
			}
			
			return listProductDTO;
		}
	}
	
	@Override
	public List<ProductDTO> searchProductLastLimit6() {
		List<Product> listProduct = productDao.searchProductLastLimit6();
		
		if(listProduct == null) {
			return null;
		}else {
			List<ProductDTO> listProductDTO = new ArrayList<ProductDTO>();
			
			for(Product product : listProduct) {
				ProductDTO productDTO = new ProductDTO();
				
				productDTO.setId(product.getId());
				productDTO.setName(product.getName());
				productDTO.setQuantity(product.getQuantity());
				productDTO.setPrice(product.getPrice());
				productDTO.setImg(product.getImg());
				productDTO.setCategory(categoryService.searchCategoryById(product.getIdCategory()));
				productDTO.setDescription(product.getDescription());
				
				listProductDTO.add(productDTO);
			}
			
			return listProductDTO;
		}
	}


	@Override
	public List<ProductDTO> searchBestSell5() {
		List<Product> listProduct = productDao.searchBestSell5();
		
		if(listProduct == null) {
			return null;
		}else {
			List<ProductDTO> listProductDTO = new ArrayList<ProductDTO>();
			
			for(Product product : listProduct) {
				ProductDTO productDTO = new ProductDTO();
				
				productDTO.setId(product.getId());
				productDTO.setName(product.getName());
				productDTO.setQuantity(product.getQuantity());
				productDTO.setPrice(product.getPrice());
				productDTO.setImg(product.getImg());
				productDTO.setCategory(categoryService.searchCategoryById(product.getIdCategory()));
				productDTO.setDescription(product.getDescription());
				
				listProductDTO.add(productDTO);
			}
			
			return listProductDTO;
		}
	}

	@Override
	public List<ProductDTO> searchProductByIdPage(int id) {
		List<Product> listProduct = productDao.searchProductByIdPage(id);
		
		if(listProduct == null) {
			return null;
		}else {
			List<ProductDTO> listProductDTO = new ArrayList<ProductDTO>();
			
			for(Product product : listProduct) {
				ProductDTO productDTO = new ProductDTO();
				
				productDTO.setId(product.getId());
				productDTO.setName(product.getName());
				productDTO.setQuantity(product.getQuantity());
				productDTO.setPrice(product.getPrice());
				productDTO.setImg(product.getImg());
				productDTO.setCategory(categoryService.searchCategoryById(product.getIdCategory()));
				productDTO.setDescription(product.getDescription());
				
				listProductDTO.add(productDTO);
			}
			
			return listProductDTO;
		}
	}

	@Override
	public List<Integer> pages(int pages) {
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i = 1;i<=pages;i++) {
			list.add(i);
		}
		
		return list;
	}

	@Override
	public List<ProductDTO> searchProduct(String string) {
		List<Product> listProduct = productDao.searchProduct(string);
		
		if(listProduct == null) {
			return null;
		}else {
			List<ProductDTO> listProductDTO = new ArrayList<ProductDTO>();
			
			for(Product product : listProduct) {
				ProductDTO productDTO = new ProductDTO();
				
				productDTO.setId(product.getId());
				productDTO.setName(product.getName());
				productDTO.setQuantity(product.getQuantity());
				productDTO.setPrice(product.getPrice());
				productDTO.setImg(product.getImg());
				productDTO.setCategory(categoryService.searchCategoryById(product.getIdCategory()));
				productDTO.setDescription(product.getDescription());
				
				listProductDTO.add(productDTO);
			}
			
			return listProductDTO;
		}
	}
	
	
}
