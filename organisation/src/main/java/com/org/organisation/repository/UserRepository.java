package com.org.organisation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.organisation.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findByEmailId(String emailId);
	UserEntity findByUserName(String userName);
}
