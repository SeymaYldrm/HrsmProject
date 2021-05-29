package javaKamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javaKamp.hrms.entities.concrete.JobSeekerVerifacitionCode;

public interface JobSeekerVerifacitionCodesDao extends JpaRepository<JobSeekerVerifacitionCode, Integer>{

}
