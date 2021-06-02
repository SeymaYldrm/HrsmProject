package javaKamp.hrms.business.abstracts;

import java.util.List;

import javaKamp.hrms.core.utilities.results.DataResult;
import javaKamp.hrms.entities.concrete.Staff;

public interface StaffService {

	DataResult<Staff> add(Staff staff);

	DataResult<List<Staff>> getAll();
}
