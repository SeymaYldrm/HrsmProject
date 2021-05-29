package javaKamp.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaKamp.hrms.business.abstracts.StaffConfimsEmployersService;
import javaKamp.hrms.entities.concrete.StaffConfimsEmployer;

@RestController
@RequestMapping("/api/staffConfimsEmployers")
public class StaffConfimsEmployersController {
	private StaffConfimsEmployersService staffConfimsEmployersService;

	public List<StaffConfimsEmployer> getAll() {
		return this.staffConfimsEmployersService.getAll();
	}
}
