package javaKamp.hrms.business.abstracts;

import java.util.List;

import javaKamp.hrms.core.utilities.results.DataResult;
import javaKamp.hrms.entities.concrete.JobTitle;

public interface JobTitlesService {

	DataResult<JobTitle> add(JobTitle title);

	DataResult<List<JobTitle>> getAll();

	DataResult<List<JobTitle>> findById(int id);

	DataResult<List<JobTitle>> findJobTitles(String title);
}
