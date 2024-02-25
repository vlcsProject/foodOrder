package com.shopping.Dao;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.shopping.Entity.Category;
import com.shopping.Entity.ProductEntity;
import com.shopping.Entity.Subcategory;
import com.shopping.Repository.CategoryRep;
import com.shopping.Repository.ProductRepository;
import com.shopping.Repository.SubcategoryRep;

@Repository

public class ProductDao {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRep categoryRep;
	
	@Autowired
	SubcategoryRep subcategoryRep;
	
    @Value("${upload.folder}")
    private String uploadFolder;
    
    private final String uploadDir = System.getProperty("user.dir") + "/src/main/resources/foodImage/";

	
	public ProductEntity saved(MultipartFile image,String ProductName,String Price,String Quantity,
			String categoryIdStr,String subCategoryIdStr) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setProductName(ProductName);
		productEntity.setPrice(Double.parseDouble(Price));
		productEntity.setQuantity(Quantity);
		
		Category category = categoryRep.findById(Long.parseLong(categoryIdStr))
		        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category Not found"));
		productEntity.setCategory(category);

		
		Subcategory subcategory = subcategoryRep.findById(Long.parseLong(subCategoryIdStr))
		        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Subcategory Not Found"));
		productEntity.setSubCategory(subcategory);
				
				
				
				
		
		String fileName =  System.currentTimeMillis()+" "+image.getOriginalFilename();
		productEntity.setImage(fileName);
		
		try {
			File targetFile = new File(uploadDir,fileName);
			image.transferTo(targetFile);
		}
		catch(Exception e) {
			
		}
		return productRepository.save(productEntity);
		
	}


	public List<ProductEntity> getvalues() {
	
		return productRepository.findAll();
	}
	public ProductEntity getid(long id) {
		return productRepository.findById(id).get();
}

public ProductEntity destory(long id) {
	ProductEntity data=productRepository.findById(id).get();
	productRepository.deleteById(id);
	return data;		
}

public ProductEntity updated(ProductEntity data, long id) {
	ProductEntity value = productRepository.findById(id).get();
	value.setProductName(data.getProductName());
	value.setPrice(data.getPrice());		
	value.setQuantity(data.getQuantity());
//	value.setCategory(data.getCategory());
	productRepository.save(value);
	return value;	
}


public List<ProductEntity> getCategoryName(Long CategoryId) {
	return productRepository.findBySubCategoryId(CategoryId);
}

}
