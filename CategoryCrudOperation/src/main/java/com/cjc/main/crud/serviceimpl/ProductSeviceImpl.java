package com.cjc.main.crud.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cjc.main.crud.model.Product;
import com.cjc.main.crud.repository.ProductRepository;
import com.cjc.main.crud.service.ProductService;

import jakarta.transaction.Transactional;
@Transactional
@Service
public class ProductSeviceImpl implements ProductService{

	@Autowired
	ProductRepository pr;
	
	@Override
	public List<Product> getAllProduce() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public Product findByPid(int pid) {
		// TODO Auto-generated method stub
		return pr.findByPid(pid);
	}

	@Override
	public void save(Product pp) {
	pr.save(pp);
		
	}

	

	@Override
	public Page<Product> getAllProduct(Pageable pages) {
		// TODO Auto-generated method stub
		return pr.findAll(pages);
	}

	@Override
	public void deleteByPid(int pid) {
		pr.deleteById(pid);
	}


	
	
	

	

	
	
}
