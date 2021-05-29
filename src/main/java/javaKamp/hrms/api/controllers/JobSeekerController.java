package javaKamp.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaKamp.hrms.business.abstracts.JobSeekerService;
import javaKamp.hrms.entities.concrete.JobSeeker;

@RestController
@RequestMapping("/api/jobSeeker")
public class JobSeekerController {

	private JobSeekerService jobSeekerService;

	@GetMapping("/getall")
	public List<JobSeeker> getAll() {
		return this.jobSeekerService.getAll();
	}
}
