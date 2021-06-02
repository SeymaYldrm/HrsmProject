package javaKamp.hrms.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaKamp.hrms.business.abstracts.JobTitlesService;
import javaKamp.hrms.business.constants.Messages.Message;
import javaKamp.hrms.core.utilities.results.DataResult;
import javaKamp.hrms.core.utilities.results.ErrorDataResult;
import javaKamp.hrms.core.utilities.results.SuccessDataResult;
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
	public DataResult<JobTitle> add(JobTitle title) {
		if (jobTitlesDao.findAllByTitle(title.getTitle()).stream().count() != 0) {
			return new ErrorDataResult<JobTitle>(null, Message.ExistingJob);
		}
		return new SuccessDataResult<JobTitle>(jobTitlesDao.save(title), Message.JobSuccessAdd);
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(jobTitlesDao.findAll(), Message.SuccessList);
	}

	@Override
	public DataResult<List<JobTitle>> findById(int id) {
		return new SuccessDataResult<List<JobTitle>>(jobTitlesDao.findById(id), Message.SuccessList);
	}

	@Override
	public DataResult<List<JobTitle>> findJobTitles(String title) {
		return new SuccessDataResult<List<JobTitle>>(jobTitlesDao.findJobTitles(title), Message.Success);
	}
}
