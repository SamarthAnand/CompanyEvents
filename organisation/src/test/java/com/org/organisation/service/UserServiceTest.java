package com.org.organisation.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.org.organisation.dto.UserDto;
import com.org.organisation.entity.UserEntity;
import com.org.organisation.repository.UserRepository;

@SpringBootTest
class UserServiceTest {

	@Mock
	private UserRepository userRepo ;
	
	@InjectMocks
	 UserService userService = new UserServiceImpl();
	
	public static UserEntity demo() {
		UserEntity user = new UserEntity();
		user.setId((long)10);
		user.setName("Samarth");
		user.setEmailId("samarth.anand@capgemini.com");
		user.setPassword("1qaz2wsx");
		return user;
		
	}
	@Test
	void test() {
//		UserEntity users = UserServiceTest.demo();
//		List<UserEntity> allEmployees = new ArrayList<>();
//		
//		allEmployees.add(users);
//		when(userRepo.findAll()).thenReturn(allEmployees);
//		List<UserDto> schemeDto = new ArrayList<>();
		
	}

}
