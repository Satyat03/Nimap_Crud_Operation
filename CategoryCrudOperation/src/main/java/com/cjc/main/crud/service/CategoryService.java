package com.cjc.main.crud.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.cjc.main.crud.model.Category;

public interface CategoryService {

	public void saveCategory(Category c);

	public List<Category> getAllCategory();
	

	public Category findByctegoryId(int categoryId);

	public void deleteCategory(int cid);
	
	public Page<Category> getAllCategoryByPage(Pageable pg); 
}
