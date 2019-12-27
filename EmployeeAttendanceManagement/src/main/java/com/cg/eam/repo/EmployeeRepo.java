package com.cg.eam.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.eam.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	public Optional<Employee> findByUserNameAndPassword(String userName,String password);
	
	public List<Employee> findByName(String name);
	
	public List<Employee> findByUserName(String userName);

	public List<Employee> findBySalary(Integer sal);

}
