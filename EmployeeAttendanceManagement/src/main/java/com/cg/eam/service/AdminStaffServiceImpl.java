package com.cg.eam.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.eam.entity.Attendance;
import com.cg.eam.entity.Employee;
import com.cg.eam.repo.AttendanceRepo;
import com.cg.eam.repo.EmployeeRepo;

@Service
@Transactional
public class AdminStaffServiceImpl implements AdminStaffService {
	@Autowired
	private AttendanceRepo repo;

	@Autowired
	private EmployeeRepo empRepo;

	@Override
	public int calculateLop(int id) {
		//int count = repo.findByEmpIdAndStatus(id, null).size();
		int countOfLeavesApplied = (repo.findByEmpIdAndStatus(id, "Leave").size())+ (repo.findByEmpIdAndStatus(id, "").size());
		int countOfPresent =(repo.findByEmpIdAndStatus(id, "Present").size());
		System.out.println(countOfLeavesApplied);
		System.out.println(countOfPresent);
		int totalCount = 30-countOfLeavesApplied ;
		int totalCount1 = countOfLeavesApplied ;
		System.out.println(totalCount1);
//		if(totalCount>8) {
		Optional<Employee> e = empRepo.findById(id); 
//			int LOP= e.get().getSalary()-((e.get().getSalary()/30)/totalCount-8);
//			return LOP;
//		
		int oneDaySalary = (e.get().getSalary() / 30);
		System.out.println(oneDaySalary);
		// int LOP = e.get().getSalary() - (oneDaySalary * totalCount);
		int LOP =(oneDaySalary * totalCount1);
		e.get().setLop(LOP);
		System.out.println(LOP);
		return LOP;
	}

//	@Override
//	public int calculateLop1(int id) {
//		int countOfLeavesApplied = repo.findByEmpIdAndStatus(id, "Leave").size();
//		int countOfAbsent = repo.findByEmpIdAndStatus(id, "").size();
//		int totalCount = 30-countOfLeavesApplied-countOfAbsent;
//		Optional<Employee> e = empRepo.findById(id); 
//		int oneDaySal = e.get().getSalary()/30 ;
//		int Lop= oneDaySal * totalCount;
//		//int lop1 =e.get().getSalary() - 
//		
//		e.get().setLop(Lop);
//		return 0;
//	}

	
	
//	@Override
//	public void updateEmployeeAttendance(Attendance attendance) {
//
//		if (repo.findByDateAndEmpId(attendance.getDate(), attendance.getEmpId()).isPresent()) {
//			System.out.println("Already came");
//		} else {
//			repo.save(attendance);
//			System.out.println("saved");
//		}
//	}

	@Override
	public String updateEmployeeAttendance(Attendance attendance) {

		if (repo.findByDateAndEmpId(attendance.getDate(), attendance.getEmpId()).isPresent()) {
			System.out.println("Already came");
		} else {
			repo.save(attendance);
			System.out.println("saved");
		}
		return "Updated";
	}
	@Override
	public List<Attendance> employeeAttendance(int id) {
		List<Attendance> list = repo.findByEmpId(id);
		System.out.println(list);
		return list;
	}

	
}
