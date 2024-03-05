package com.shopping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.Entity.Subcategory;

public interface SubcategoryRep  extends JpaRepository<Subcategory, Long>{

}
