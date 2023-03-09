package com.org.organisation.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.org.organisation.dto.UserDto;
import com.org.organisation.entity.RoleEntity;
import com.org.organisation.entity.UserEntity;
import com.org.organisation.repository.RoleRepository;
import com.org.organisation.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	
	private UserRepository userRepo;
	private RoleRepository roleRepo;
	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
//	
	private PasswordEncoder passwordEncoder;
	public UserServiceImpl(@Lazy UserRepository userRepo, RoleRepository roleRepo) {
		
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
		//this.passwordEncoder = passwordEncoder;
	}
	public UserServiceImpl() {
		super();
	}
	@Override
	public void saveUser(UserDto userdto) {
		// TODO Auto-generated method stub
		UserEntity user = new UserEntity();
		user.setName(userdto.getFirstName()+" "+userdto.getLastName());
		user.setEmailId(userdto.getEmailId());
		user.setPassword(passwordEncoder.encode(userdto.getPassword()));
		
		RoleEntity role = roleRepo.findByName("ROLE_ADMIN");
		if(role == null)
		{
			role = checkRoleExist();
			
		}
		user.setRoles(Arrays.asList(role));
		userRepo.save(user);
		
	}
	@Override
	public UserEntity findUserByEmailId(String emailId) {
		// TODO Auto-generated method stub
		
		return userRepo.findByEmailId(emailId);
	}
	@Override
	public List<UserDto> findAll() {
		// TODO Auto-generated method stub
		List<UserEntity> allUsers = userRepo.findAll();
		
		return allUsers.stream()
				.map((user) -> mapToUserDto(user))
				.collect(Collectors.toList());
	}
	
	public UserDto mapToUserDto(UserEntity user) {
		UserDto userdto = new UserDto();
		String[] str = user.getName().split(" ");
		userdto.setFirstName(str[0]);
		userdto.setLastName(str[1]);
		userdto.setEmailId(user.getEmailId());
		return userdto;
	}
	
	//checke
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		UserEntity user = userRepo.findByEmailId(username);
		if(user == null)
			throw new UsernameNotFoundException("Invalid username or password");
		
		return new org.springframework.security.core.userdetails.User(user.getEmailId(), user.getPassword(),mapRoleToAuthority(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRoleToAuthority(Collection<RoleEntity> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());	
	}
	private RoleEntity checkRoleExist() {
		RoleEntity role = new RoleEntity();
		role.setName("ADMIN");
		return roleRepo.save(role);
	}
	
	
}
