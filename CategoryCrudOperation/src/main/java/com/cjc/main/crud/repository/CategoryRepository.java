package com.cjc.main.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cjc.main.crud.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{


	public Category findBycategoryId(int categoryId);
	
}

