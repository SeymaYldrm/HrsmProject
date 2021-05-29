package javaKamp.hrms.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaKamp.hrms.business.abstracts.JobTitlesService;
import javaKamp.hrms.dataAccess.abstracts.JobTitlesDao;
import javaKamp.hrms.entities.concrete.JobTitle;

@Service
public class JobTitlesManager implements JobTitlesService {

	private JobTitlesDao jobTitlesDao;

	@Autowired
	public JobTitlesManager(JobTitlesDao jobTitlesDao) {
		super();
		this.jobTitlesDao = jobTitlesDao;
	}

	@Override
	public List<JobTitle> getAll() {
		return this.jobTitlesDao.findAll();
	}

}
