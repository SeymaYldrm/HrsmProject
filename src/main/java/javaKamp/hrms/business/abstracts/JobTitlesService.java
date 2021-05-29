package javaKamp.hrms.business.abstracts;

import java.util.List;

import javaKamp.hrms.entities.concrete.JobTitle;

public interface JobTitlesService {
	List<JobTitle> getAll();
}
