package javaKamp.hrms.core.utilities.services;

import javaKamp.hrms.core.utilities.validation.FakeMernis;

public class IdentityValidation {

	public static boolean isRealPerson(String tcNo) {
		FakeMernis mernis = new FakeMernis();
		return mernis.validate(tcNo);
	}
}
