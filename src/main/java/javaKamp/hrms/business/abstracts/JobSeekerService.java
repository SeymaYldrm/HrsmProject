package javaKamp.hrms.business.abstracts;

import java.util.List;

import javaKamp.hrms.entities.concrete.JobSeeker;

public interface JobSeekerService {
	List<JobSeeker> getAll();
}
