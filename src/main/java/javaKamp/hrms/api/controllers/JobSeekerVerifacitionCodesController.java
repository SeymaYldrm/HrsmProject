package javaKamp.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaKamp.hrms.business.abstracts.JobSeekerVerifacitionCodesService;
import javaKamp.hrms.entities.concrete.JobSeekerVerifacitionCode;

@RestController
@RequestMapping("/api/jobSeekerVerifacitionCodes")
public class JobSeekerVerifacitionCodesController {

	private JobSeekerVerifacitionCodesService jobSeekerVerifacitionCodesService;

	@GetMapping("/getall")
	public List<JobSeekerVerifacitionCode> getAll() {
		return this.jobSeekerVerifacitionCodesService.getAll();
	}
}
