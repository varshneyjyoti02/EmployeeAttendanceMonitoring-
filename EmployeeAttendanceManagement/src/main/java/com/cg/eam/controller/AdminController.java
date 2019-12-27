package com.cg.eam.controller;

import java.util.Collections;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.eam.entity.Admin;
import com.cg.eam.entity.Attendance;
import com.cg.eam.entity.Employee;
import com.cg.eam.service.AdminService;
import com.cg.eam.service.AdminStaffService;


@CrossOrigin("http://localhost:4200")
@RestController
public class AdminController {
	@Autowired
	private AdminService service;

	@Autowired
	private AdminStaffService staffService;
	
//	@Autowired
//	private Search search;
	
	@GetMapping(path= "/login",produces="application/json")
	public List<Admin> getAdmin() {
		return service.adminLogin();

	}

	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee e) {
		return service.addEmployee(e);

		
	}
	
	
	@PutMapping("/update/{id}")
	public String updateEmployee(@PathVariable("id") int id,@RequestBody Employee e) {
		return service.updateEmployee(e, id);
	}
	
	
	@PutMapping("/updateAttendance")
	public String updateEmployeeAttendance(@RequestBody Attendance a ) {
		return staffService.updateEmployeeAttendance(a);
	//	return service.updateEmployee(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return service.deleteEmployee(id);
		
	}
	
	@GetMapping("/getall")
	public List<Employee> employeeList(){
		List<Employee> list=service.employeeList();
		 Collections.sort(list); 
		return list;
	}

	@GetMapping("/name")
	public List<Employee> employeeListByName(){
		List<Employee> list=service.employeeList();
		 Collections.sort(list,Employee.EmpNameComparator); 
		return list;
	}
	
	@GetMapping("/userName")
	public List<Employee> employeeListByUserName(){
		List<Employee> list=service.employeeList();
		 Collections.sort(list,Employee.EmpUserNameComparator); 
		return list;
	}
	
	@GetMapping("/salary")
	public List<Employee> employeeListBySalary(){
		List<Employee> list=service.employeeList();
		 Collections.sort(list,Employee.EmpSalComparator); 
		return list;
	}
	
	@GetMapping("/getById/{id}")
	public List<Employee> employeeDetails(@PathVariable int id) {
		return service.employeeDetails(id);
	}
	@GetMapping("/getByName/{name}")
	public List<Employee> employeeDetails1(@PathVariable String name ) {
		return service.employeeDetails1(name);
	}
	
	@GetMapping("/getByUname/{userName}")
	public List<Employee> employeeDetails2(@PathVariable String userName ) {
		return service.employeeDetails2(userName);
	}
	
	@GetMapping("/getBySal/{salary}")
	public List<Employee> employeeDetails3(@PathVariable int salary ) {
		return service.employeeDetails3(salary);
	}
	@PostMapping("/addAdmin")
	public String addAdmin(@RequestBody Admin admin) {
		return service.addAdmin(admin);
	}
	
//	@GetMapping("/search")
//	public List<Employee> findAll() throws Exception {
//
//		return search.findAll();
//	}
//
//	@GetMapping("/searchbykeyword")
//	public List<Employee> findAllByKeyword(@RequestParam(value = "key") String keyword) throws Exception {
//
//		return search.searchBykeyword(keyword);
//	}
}
