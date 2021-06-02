package javaKamp.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaKamp.hrms.business.abstracts.StaffConfimsService;
import javaKamp.hrms.entities.concrete.StaffConfim;

@RestController
@RequestMapping("/api/staffConfims")
public class StaffConfimsController {
	private StaffConfimsService staffConfimsService;

	public List<StaffConfim> getAll() {
		return this.staffConfimsService.getAll();
	}
}
