package javaKamp.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaKamp.hrms.entities.concrete.JobTitle;
import javaKamp.hrms.business.abstracts.JobTitlesService;

@RestController
@RequestMapping("/api/jobTitles")
public class JobTitlesController {
	private JobTitlesService JobTitlesService;

	public List<JobTitle> getAll() {
		return this.JobTitlesService.getAll();
	}
}
