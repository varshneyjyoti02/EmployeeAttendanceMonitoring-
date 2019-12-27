package com.cg.eam.service;

import java.util.List;

import java.util.NoSuchElementException;
//import java.util.Optional;

import com.cg.eam.entity.Admin;
import com.cg.eam.entity.Employee;

public interface AdminService {

	public String login(int id);

	public List<Employee> employeeList();

	public Employee addEmployee(Employee e);

	public String deleteEmployee(int id) throws NoSuchElementException;

	public List<Employee> employeeDetails(int id);

	public List<Admin> adminLogin();

	public String addAdmin(Admin admin);

	public String updateEmployee(Employee e, int id);

	public List<Employee> employeeDetails1(String name);

	public List<Employee> employeeDetails2(String uName);

	public List<Employee> employeeDetails3(int sal);
}

//public Album updateAlbum(Album a, int id);