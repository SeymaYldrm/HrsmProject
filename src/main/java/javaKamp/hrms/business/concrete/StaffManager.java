package javaKamp.hrms.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaKamp.hrms.business.abstracts.StaffService;
import javaKamp.hrms.dataAccess.abstracts.StaffDao;
import javaKamp.hrms.entities.concrete.Staff;

@Service
public class StaffManager implements StaffService {

	private StaffDao staffDao;

	@Autowired
	public StaffManager(StaffDao staffDao) {
		super();
		this.staffDao = staffDao;
	}

	@Override
	public List<Staff> getAll() {
		return this.staffDao.findAll();
	}

}
