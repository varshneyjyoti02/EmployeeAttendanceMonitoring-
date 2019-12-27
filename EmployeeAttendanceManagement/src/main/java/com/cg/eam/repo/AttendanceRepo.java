package com.cg.eam.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.eam.entity.Attendance;

public interface AttendanceRepo extends JpaRepository<Attendance, Integer>{
	
	public List<Attendance> findByEmpId(int id);
	
	public Optional<Attendance> findByDateAndEmpId(String date, int id);
	
	public List<Attendance> findByEmpIdAndStatus(int id,String status);

}
