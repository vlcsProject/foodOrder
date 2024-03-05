package com.shopping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.Entity.Category;

public interface CategoryRep extends JpaRepository <Category , Long> {


}
