package com.cg.eam.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.eam.entity.Attendance;
import com.cg.eam.entity.Employee;
import com.cg.eam.entity.Login;
import com.cg.eam.repo.AttendanceRepo;
import com.cg.eam.repo.EmployeeRepo;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	AttendanceRepo attendanceRepo;

	@Autowired
	EmployeeRepo empRepo;

	@Autowired
	private AdminStaffService staffService;

	@Override
	public List<Attendance> viewEmployeeAttendance(int id) {
		List<Attendance> list= attendanceRepo.findByEmpId(id);
		return list;		
	}
	
	@Override
	public int viewLop(int id) {
		Optional<Employee> e = empRepo.findById(id);
		return e.get().getLop();
	}

	@Override
	public String applyForLeave(int employeeId, String date) {
		Attendance attendance = new Attendance();
		attendance.setEmpId(employeeId);
		attendance.setDate(date);
		attendance.setStatus("Leave");
		attendanceRepo.save(attendance);
		
		return "Leave Applied";
	}

	@Override
	public Employee employeeLogin(Login login) {
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = formatter.format(date);
		System.out.println(formattedDate);
		Optional<Employee> emp=empRepo.findByUserNameAndPassword(login.getUserName(), login.getPassword());
		if(emp.isPresent()) {
			Attendance attendance = new Attendance();
			attendance.setDate(formattedDate);
			attendance.setStatus("Present");
			attendance.setEmpId(emp.get().getId());
			staffService.updateEmployeeAttendance(attendance);
			return emp.get();
		}
		return emp.get();
	}
	
}
