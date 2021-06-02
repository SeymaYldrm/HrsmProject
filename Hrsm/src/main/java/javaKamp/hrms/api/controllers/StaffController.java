package javaKamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaKamp.hrms.business.abstracts.StaffService;
import javaKamp.hrms.core.utilities.results.DataResult;
import javaKamp.hrms.entities.concrete.Staff;

@RestController
@RequestMapping("/api/staff")
public class StaffController {
	private StaffService staffService;

	@Autowired
	public StaffController(StaffService staffService) {
		super();
		this.staffService = staffService;
	}

	public DataResult<List<Staff>> getAll() {
		return this.staffService.getAll();
	}

	@PostMapping("/add")
	public DataResult<Staff> add(Staff staff) {
		return this.staffService.add(staff);
	}
}
