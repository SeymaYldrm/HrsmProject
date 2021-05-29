package javaKamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javaKamp.hrms.entities.concrete.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {

}
