package com.org.organisation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.organisation.exception.EmployeeException;
import com.org.organisation.entity.Employee;
import com.org.organisation.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	private EmployeeRepository repo;
	
	//get all employees rest api
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return repo.findAll();
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return repo.save(employee);
	}
	//get emp by id 
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable Long id) throws EmployeeException{
	Employee emp = repo.findById(id).orElseThrow(() -> new EmployeeException("Employee with this id doesn't exist : "+id));	
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	
	//update the employee data
	@PutMapping("/update/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) throws EmployeeException{
		Employee currEmp = repo.findById(id).orElseThrow(() ->  new EmployeeException("Employee with this id doesn't exist."));
		currEmp.setFirstName(employee.getFirstName());
		currEmp.setLastName(employee.getLastName());
		currEmp.setEmailId(employee.getEmailId());
		
		return new ResponseEntity<>(repo.save(currEmp), HttpStatus.OK);
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable @jakarta.validation.constraints.Min(value = 1, message = "Id should be greater than 1") Long id) throws EmployeeException{
		repo.deleteById(id);
		String message =  "The concerned employee data is deleted.";
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	
	
}
