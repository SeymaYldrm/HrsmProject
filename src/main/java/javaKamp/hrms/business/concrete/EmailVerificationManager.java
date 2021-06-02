package javaKamp.hrms.business.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaKamp.hrms.business.abstracts.EmailVerificationService;
import javaKamp.hrms.business.constants.Messages.Message;
import javaKamp.hrms.core.utilities.results.ErrorDataResult;
import javaKamp.hrms.core.utilities.results.SuccessDataResult;
import javaKamp.hrms.core.utilities.services.GenerateRandomCode;
import javaKamp.hrms.dataAccess.abstracts.EmailVerificationDao;
import javaKamp.hrms.entities.concrete.EmailVerification;

@Service
public class EmailVerificationManager implements EmailVerificationService {

	private EmailVerificationDao emailVerificationDao;

	@Autowired
	public EmailVerificationManager(EmailVerificationDao emailVerificationDao) {
		super();
		this.emailVerificationDao = emailVerificationDao;
	}

	@Override
	public void generateCode(EmailVerification code, Integer id) {
		EmailVerification _code = code;
		_code.setCode(null);
		_code.setVerified(false);

		if (_code.isVerified() == false) {
			GenerateRandomCode generator = new GenerateRandomCode();
			String code_create = generator.create();
			_code.setCode(code_create);
			_code.setUserId(id);

			emailVerificationDao.save(_code);
		}
		return;
	}

	@Override
	public javaKamp.hrms.core.utilities.results.Result verify(String verificationCode, Integer id) {
		EmailVerification ref = emailVerificationDao.findByUserId(id).stream().findFirst().get();
		if (ref.getCode().equals(verificationCode) && ref.isVerified() != true) {
			ref.setVerified(true);
			return new SuccessDataResult<EmailVerification>(this.emailVerificationDao.save(ref), Message.Success);
		} else if (ref.isVerified() == true) {
			return new ErrorDataResult<EmailVerification>(null, Message.ExistingAccount);
		}
		return new ErrorDataResult<EmailVerification>(null, Message.InvalidCode);
	}

}
