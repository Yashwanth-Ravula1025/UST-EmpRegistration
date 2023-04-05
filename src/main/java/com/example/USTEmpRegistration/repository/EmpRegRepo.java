package com.example.USTEmpRegistration.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.USTEmpRegistration.model.EmpReg;

@Repository

public interface EmpRegRepo extends JpaRepository<EmpReg,Integer> {
   
}
