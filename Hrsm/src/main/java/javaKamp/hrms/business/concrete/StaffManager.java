package javaKamp.hrms.business.concrete;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaKamp.hrms.business.abstracts.EmailVerificationService;
import javaKamp.hrms.business.abstracts.StaffService;
import javaKamp.hrms.business.abstracts.UserService;
import javaKamp.hrms.business.constants.Messages.Message;
import javaKamp.hrms.core.utilities.results.DataResult;
import javaKamp.hrms.core.utilities.results.ErrorDataResult;
import javaKamp.hrms.core.utilities.results.SuccessDataResult;
import javaKamp.hrms.dataAccess.abstracts.StaffDao;
import javaKamp.hrms.entities.concrete.EmailVerification;
import javaKamp.hrms.entities.concrete.Staff;
import javaKamp.hrms.entities.concrete.User;

@Service
public class StaffManager implements StaffService {

	private StaffDao staffDao;
	private UserService userService;
	private EmailVerificationService emailVerificationService;

	@Autowired
	public StaffManager(StaffDao staffDao, UserService userService, EmailVerificationService emailVerificationService) {
		super();
		this.staffDao = staffDao;
		this.emailVerificationService = emailVerificationService;
		this.userService = userService;
	}

	@Override
	public DataResult<Staff> add(Staff staff) {
		if (!FirstNameChecker(staff)) {
			return new ErrorDataResult<Staff>(null, Message.FirstNameChecker);
		} 
		else if (!LastNameChecker(staff)) {
			return new ErrorDataResult<Staff>(null, Message.LastNameChecker);
		} 
		else if (!EmailNullChecker(staff)) {
			return new ErrorDataResult<Staff>(null, Message.EmailNullChecker);
		} 
		else if (!IsRealEmail(staff)) {
			return new ErrorDataResult<Staff>(null, Message.ErrorEmail);
		}
		else if (!PasswordNullChecker(staff)) {
			return new ErrorDataResult<Staff>(null, Message.PasswordNullChecker);
		}
		else if (staffDao.findAllByEmail(staff.getEmail()).stream().count() != 0) {
			return new ErrorDataResult<Staff>(null, Message.IsEmailAlreadyRegistered);
		}

		User savedUser = this.userService.add(staff);
		this.emailVerificationService.generateCode(new EmailVerification(), savedUser.getId());
		return new SuccessDataResult<Staff>(staffDao.save(staff), Message.StaffGenerateCode + staff.getId());
	}

	private boolean FirstNameChecker(Staff staff) {
		if (staff.getFirstName().isBlank() || staff.getFirstName().equals(null)) {
			return false;
		}
		return true;
	}

	private boolean LastNameChecker(Staff staff) {
		if (staff.getLastName().isBlank() || staff.getLastName().equals(null)) {
			return false;
		}
		return true;
	}

	private boolean EmailNullChecker(Staff staff) {
		if (staff.getEmail().isBlank() || staff.getEmail().equals(null)) {
			return false;
		}
		return true;
	}

	private boolean PasswordNullChecker(Staff staff) {
		if (staff.getPassword().isBlank() || staff.getPassword().equals(null)) {
			return false;
		}
		return true;
	}

	private boolean IsRealEmail(Staff staff) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(staff.getEmail());
		if (!matcher.matches()) {
			return false;
		}
		return true;

	}

	@Override
	public DataResult<List<Staff>> getAll() {
		return new SuccessDataResult<List<Staff>>(staffDao.findAll(), Message.SuccessStaffAdd);
	}
}
