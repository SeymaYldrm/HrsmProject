package javaKamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javaKamp.hrms.entities.concrete.Staff;

public interface StaffDao extends JpaRepository<Staff, Integer> {

}