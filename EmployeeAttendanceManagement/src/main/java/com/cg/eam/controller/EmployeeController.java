package com.cg.eam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.eam.entity.Attendance;
import com.cg.eam.entity.Employee;
import com.cg.eam.entity.Login;
//import com.cg.eam.entity.Employee;
import com.cg.eam.service.AdminStaffService;
import com.cg.eam.service.EmployeeService;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@Autowired
	private AdminStaffService adminService;

	@GetMapping("/attendance/{id}")
	public List<Attendance> employeeAttendance(@PathVariable int id) {
		return empService.viewEmployeeAttendance(id);
	}

	@PostMapping(path= "/leave",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public String applyLeave(@RequestBody Attendance attendance) {
          System.out.println("success");
          System.out.println(attendance.getEmpId());
          System.out.println(attendance.getDate());
          System.out.println(attendance.getStatus());
		return empService.applyForLeave(attendance.getEmpId(), attendance.getDate());

	}
	
	@GetMapping(path= "/leave/{id}/{date}",produces = MediaType.APPLICATION_JSON_VALUE)
	public String applyLeave(@PathVariable("id") int id,@PathVariable("date") String date) {

		return empService.applyForLeave(id,date);

	}
	
	@PostMapping(path= "/employeelogin",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeLogin(@RequestBody Login login) {
		return empService.employeeLogin(login);

	}

	
	@GetMapping("/lop/{id}")
	public int calculateLop(@PathVariable int id) {
		return adminService.calculateLop(id);
	}
	
	@GetMapping("/viewlop/{id}")
	public int viewLop(@PathVariable int id) {
		return adminService.calculateLop(id);
	}
	
}
