package com.cjc.main.crud.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cjc.main.crud.model.Category;
import com.cjc.main.crud.repository.CategoryRepository;
import com.cjc.main.crud.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	
	@Autowired
	CategoryRepository cr;
	
	@Override
	public void saveCategory(Category c) {
		
		cr.save(c);
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return (List<Category>) cr.findAll();
	}

	@Override
	public Category findByctegoryId(int categoryId) {
		// TODO Auto-generated method stub
		return cr.findBycategoryId(categoryId);
	}

	@Override
	public void deleteCategory(int cid) {
		cr.deleteById(cid);
		
	}

	@Override
	public Page<Category> getAllCategoryByPage(Pageable pg) {
	
		return cr.findAll(pg);
	}


	

}
