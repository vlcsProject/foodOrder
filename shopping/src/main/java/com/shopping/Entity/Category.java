package com.shopping.Entity;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="category")
public class Category {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	
	@Column(name="category_name")
	public String categoryName;
	
	
	
	@OneToMany(cascade=CascadeType.ALL,targetEntity= Subcategory.class)
	@JoinColumn(name="category_id",referencedColumnName="id")
	List<Subcategory> subcategory;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Subcategory> getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(List<Subcategory> subcategory) {
		this.subcategory = subcategory;
	}
	
	

}
