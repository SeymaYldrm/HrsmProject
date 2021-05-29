package javaKamp.hrms.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaKamp.hrms.business.abstracts.EmployersVerifacitionCodesService;
import javaKamp.hrms.dataAccess.abstracts.EmployersVerifacitionCodesDao;
import javaKamp.hrms.entities.concrete.EmployersVerifacitionCode;

@Service
public class EmployersVerifacitionCodesManager implements EmployersVerifacitionCodesService {
	private EmployersVerifacitionCodesDao employersVerifacitionCodesDao;

	@Autowired
	public EmployersVerifacitionCodesManager(EmployersVerifacitionCodesDao employersVerifacitionCodesDao) {
		super();
		this.employersVerifacitionCodesDao = employersVerifacitionCodesDao;
	}

	@Override
	public List<EmployersVerifacitionCode> getAll() {
		return this.employersVerifacitionCodesDao.findAll();
	}

}
