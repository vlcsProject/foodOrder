package com.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.Dao.CategoryDao;
import com.shopping.Entity.Category;

@Service
public class CategoryService {
	
	@Autowired
	CategoryDao categorydao;

	public Category saved(Category values) {
		
		return categorydao.saved(values);
	}

	public List<Category> getall() {
		return categorydao.getall();
	}

}
