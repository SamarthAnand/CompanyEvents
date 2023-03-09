package com.org.organisation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.organisation.entity.Employee;
import com.org.organisation.entity.EventsEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
}
