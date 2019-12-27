package com.cg.eam.service;

import java.util.List;

import com.cg.eam.entity.Attendance;
import com.cg.eam.entity.Employee;
import com.cg.eam.entity.Login;

public interface EmployeeService {

	//public Optional<Employee> login(int id);

	//public String empLogin(int id);

	public Employee employeeLogin(Login login);
	
	public List<Attendance> viewEmployeeAttendance(int id);

	public int viewLop(int id);

	public String applyForLeave(int employeeId, String date);

}
