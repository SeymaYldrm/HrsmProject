package javaKamp.hrms.business.abstracts;

import java.util.List;

import javaKamp.hrms.entities.concrete.User;

public interface UserService {
	List<User> getAll();
}
