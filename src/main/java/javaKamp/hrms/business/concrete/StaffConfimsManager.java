package javaKamp.hrms.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaKamp.hrms.business.abstracts.StaffConfimsService;
import javaKamp.hrms.dataAccess.abstracts.StaffConfimsDao;
import javaKamp.hrms.entities.concrete.StaffConfim;

@Service
public class StaffConfimsManager implements StaffConfimsService {

	private StaffConfimsDao staffConfimsDao;

	@Autowired
	public StaffConfimsManager(StaffConfimsDao staffConfimsDao) {
		super();
		this.staffConfimsDao = staffConfimsDao;
	}

	@Override
	public List<StaffConfim> getAll() {
		return this.staffConfimsDao.findAll();
	}

}
