package com.shopping.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopping.Entity.CartEntity;
import com.shopping.Repository.CartRep;

@Repository
public class CartDao {
	
	
	@Autowired
	CartRep cartRep;

	public String  save(CartEntity addcart) {
		
		Long userId = addcart.getUser().getId() ;
		Long productId = addcart.getProductId();
		char status = 'A';
		
		CartEntity existingEntry = cartRep.findByUserIdAndStatus(userId,productId,status);
		 if(existingEntry !=null) {
			 return "product already exist in the cart .";
					 
		 }else {
			 addcart.setStatus(status);
			 cartRep.save(addcart);
			 return "product Addcart sucessfully";
		 }
		
	}

	public List<CartEntity> getall() {
	
		return cartRep.findAll();
	}

	public List<CartEntity> getCartItemByUserId(Long id) {
		return cartRep.findByUserIdAndStatus(id);
	}

	public Long deleteItem(Long id) {
     CartEntity addCart = cartRep.findById(id).orElse(null);
     
     if(addCart != null) {
    	 cartRep.deleteById(id);
    	 return addCart.getId();
     }
		return null;
	}

	public CartEntity getById(Long id) {
		return cartRep.findById(id).orElse(null);
	}

	public String update(Long id) {
		char status = 'D';
		CartEntity updateAddCart = cartRep.findById(id).orElse(null);
			updateAddCart.setStatus(status);
			cartRep.save(updateAddCart);
		return "cart updated sucessfully";
			
		
	}

}
