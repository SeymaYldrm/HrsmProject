package javaKamp.hrms.business.abstracts;

import java.util.List;

import javaKamp.hrms.core.utilities.results.DataResult;
import javaKamp.hrms.entities.concrete.Employer;

public interface EmployerService {

	DataResult<Employer> add(Employer employer);

	DataResult<List<Employer>> getAll();
}
