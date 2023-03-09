package com.org.organisation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.organisation.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	RoleEntity findByName(String name);

}
