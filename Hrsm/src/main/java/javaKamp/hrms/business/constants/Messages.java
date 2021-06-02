package javaKamp.hrms.business.constants;

public class Messages {

	public static class Message {

		// General
		public static String Success = "Success";
		public static String SuccessList = "Successfully listed";
		public static String ExistingAccount = "This account has already been verified!";
		public static String InvalidCode = "Invalid verification code!";
		public static String InvalidEmail = "Invalid email address!";
		public static String EmailNullChecker = "Email address is mandatory!";
		public static String IsEmailAlreadyRegistered = "This email address is already registered!";
		public static String ErrorEmail = "Email address entered incorrectly!";
		public static String PasswordNullChecker = "Password is mandatory!";
		public static String FirstNameChecker = "First name is mandatory!";
		public static String LastNameChecker = "Last name is mandatory!";

		// Checker
		public static String CompanyNameChecker = "Company name is mandatory!";
		public static String WebSiteChecker = "Website address is mandatory!";
		public static String IsRealPhoneNumber = "Invalid phone number!";

		// Employer
		public static String EmployerSuccessAdd = "Employer account added, verification code has been sent :";
		public static String EmployerSuccessList = "Employers have been successfully listed!";

		// User
		public static String UserSuccessList = "Users successfully listed.";

		// JobSeeker
		public static String NotAuthenticate = "Could Not Authenticate!";
		public static String InvalidIdentificationNumber = "Identity Information cannot be left blank!";
		public static String ErrorBirthDateChecker = "Date of birth is mandatory!";
		public static String FindingAllByEmail = "This email is already registered!";
		public static String FindingAllByIdNumber = "This identification number is already registered!";
		public static String JobSeekerGenerateCode = "Job seeker account added, verification code has been sent : ";
		public static String JobSeekerSuccessAdd = "Job seekers successfully added";

		// JobTitle
		public static String ExistingJob = "This job position has already been added!";
		public static String JobSuccessAdd = "Job position successfully added!";

		// Staff
		public static String SuccessStaffAdd = "Staff successfully added!";
		public static String StaffGenerateCode = "Staff account added, verification code has been sent : ";
	}
}
