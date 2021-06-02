package javaKamp.hrms.business.abstracts;

import javaKamp.hrms.core.utilities.results.Result;
import javaKamp.hrms.entities.concrete.EmailVerification;

public interface EmailVerificationService {

	void generateCode(EmailVerification code, Integer id);

	Result verify(String verificationCode, Integer id);
}
