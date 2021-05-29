package javaKamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javaKamp.hrms.entities.concrete.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

}
