package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shopping.Entity.UserDto;
import com.shopping.Entity.UserEntity;
import com.shopping.service.UserService;

@RestController
@RequestMapping(value ="/user" )
@CrossOrigin(origins="*")

public class UserController {
	@Autowired
	UserService userservice;
	
	@PostMapping(value = "/login")
	public UserEntity checkLogin(@RequestBody UserDto userDto) {
		return userservice.login(userDto);
		
	}
	
	@PostMapping(value="/save")
	public UserEntity posted(@RequestBody UserEntity value) {
		return userservice.posted(value);
	}
	@GetMapping(value="/getall")
	public List <UserEntity> get(){
		return userservice.get();
	}
	@GetMapping(value="/getById/{id}")
	public UserEntity getid(@PathVariable int id) {
		return userservice.getid(id);
		
	}
	@DeleteMapping(value="delete/{id}")
	public UserEntity destroy(@PathVariable int id) {
		return userservice.destory(id);
	}
	@PutMapping(value="/update/{id}")
	public UserEntity updated(@RequestBody UserEntity data , @PathVariable int id) {
		return userservice.updated(data,id);
	}


}
