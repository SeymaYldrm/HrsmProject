package javaKamp.hrms.business.abstracts;

import java.util.List;

import javaKamp.hrms.entities.concrete.Staff;

public interface StaffService {
	List<Staff> getAll();
}
