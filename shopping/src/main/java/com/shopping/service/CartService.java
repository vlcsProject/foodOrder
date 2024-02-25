package com.shopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shopping.Dao.CartDao;
import com.shopping.Entity.CartEntity;

@Service
public class CartService {
    @Autowired
    CartDao cartDao;

///    public CartEntity saves(CartEntity value) {
//        return cartDao.saves(value);
//    }

    public List<CartEntity> getall() {
        return cartDao.getall();
    }

    public List<CartEntity> getCartItemByUserId(Long id) {
        return cartDao.getCartItemByUserId(id);
    }

  

    public String addItem(CartEntity addcart) {
      
        return cartDao.save(addcart);
    }

    public Long deleteItem(Long id) {
        return cartDao.deleteItem(id);
    }

    public Optional<CartEntity> getItemById(Long id) {
        return Optional.ofNullable(cartDao.getById(id));
        
    }

	public String update(Long id) {
		return cartDao.update(id) ;
	}
}
