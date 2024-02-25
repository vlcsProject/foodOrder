package com.shopping.service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shopping.Dao.ProductDao;
import com.shopping.Entity.ProductEntity;
import com.shopping.Entity.UserEntity;

@Service
public class ProductSerivce {
	@Autowired
	ProductDao productDao;
	@Value("${upload.folder}")
	private String uploadFolder;
	
	 private final String uploadDir = System.getProperty("user.dir") + "/src/main/resources/foodImage/";

	public ProductEntity saved(MultipartFile image, String ProductName, String Price, String Quantity,
			String categoryIdStr, String subCategoryIdStr) {
		return productDao.saved(image, ProductName, Price, Quantity, categoryIdStr, subCategoryIdStr);
	}

	public List<ProductEntity> getvalues() {
		return productDao.getvalues();
	}

	public ProductEntity getid(int id) {

		return productDao.getid(id);
	}

	public ProductEntity destory(int id) {
		return productDao.destory(id);
	}

	public ProductEntity updated(ProductEntity data, long id) {

		return productDao.updated(data, id);
	}

	public List<ProductEntity> getCategoryName(Long categoryId) {
		return productDao.getCategoryName(categoryId);
	}

	public Resource getProductImage(String image) {
		Path imagePath = Paths.get(uploadDir).resolve(image);
		try {
			Resource sd = new FileSystemResource(imagePath);
			if (sd.exists() && sd.isReadable()) {
				return sd;
			} else {
				throw new IOException("Image not found: " + image);
			}
		} catch (IOException e) {
			throw new RuntimeException("Error loading image: " + image, e);
		}

	}
}
