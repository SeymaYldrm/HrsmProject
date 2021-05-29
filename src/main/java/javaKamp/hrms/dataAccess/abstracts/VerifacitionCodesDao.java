package javaKamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javaKamp.hrms.entities.concrete.VerificitionCode;

public interface VerifacitionCodesDao extends JpaRepository<VerificitionCode, Integer> {

}
