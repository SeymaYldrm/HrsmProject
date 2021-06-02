package javaKamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javaKamp.hrms.entities.concrete.StaffConfim;

public interface StaffConfimsDao extends JpaRepository<StaffConfim, Integer> {

}
