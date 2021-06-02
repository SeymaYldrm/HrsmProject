package javaKamp.hrms.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaKamp.hrms.business.abstracts.VerifacitionCodesService;
import javaKamp.hrms.dataAccess.abstracts.VerifacitionCodesDao;
import javaKamp.hrms.entities.concrete.VerificitionCode;

@Service
public class VerifacitionCodesManager implements VerifacitionCodesService {

	private VerifacitionCodesDao verifacitionCodesDao;

	@Autowired
	public VerifacitionCodesManager(VerifacitionCodesDao verifacitionCodesDao) {
		super();
		this.verifacitionCodesDao = verifacitionCodesDao;
	}

	@Override
	public List<VerificitionCode> getAll() {
		return this.verifacitionCodesDao.findAll();
	}

}
