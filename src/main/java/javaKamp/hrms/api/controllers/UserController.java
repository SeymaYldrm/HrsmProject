package javaKamp.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaKamp.hrms.business.abstracts.UserService;
import javaKamp.hrms.entities.concrete.User;

@RestController
@RequestMapping("/api/user")
public class UserController {
	private UserService userService;

	public List<User> getAll() {
		return this.userService.getAll();
	}
}
