package com.shopping.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopping.Entity.Category;
import com.shopping.Repository.CategoryRep;

@Repository

public class CategoryDao {
	
	@Autowired
	CategoryRep categorrep;

	public Category saved(Category values) {
		
		return categorrep.save(values);
	}

	public List<Category> getall() {
		
		return categorrep.findAll();
	}

}
