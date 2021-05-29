package javaKamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javaKamp.hrms.entities.concrete.JobTitle;

public interface JobTitlesDao extends JpaRepository<JobTitle, Integer> {

}
