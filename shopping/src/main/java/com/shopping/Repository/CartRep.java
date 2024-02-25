package com.shopping.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shopping.Entity.CartEntity;

public interface CartRep extends JpaRepository  < CartEntity , Long>{
	
	@Query(value ="SELECT * FROM cart WHERE user_Id = :userId AND status = 'A' ",nativeQuery = true)
	List<CartEntity>findByUserIdAndStatus(@Param("userId")Long userId);
	
	@Query(value ="SELECT * FROM cart WHERE user_Id = :userId AND  product_Id= :productId And status = :status ",nativeQuery = true)
CartEntity findByUserIdAndStatus (@Param ("userId") Long userId, @Param("productId") Long productId, @Param("status") char status);
	

}
