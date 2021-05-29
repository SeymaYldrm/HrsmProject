package javaKamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javaKamp.hrms.entities.concrete.EmployersVerifacitionCode;

public interface EmployersVerifacitionCodesDao  extends JpaRepository<EmployersVerifacitionCode, Integer>{

}
