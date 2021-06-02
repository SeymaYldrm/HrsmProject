package javaKamp.hrms.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaKamp.hrms.business.abstracts.UserService;
import javaKamp.hrms.business.constants.Messages.Message;
import javaKamp.hrms.core.utilities.results.DataResult;
import javaKamp.hrms.core.utilities.results.SuccessDataResult;
import javaKamp.hrms.dataAccess.abstracts.UserDao;
import javaKamp.hrms.entities.concrete.User;

@Service
public class UserManager implements UserService {

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(userDao.findAll(), Message.UserSuccessList);
	}

	@Override
	public User add(User user) {
		return userDao.save(user);
	}
}
