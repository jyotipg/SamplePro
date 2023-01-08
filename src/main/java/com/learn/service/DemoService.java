package com.learn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.learn.dto.Employee;

@Service
public class DemoService {

	List<Employee> empData=new ArrayList<Employee>();
	
	@PostConstruct
	public void init()
	{
		empData.add(new Employee(1,"Employee1"));
		empData.add(new Employee(2,"Employee2"));
		empData.add(new Employee(3,"Employee3"));
		empData.add(new Employee(4,"Employee4"));
		empData.add(new Employee(5,"Employee5"));
		empData.add(new Employee(6,"Employee6"));
		empData.add(new Employee(7,"Employee7"));
		empData.add(new Employee(8,"Employee8"));
		empData.add(new Employee(9,"Employee9"));
		empData.add(new Employee(10,"Employee10"));
	}
	public List<Employee> getEmployeeFromService()
	{
		return this.empData;
	}
	public void  addEmployee(Employee emp)
	{
		this.empData.add(emp);
	}
	public Employee getSingleEmployeeFromService(int employeeNo)
	{
		Optional<Employee> e=empData.stream().filter(emp->emp.getEmpNo()==employeeNo).findFirst();
		return e.isPresent() ?e.get():null;		
	
	}
	
	public void putSingleEmployeeFromService(int employeeNo,Employee employee)
	{
		 empData.stream().filter(emp->emp.getEmpNo()==employeeNo).findFirst()
		 .ifPresent(e->{
			 e.setEmpName(employee.getEmpName());
			 
		 });
			 
	}	
	
	public void deleteSingleEmployeeFromService(int employeeNo)
	{
		 empData.removeIf(emp->emp.getEmpNo()==employeeNo);
			 
	}	
	
	public void deleteAllEmployeeFromService()
	{
		 empData.clear();
			 
	}	
}
