package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.Entity.Category;
import com.shopping.service.CategoryService;

@RestController
@RequestMapping(value ="/category")

@CrossOrigin(origins = "*")
public class CategoryController {
	
	@Autowired
	CategoryService categoryservice;
	
	@PostMapping(value="/save")
	public Category saved( @RequestBody  Category values) {
		return categoryservice.saved(values);
	}
	@GetMapping(value="/getall")
	public  List < Category >getall(){
		return categoryservice.getall();
	}

	
	
}


