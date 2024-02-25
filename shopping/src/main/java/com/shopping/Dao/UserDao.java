package com.shopping.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.shopping.Entity.UserDto;
import com.shopping.Entity.UserEntity;
import com.shopping.Repository.UserRepository;



	  @Repository
	  public class UserDao {
		  @Autowired
			UserRepository userrepository;
			
			
			@Autowired

			  private PasswordEncoder passwordEncoder;	
			


			public UserEntity login(UserDto userDto) {
				UserEntity user = userrepository.findByUserName(userDto.getUserName());

			    if (user != null && passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
			        
			    	return user;
			    }
			    else {
			    	 user = null;
			   
			}		
			    return user;
			} 

			    public UserEntity posted(UserEntity value) {
				value.setPassword(passwordEncoder.encode(value.getPassword()));
				return userrepository.save(value);
			}

			  
			  
			  
			public List<UserEntity> get() {
				return userrepository.findAll();
			}

			public UserEntity getid(int id) {
					return userrepository.findById(id).get();
			}

			public UserEntity destory(int id) {
				UserEntity data=userrepository.findById(id).get();
				userrepository.deleteById(id);
				return data;		
			}

			public UserEntity updated(UserEntity data, int id) {
				UserEntity newvalue = userrepository.findById(id).get();
				newvalue.setUserName(data.getUserName());
				newvalue.setMobileNo(data.getMobileNo());		
				newvalue.setEmailId(data.getEmailId());
				newvalue.setPassword(data.getPassword());
				userrepository.save(newvalue);
				return newvalue;	
		}
					
	  }




