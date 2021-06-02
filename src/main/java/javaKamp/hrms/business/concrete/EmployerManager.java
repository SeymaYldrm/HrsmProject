package javaKamp.hrms.business.concrete;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaKamp.hrms.business.abstracts.EmailVerificationService;
import javaKamp.hrms.business.abstracts.EmployerService;
import javaKamp.hrms.business.abstracts.UserService;
import javaKamp.hrms.business.constants.Messages.Message;
import javaKamp.hrms.core.utilities.results.DataResult;
import javaKamp.hrms.core.utilities.results.ErrorDataResult;
import javaKamp.hrms.core.utilities.results.SuccessDataResult;
import javaKamp.hrms.dataAccess.abstracts.EmployerDao;
import javaKamp.hrms.entities.concrete.EmailVerification;
import javaKamp.hrms.entities.concrete.Employer;
import javaKamp.hrms.entities.concrete.User;

@Service
public class EmployerManager implements EmployerService {
	private EmployerDao employerDao;
	private EmailVerificationService emailVerificationService;
	private UserService userService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailVerificationService emailVerificationService,
			UserService userService) {
		super();
		this.employerDao = employerDao;
		this.emailVerificationService = emailVerificationService;
		this.userService = userService;
	}

	@Override
	public DataResult<Employer> add(Employer employer) {
		if (!companyNameChecker(employer)) {
			return new ErrorDataResult<Employer>(null, Message.CompanyNameChecker);
		} 
		else if (!webSiteChecker(employer)) {
			return new ErrorDataResult<Employer>(null, Message.WebSiteChecker);
		} 
		else if (!isRealEmployer(employer)) {
			return new ErrorDataResult<Employer>(null, Message.InvalidEmail);
		} 
		else if (!passwordNullChecker(employer)) {
			return new ErrorDataResult<Employer>(null, Message.PasswordNullChecker);
		} 
		else if (!isRealPhoneNumber(employer)) {
			return new ErrorDataResult<Employer>(null, Message.IsRealPhoneNumber);
		} 
		else if (!isEmailAlreadyRegistered(employer)) {
			return new ErrorDataResult<Employer>(null, Message.IsEmailAlreadyRegistered);
		};

		User savedUser = this.userService.add(employer);
		this.emailVerificationService.generateCode(new EmailVerification(), savedUser.getId());
		return new SuccessDataResult<Employer>(this.employerDao.save(employer),
				Message.EmployerSuccessAdd + employer.getId());
	}

	private boolean companyNameChecker(Employer employer) {
		if (employer.getCompanyName().isBlank() || employer.getCompanyName() == null) {
			return false;
		}
		return true;
	}

	private boolean webSiteChecker(Employer employer) {
		if (employer.getWebAddress().isBlank() || employer.getWebAddress() == null) {
			return false;
		}
		return true;
	}

	private boolean isRealEmployer(Employer employer) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(employer.getEmail());
		if (!matcher.matches()) {
			return false;
		} else if (!employer.getEmail().contains(employer.getWebAddress())) {
			return false;
		}
		return true;
	}

	private boolean isEmailAlreadyRegistered(Employer employer) {
		if (employerDao.findAllByEmail(employer.getEmail()).stream().count() != 0) {
			return false;
		}
		return true;
	}

	private boolean passwordNullChecker(Employer employer) {
		if (employer.getPassword().isBlank() || employer.getPassword() == null) {
			return false;
		}
		return true;
	}

	private boolean isRealPhoneNumber(Employer employer) {
		String patterns = "(\\d-)?(\\d{3}-)?\\d{3}-\\d{4}";
				//"^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
				//+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
				//+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";

		Pattern pattern = Pattern.compile(patterns);
		Matcher matcher = pattern.matcher(employer.getPhoneNumber());

		if (!matcher.matches()) {
			return false;
		}
		return true;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), Message.EmployerSuccessList);
	}
}
