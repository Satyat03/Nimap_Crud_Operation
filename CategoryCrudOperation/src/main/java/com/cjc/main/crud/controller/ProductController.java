package com.cjc.main.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.crud.model.Category;
import com.cjc.main.crud.model.Product;
import com.cjc.main.crud.service.CategoryService;
import com.cjc.main.crud.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	ProductService ps;
	
	@Autowired
	CategoryService cs;
	
	@PostMapping("/saveproduct")
	public String saveProduct(@RequestBody Product p)
	{
		
		
		ps.save(p);
		return "savedata";
	}
	
	
	
	@GetMapping("/getallproduct")
	public List<Product> getAllProduct()
	{
		List<Product> lp=ps.getAllProduce();
		
		return lp;
	}
	
	
	@GetMapping("/getproductbypid/{pid}/{categoryId}")
	public Product getProductPyPid(@PathVariable("pid")int pid,@PathVariable("categoryId")int categoryId)
	{
		Category c=cs.findByctegoryId(categoryId);
		
	 Category c1=new Category(c.getCategoryId(),c.getCategoryType(),c.getCategoryInfo());
		
		 
		
		
		Product p=ps.findByPid(pid);
		
	
		return p;
	}
	@PutMapping("/updateproductbypid/{pid}")
	public String updateProductByPid(@PathVariable("pid")int pid,@RequestBody Product p)
	{
		Product pp=ps.findByPid(pid);
		pp.setPname(p.getPname());
		pp.setPprice(p.getPprice());
		ps.save(pp);
		
		return "update";
	}
	
	
	
	@DeleteMapping("/deletebypid/{pid}")
	public String deleteProductByPid(@PathVariable("pid")int pid)
	{
		ps.deleteByPid(pid);
		return "deleted";
	}
	
	 @GetMapping("/getproductByPage/{page}")
	    public List<Product> getAllProducts(
	            @PathVariable int page
	            ) 
	 {
		   
	        Pageable paging = PageRequest.of(page,2);
	        Page<Product> pages = ps.getAllProduct(paging);
	 
	      
	        return pages.getContent();
	        
	    }
	 
	
	 @GetMapping("/getproductByPage/{page}/{size}/{sortBy}")
	    public List<Product> getAllProducts(
	            @PathVariable int page,
	            @PathVariable int size,
	            @PathVariable String sortBy
	            ) 
	 {
		   
	        Pageable paging = PageRequest.of(
	            page, size, Sort.by(sortBy).ascending());
	        Page<Product> pages = ps.getAllProduct(paging);
	 
	      
	        return pages.getContent();
	        
	    }
	 
	
	
}
