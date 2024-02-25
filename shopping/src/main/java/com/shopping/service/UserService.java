package com.shopping.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.Dao.UserDao;
import com.shopping.Entity.UserDto;
import com.shopping.Entity.UserEntity;

@Service

public class UserService {
	@Autowired
	UserDao userdao;
	


	public UserEntity login(UserDto userDto) {
		return userdao.login(userDto) ;
	}


		

	public UserEntity posted(UserEntity value) {		
		return userdao.posted(value) ;
	}

	public List<UserEntity> get() {
		return userdao.get();
	}

	public UserEntity getid(int id) {
		
		return userdao.getid(id);
	}

	public UserEntity destory(int id) {
		return userdao.destory(id);
	}

	public UserEntity updated(UserEntity data, int id) {
		
		return userdao.updated(data,id);
	}

}