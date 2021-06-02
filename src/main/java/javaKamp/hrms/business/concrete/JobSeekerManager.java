package javaKamp.hrms.business.concrete;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaKamp.hrms.business.abstracts.EmailVerificationService;
import javaKamp.hrms.business.abstracts.JobSeekerService;
import javaKamp.hrms.business.abstracts.UserService;
import javaKamp.hrms.business.constants.Messages.Message;
import javaKamp.hrms.core.utilities.results.DataResult;
import javaKamp.hrms.core.utilities.results.ErrorDataResult;
import javaKamp.hrms.core.utilities.results.SuccessDataResult;
import javaKamp.hrms.core.utilities.services.IdentityValidation;
import javaKamp.hrms.dataAccess.abstracts.JobSeekerDao;
import javaKamp.hrms.entities.concrete.EmailVerification;
import javaKamp.hrms.entities.concrete.JobSeeker;
import javaKamp.hrms.entities.concrete.User;

@Service
public class JobSeekerManager implements JobSeekerService {
	private JobSeekerDao jobSeekerDao;
	private EmailVerificationService emailVerificationService;
	private UserService userService;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, EmailVerificationService emailVerificationService,
			UserService userService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.emailVerificationService = emailVerificationService;
		this.userService = userService;
	}

	@Override
	public DataResult<JobSeeker> add(JobSeeker jobSeeker) {
		if(!FirstNameChecker(jobSeeker)) {
			return new ErrorDataResult<JobSeeker>(null, Message.FirstNameChecker);
		}
		else if(!LastNameChecker(jobSeeker)) {
			return new ErrorDataResult<JobSeeker>(null, Message.LastNameChecker);
		}
		else if(!IdentityValidation.isRealPerson(jobSeeker.getIdentificationNumber())) {
			return new ErrorDataResult<JobSeeker>(null, Message.NotAuthenticate);
		}
		else if(jobSeeker.getIdentificationNumber().isBlank()) {
			return new ErrorDataResult<JobSeeker>(null, Message.InvalidIdentificationNumber);
		}
		else if(!BirthDateChecker(jobSeeker)) {
			return new ErrorDataResult<JobSeeker>(null, Message.ErrorBirthDateChecker);
		}
		else if(!EmailNullChecker(jobSeeker)) {
			return new ErrorDataResult<JobSeeker>(null, Message.EmailNullChecker);
		}
		else if(!IsRealEmail(jobSeeker)) {
			return new ErrorDataResult<JobSeeker>(null, Message.ErrorEmail);
		}
		else if(!PasswordNullChecker(jobSeeker)) {
			return new ErrorDataResult<JobSeeker>(null, Message.PasswordNullChecker);
		}
		else if(jobSeekerDao.findAllByEmail(jobSeeker.getEmail()).stream().count() != 0 ) {
			return new ErrorDataResult<JobSeeker>(null, Message.FindingAllByEmail);
		}
		else if(jobSeekerDao.findAllByIdentificationNumber(jobSeeker.getIdentificationNumber()).stream().count() != 0 ) {
			return new ErrorDataResult<JobSeeker>(null, Message.FindingAllByIdNumber);
		}
		
		User savedUser = this.userService.add(jobSeeker);
		this.emailVerificationService.generateCode(new EmailVerification(),savedUser.getId());
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.save(jobSeeker), Message.JobSeekerGenerateCode + jobSeeker.getId());
		
	}

	private boolean FirstNameChecker(JobSeeker jobSeeker) {
		if (jobSeeker.getFirstName().isBlank() || jobSeeker.getFirstName().equals(null)) {
			return false;
		}
		return true;
	}

	private boolean LastNameChecker(JobSeeker jobSeeker) {
		if (jobSeeker.getLastName().isBlank() || jobSeeker.getLastName().equals(null)) {
			return false;
		}
		return true;
	}

	private boolean BirthDateChecker(JobSeeker jobSeeker) {
		if (jobSeeker.getBirthDate().equals(null)) {
			return false;
		}
		return true;
	}

	private boolean EmailNullChecker(JobSeeker jobSeeker) {
		if (jobSeeker.getEmail().isBlank() || jobSeeker.getEmail().equals(null)) {
			return false;
		}
		return true;
	}

	private boolean PasswordNullChecker(JobSeeker jobSeeker) {
		if (jobSeeker.getPassword().isBlank() || jobSeeker.getPassword().equals(null)) {
			return false;
		}
		return true;
	}

	private boolean IsRealEmail(JobSeeker jobSeeker) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(jobSeeker.getEmail());
		if (!matcher.matches()) {
			return false;
		}
		return true;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), Message.JobSeekerSuccessAdd);
	}
}
