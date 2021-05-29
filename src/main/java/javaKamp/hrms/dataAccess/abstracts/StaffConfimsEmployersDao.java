package javaKamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javaKamp.hrms.entities.concrete.StaffConfimsEmployer;

public interface StaffConfimsEmployersDao extends JpaRepository<StaffConfimsEmployer, Integer> {

}
