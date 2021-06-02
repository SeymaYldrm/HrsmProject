package javaKamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javaKamp.hrms.entities.concrete.Staff;

public interface StaffDao extends JpaRepository<Staff, Integer> {

	List<Staff> findAllByEmail(String email);
}
