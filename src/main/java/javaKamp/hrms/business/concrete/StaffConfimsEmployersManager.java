package javaKamp.hrms.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaKamp.hrms.business.abstracts.StaffConfimsEmployersService;
import javaKamp.hrms.dataAccess.abstracts.StaffConfimsEmployersDao;
import javaKamp.hrms.entities.concrete.StaffConfimsEmployer;

@Service
public class StaffConfimsEmployersManager implements StaffConfimsEmployersService {

	private StaffConfimsEmployersDao staffConfimsEmployersDao;

	@Autowired
	public StaffConfimsEmployersManager(StaffConfimsEmployersDao staffConfimsEmployersDao) {
		super();
		this.staffConfimsEmployersDao = staffConfimsEmployersDao;
	}

	@Override
	public List<StaffConfimsEmployer> getAll() {
		return this.staffConfimsEmployersDao.findAll();
	}

}
