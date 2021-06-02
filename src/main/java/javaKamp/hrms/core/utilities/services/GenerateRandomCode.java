package javaKamp.hrms.core.utilities.services;

import java.util.Random;

public class GenerateRandomCode {
	public String create() {
		int leftLimit = 50;
		int rightLimit = 100;
		int targetStringLength = 20;
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		return generatedString;
	}
}
