package com.cg.eam.repo;

import java.util.Optional
;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;

import com.cg.eam.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>{
	
	public Optional<Admin> findByUserNameAndPassword(String userName,String password);

}
