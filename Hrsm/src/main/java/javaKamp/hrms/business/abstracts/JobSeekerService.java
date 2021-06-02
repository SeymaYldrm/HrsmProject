package javaKamp.hrms.business.abstracts;

import java.util.List;

import javaKamp.hrms.core.utilities.results.DataResult;
import javaKamp.hrms.entities.concrete.JobSeeker;

public interface JobSeekerService {

	DataResult<JobSeeker> add(JobSeeker jobSeeker);

	DataResult<List<JobSeeker>> getAll();
}
