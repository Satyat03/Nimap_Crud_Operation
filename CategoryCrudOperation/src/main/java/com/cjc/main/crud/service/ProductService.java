package com.cjc.main.crud.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.cjc.main.crud.model.Category;
import com.cjc.main.crud.model.Product;

public interface ProductService {

	List<Product> getAllProduce();
	
	public  Product findByPid(int pid);

	public void save(Product pp);
	
	
	Page<Product> getAllProduct(Pageable pages);

	///public void deleteByPid(@Param("pid")int pid); 
	
	public void deleteByPid(int pid);
}
