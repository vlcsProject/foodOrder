package com.shopping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.Entity.UserEntity;

public interface UserRepository  extends JpaRepository < UserEntity , Integer>{
	
	
	UserEntity  findByUserName(String userName);



}

