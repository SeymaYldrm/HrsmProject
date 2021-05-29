package javaKamp.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaKamp.hrms.business.abstracts.StaffService;
import javaKamp.hrms.entities.concrete.Staff;

@RestController
@RequestMapping("/api/staff")
public class StaffController {
	private StaffService staffService;

	public List<Staff> getAll() {
		return this.staffService.getAll();
	}
}
