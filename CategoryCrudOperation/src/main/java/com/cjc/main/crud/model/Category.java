package com.cjc.main.crud.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	private String categoryType;
	private String categoryInfo;
	
	
	public Category(int categoryId,String categoryType,String categoryInfo)
	{
		this.categoryId=categoryId;
		this.categoryInfo=categoryInfo;
		this.categoryType=categoryType;
	}
	public Category()
	{
	}
	
	@OneToMany(cascade = CascadeType.DETACH)
	private List<Product> product;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public String getCategoryInfo() {
		return categoryInfo;
	}

	public void setCategoryInfo(String categoryInfo) {
		this.categoryInfo = categoryInfo;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryType=" + categoryType + ", categoryInfo="
				+ categoryInfo + ", product=" + product + "]";
	}
	
	
}
