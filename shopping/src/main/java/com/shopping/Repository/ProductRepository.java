package com.shopping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.Entity.ProductEntity;
import java.util.List;


public interface ProductRepository  extends JpaRepository<ProductEntity, Long>{
	
	List<ProductEntity> findBySubCategoryId(Long id);

}
