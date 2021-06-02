package javaKamp.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaKamp.hrms.business.abstracts.EmployersVerifacitionCodesService;
import javaKamp.hrms.entities.concrete.EmployersVerifacitionCode;

@RestController
@RequestMapping("/api/employersVerifacitionCodes")
public class EmployersVerifacitionCodesController {

	private EmployersVerifacitionCodesService employersVerifacitionCodesService;

	@GetMapping("/getall")
	public List<EmployersVerifacitionCode> getAll() {
		return this.employersVerifacitionCodesService.getAll();
	}
}
