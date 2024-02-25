package com.shopping.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	
	@Column(name = "product_name")
	private String productName;

	@Column(name = "price")
	private Double price;
	
	@Column(name = "quantity")
	private String quantity;

	

	@Column(name = "image")
	private String image;
	
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	
	
	@ManyToOne
	@JoinColumn(name="subcategory_id",referencedColumnName ="id")
	private Subcategory subCategory;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Subcategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(Subcategory subCategory) {
		this.subCategory = subCategory;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	

	


}
