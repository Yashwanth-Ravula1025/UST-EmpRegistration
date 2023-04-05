package com.example.USTEmpRegistration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.USTEmpRegistration.model.EmpReg;
import com.example.USTEmpRegistration.repository.EmpRegRepo;
import org.springframework.stereotype.Service;

@Service
public class EmpRegService {
	
	@Autowired
	private EmpRegRepo repo;

	public EmpReg createEmployee(EmpReg employee) {
		
		return repo.save(employee);
	}

	public List<EmpReg> getEmployees() {
		
		return repo.findAll();
	}

	public EmpReg getEmployeeById(int id) {
		
		return repo.findById(id).orElse(null);
	}

	public EmpReg updateEmployee(EmpReg employee) {
		EmpReg oldemp=null;
		Optional<EmpReg>optionalemployee=repo.findById(employee.getId());
		if (optionalemployee.isPresent()) {
			oldemp=optionalemployee.get();
			oldemp.setId(employee.getId());
		    oldemp.setName(employee.getName());
		    oldemp.setEmail(employee.getEmail());
		    oldemp.setExperience(employee.getExperience());
		    oldemp.setDomain(employee.getDomain());
		    repo.save(oldemp);
		}else {
			return new EmpReg();
		}
		return oldemp;
	}

	public String deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return "it was deleted";
	}
}

