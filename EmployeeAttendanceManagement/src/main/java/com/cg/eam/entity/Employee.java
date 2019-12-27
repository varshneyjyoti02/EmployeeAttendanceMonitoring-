package com.cg.eam.entity;

import java.util.Comparator;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee implements Comparable<Employee> {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String mobileNo;
	private int salary;
	private int lop;
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}



	public int getLop() {
		return lop;
	}

	public void setLop(int lop) {
		this.lop = lop;
	}
	
	public Employee() {
		super();
		
	}
	

	public Employee(int id, String name, String mobileNo, int salary, int lop) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNo = mobileNo;
		this.salary = salary;
		this.lop = lop;
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		 return this.getId().compareTo(o.getId());
	}
	
	 public static Comparator<Employee> EmpIdComparator = new Comparator<Employee>() {
		 @Override
		    public int compare(Employee o1, Employee o2) {
		        return o1.getId().compareTo(o2.getId());
		    }
	 };
	 
	 public static Comparator<Employee> EmpNameComparator = new Comparator<Employee>() {
		 @Override
		    public int compare(Employee o1, Employee o2) {
		        return o1.getName().compareTo(o2.getName());
		    }
	 };
	 
	 public static Comparator<Employee> EmpUserNameComparator = new Comparator<Employee>() {
		 @Override
		    public int compare(Employee o1, Employee o2) {
		        return o1.getUserName().compareTo(o2.getUserName());
		    }
	 };
	 
	 public static Comparator<Employee> EmpSalComparator = new Comparator<Employee>() {
		 @Override
		    public int compare(Employee o1, Employee o2) {
		        return o1.getSalary().compareTo(o2.getSalary());
		    }
	 };
}
