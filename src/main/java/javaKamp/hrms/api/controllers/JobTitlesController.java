package javaKamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javaKamp.hrms.entities.concrete.JobTitle;
import javaKamp.hrms.business.abstracts.JobTitlesService;
import javaKamp.hrms.core.utilities.results.DataResult;

@RestController
@RequestMapping("/api/jobTitles")
public class JobTitlesController {
	private JobTitlesService jobTitlesService;

	@Autowired
	public JobTitlesController(JobTitlesService jobTitlesService) {
		super();
		this.jobTitlesService = jobTitlesService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobTitle>> getAll() {
		return jobTitlesService.getAll();
	}

	@RequestMapping(value = "findbyid/{id}", method = RequestMethod.GET)
	public DataResult<List<JobTitle>> findById(@PathVariable("id") Integer id) {
		return jobTitlesService.findById(id);
	}

	@RequestMapping(value = "findbytitle/{title}", method = RequestMethod.GET)
	public DataResult<List<JobTitle>> findByTitle(@PathVariable("title") String title) {
		return jobTitlesService.findJobTitles(title);
	}

	@PostMapping("/add")
	public DataResult<JobTitle> add(JobTitle title) {
		return this.jobTitlesService.add(title);
	}
}
