package com.shopping.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import com.shopping.Entity.ProductEntity;
import com.shopping.service.ProductSerivce;



@RestController
@RequestMapping(value ="/products" )
@CrossOrigin(origins="*")


public class ProductController {
	@Autowired
	ProductSerivce productService;
	
	 @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
     public ProductEntity saved(@RequestPart(name="image")MultipartFile image,
     		@RequestPart(name="productName")String productName,
     		@RequestPart(name="price")String price,
     		@RequestPart(name="quantity")String quantity,
     		@RequestPart(name="categoryIdStr")String categoryIdStr ,
     		@RequestPart(name="subcategoryIdStr")String subCategoryIdStr )
	 {
     	return productService.saved(image,productName,price,quantity,categoryIdStr,subCategoryIdStr);
     }
	 
	 
	 @GetMapping(value="/getProductImage/{image}")
	 public ResponseEntity<Resource> getProductImage(@PathVariable(name="image")String image) {
		 Resource sd=productService.getProductImage(image);
		 
		    return ResponseEntity.ok()
	            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + sd.getFilename() + "\"")
		            .body(sd);
	 }
	 
	 @GetMapping(value ="/getall")	
	  public List  <ProductEntity>getvalues(){
	   return productService .getvalues(); 
			   }
	 @GetMapping(value="/getById/{id}")
		public ProductEntity getid(@PathVariable int id) {
			return productService.getid(id);
			
		}
	 
	
		@DeleteMapping(value="/delete/{id}")
		public ProductEntity destroy(@PathVariable int id) {
			return productService.destory(id);
		}
		@PutMapping(value="/update/{id}")
		public ProductEntity updated(@RequestBody ProductEntity data , @PathVariable long id) {
			return productService.updated(data,id);
		}
		 @GetMapping(value="/getByCategory/{categoryId}")
			public List<ProductEntity> getCategoryName(@PathVariable Long categoryId) {
				return productService.getCategoryName(categoryId);	
			}
	 
}
