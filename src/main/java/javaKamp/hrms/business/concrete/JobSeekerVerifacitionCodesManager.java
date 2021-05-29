package javaKamp.hrms.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaKamp.hrms.business.abstracts.JobSeekerVerifacitionCodesService;
import javaKamp.hrms.dataAccess.abstracts.JobSeekerVerifacitionCodesDao;
import javaKamp.hrms.entities.concrete.JobSeekerVerifacitionCode;

@Service
public class JobSeekerVerifacitionCodesManager implements JobSeekerVerifacitionCodesService {

	private JobSeekerVerifacitionCodesDao jobSeekerVerifacitionCodesDao;

	@Autowired
	public JobSeekerVerifacitionCodesManager(JobSeekerVerifacitionCodesDao jobSeekerVerifacitionCodesDao) {
		super();
		this.jobSeekerVerifacitionCodesDao = jobSeekerVerifacitionCodesDao;
	}

	@Override
	public List<JobSeekerVerifacitionCode> getAll() {
		return this.jobSeekerVerifacitionCodesDao.findAll();
	}

}
