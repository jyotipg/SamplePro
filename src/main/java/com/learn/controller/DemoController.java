package com.learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.dto.Employee;
import com.learn.service.DemoService;

@RestController
@RequestMapping("/app")
public class DemoController {

	@Autowired
	DemoService demoService;
	@GetMapping("/employees")
	public  ResponseEntity<List<Employee>> getEmployeeFromController(@RequestHeader(value="Authorization", required = false) String auth)
	{
		return new ResponseEntity<>(demoService.getEmployeeFromService(), HttpStatus.OK);
	}

	@GetMapping("/request")
	public  ResponseEntity<String> getEmployeeNameFromController(@RequestHeader(value="Authorization", required = false) String auth)
	{
		return new ResponseEntity<>(demoService.getEmployeeFromService().get(0).getEmpName(), HttpStatus.OK);
	}
	
	
	@PostMapping("/employee")
	public ResponseEntity<String> postEmployeeFromController(@RequestHeader(value="Authorization", required = false) String auth,@RequestBody Employee employee)
	{
		demoService.addEmployee(employee);
		return new ResponseEntity<>("Data is Succesfully Saved", HttpStatus.CREATED);
	}
	@GetMapping("/employee/{employeeNo}")
	public  ResponseEntity<Employee> getSingleEmployeeFromController(@RequestHeader(value="Authorization", required = false) String auth,@PathVariable("employeeNo") int employeeNo)
	{
		return new ResponseEntity<>(demoService.getSingleEmployeeFromService(employeeNo), HttpStatus.OK);
	}
	@PutMapping("/employee/{employeeNo}")
	public  ResponseEntity<String> updateSingleEmployeeFromController(@RequestHeader(value="Authorization", required = false) String auth,@PathVariable("employeeNo") int employeeNo,@RequestBody Employee employee)
	{
		demoService.putSingleEmployeeFromService(employeeNo,employee);
		return new ResponseEntity<>("Data is Succesfully Updated", HttpStatus.ACCEPTED);
	}	
	
	@DeleteMapping("/employee/{employeeNo}")
	public  ResponseEntity<String> deleteSingleEmployeeFromController(@RequestHeader(value="Authorization", required = false) String auth,@PathVariable("employeeNo") int employeeNo)
	{
		demoService.deleteSingleEmployeeFromService(employeeNo);		
		return new ResponseEntity<>("Employee ".concat(String.valueOf(employeeNo).concat(" Successfully deleted")), HttpStatus.OK);
	}
	
	@DeleteMapping("/employees")
	public ResponseEntity<String> deleteAllEmployeeFromController(@RequestHeader(value="Authorization", required = false) String auth)
	{
		demoService.deleteAllEmployeeFromService();
		return new ResponseEntity<>("All Employee Data is Succesfully Deleted", HttpStatus.OK);
	}
}
