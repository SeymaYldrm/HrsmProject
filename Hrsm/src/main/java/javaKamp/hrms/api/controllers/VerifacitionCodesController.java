package javaKamp.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaKamp.hrms.business.abstracts.VerifacitionCodesService;
import javaKamp.hrms.entities.concrete.VerificitionCode;

@RestController
@RequestMapping("/api/verifacitionCodes")
public class VerifacitionCodesController {
	private VerifacitionCodesService verifacitionCodesService;

	public List<VerificitionCode> getAll() {
		return this.verifacitionCodesService.getAll();
	}
}
