package javaKamp.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javaKamp.hrms.business.abstracts.EmailVerificationService;
import javaKamp.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/verifacitionCodes")
public class EmailVerificationController {

	private EmailVerificationService emailVerificationService;

	@Autowired
	public EmailVerificationController(EmailVerificationService emailVerificationService) {
		super();
		this.emailVerificationService = emailVerificationService;
	}

	@PostMapping("/update/{verificationCode}/{id}")
	public Result setVerify(@RequestParam String verificationCode, @RequestParam Integer id) {
		return emailVerificationService.verify(verificationCode, id);
	}
}
