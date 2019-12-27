package com.cg.eam.service;

import java.util.List;

import com.cg.eam.entity.Attendance;

public interface AdminStaffService {

//	public void updateEmployeeAttendance(String date,String status,int id);
	public String updateEmployeeAttendance(Attendance attendance);
	public int calculateLop(int id);
//	public int calculateLop1(int id);
	public List<Attendance> employeeAttendance(int id);

}
