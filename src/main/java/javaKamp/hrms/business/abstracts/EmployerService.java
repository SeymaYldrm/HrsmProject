package javaKamp.hrms.business.abstracts;

import java.util.List;

import javaKamp.hrms.entities.concrete.Employer;

public interface EmployerService {
	List<Employer> getAll();

	Employer add(Employer employer);
}
