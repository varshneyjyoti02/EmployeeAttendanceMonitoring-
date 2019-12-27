package com.cg.eam.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.eam.entity.Admin;
import com.cg.eam.entity.Attendance;
import com.cg.eam.entity.Employee;
import com.cg.eam.repo.AdminRepo;
import com.cg.eam.repo.EmployeeRepo;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	@Autowired
	private EmployeeRepo repo;

	@Autowired
	private AdminRepo adminRepo;

	@Autowired
	AdminStaffService adminStaffService;

	@Override
	public String login(int id) {
		Date date = new Date();
		System.out.println(date);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = formatter.format(date);
		System.out.println(formattedDate);
		if (repo.findById(id).isPresent()) {
			Attendance attendance = new Attendance();
			attendance.setDate(formattedDate);
			attendance.setStatus("Present");
			attendance.setEmpId(id);
			adminStaffService.updateEmployeeAttendance(attendance);
			return "Present";
		} else
			return "Not Present";
	}

	@Override
	public List<Employee> employeeList() {

		return repo.findAll();
	}

	@Override
	public Employee addEmployee(Employee e) {

		
		e.setPassword(e.getUserName() + "123");
		repo.save(e);
		return e;


	}

	@Override
	public String deleteEmployee(int id) throws NoSuchElementException {
		try {
			if (repo.findById(id).isPresent()) {
				repo.deleteById(id);
				return " Deleted";
			}
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("No  Record Found For Id " + id);
		}
		return "No Record Found For Id  " + id;
	}

	@Override
	public List<Employee> employeeDetails(int id) {

		List<Employee> empList = new ArrayList<Employee>();
		Employee emp = repo.findById(id).get();
		empList.add(emp);
		return empList;

	}

	@Override
	public List<Admin> adminLogin() {
		List<Admin> list = adminRepo.findAll();
		return list;
	}

	@Override
	public String addAdmin(Admin admin) {
		adminRepo.save(admin);
		return "added new admin";
	}

	@Override
	public String updateEmployee(Employee e, int id) {
		e.setId(id);
		repo.save(e);
		return "Updated Successfully";
	}

	@Override
	public List<Employee> employeeDetails1(String name) {
	
		return repo.findByName(name);
	}

	@Override
	public List<Employee> employeeDetails2(String uName) {
		
		return repo.findByUserName(uName);
	}

	@Override
	public List<Employee> employeeDetails3(int sal) {
		
		return repo.findBySalary(sal);
	}

}
