package javaKamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaKamp.hrms.business.abstracts.JobSeekerService;
import javaKamp.hrms.core.utilities.results.DataResult;
import javaKamp.hrms.entities.concrete.JobSeeker;

@RestController
@RequestMapping("/api/jobSeeker")
public class JobSeekerController {

	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekerController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll() {
		return this.jobSeekerService.getAll();
	}

	@PostMapping("/add")
	public DataResult<JobSeeker> add(JobSeeker jobSeeker) {
		return this.jobSeekerService.add(jobSeeker);
	}
}
