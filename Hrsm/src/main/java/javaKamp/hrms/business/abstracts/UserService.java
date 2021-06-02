package javaKamp.hrms.business.abstracts;

import java.util.List;

import javaKamp.hrms.core.utilities.results.DataResult;
import javaKamp.hrms.entities.concrete.User;

public interface UserService {

	User add(User user);

	DataResult<List<User>> getAll();
}
