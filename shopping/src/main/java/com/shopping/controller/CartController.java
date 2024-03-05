package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shopping.Entity.CartEntity;
import com.shopping.dto.JsonResponse;
import com.shopping.service.CartService;

@RestController
@RequestMapping(value = "/cart")
@CrossOrigin(origins = "*")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping()
    public ResponseEntity<JsonResponse> addItemToCart(@RequestBody CartEntity addcart) {
        String responseMessage = cartService.addItem(addcart);
        JsonResponse jsonResponse = new JsonResponse(responseMessage);
        return ResponseEntity.ok(jsonResponse);
    }

    @GetMapping(value = "/getall")
    public List<CartEntity> getall() {
        return cartService.getall();
    }

    @GetMapping(value = "/userById/{id}")
    public List<CartEntity> getCartItemByUserId(@PathVariable Long id) {
        return cartService.getCartItemByUserId(id);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CartEntity> getItemById(@PathVariable Long id) {
        return cartService.getItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteItem(@PathVariable Long id) {
        cartService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/updatecart/{id}")
    public ResponseEntity<JsonResponse> updateItemToCart(@PathVariable Long id) {
        String responseMessage = cartService.update(id);
        JsonResponse jsonResponse = new JsonResponse(responseMessage);
        return ResponseEntity.ok(jsonResponse);
    }
}
