package com.example.USTEmpRegistration.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.USTEmpRegistration.model.EmpReg;
import com.example.USTEmpRegistration.service.EmpRegService;


@RestController
@RequestMapping("/registration")
@CrossOrigin("*")
public class EmpRegController {
	
	@Autowired
	private EmpRegService empService;
	
	@PostMapping("/addemps")
	public EmpReg addemp(@RequestBody EmpReg employee) {
		return empService.createEmployee(employee);
	}
	@GetMapping ("/employees")
	public List<EmpReg> getAllEmployee(){
		return empService.getEmployees();
		
	}
	@GetMapping ("/employees/{id}")
	public EmpReg getEmployeeById(@PathVariable int id){
		return empService.getEmployeeById(id);
		
	}
	@PutMapping("/updateemployee/{id}")
	public EmpReg updateEmployee(@RequestBody EmpReg employee) {
		return empService.updateEmployee(employee);
		
	}
	@DeleteMapping("/deleteemployee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return empService.deleteEmployeeById(id);
		
	}
	

}
