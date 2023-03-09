package com.org.organisation.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.org.organisation.dto.UserDto;
import com.org.organisation.entity.UserEntity;

public interface UserService extends UserDetailsService{

	void saveUser(UserDto userdto);
	
	UserEntity findUserByEmailId(String emailId);
	
	List<UserDto> findAll();
}
