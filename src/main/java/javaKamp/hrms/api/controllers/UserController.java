package javaKamp.hrms.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javaKamp.hrms.business.abstracts.UserService;
import javaKamp.hrms.core.utilities.results.DataResult;
import javaKamp.hrms.entities.concrete.User;

@RestController
@RequestMapping("/api/user")
public class UserController {
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/getall")
	@ResponseBody
	public DataResult<List<User>> getAll() {
		return this.userService.getAll();
	}
	
	
	@PostMapping(value = "/add")
	public User add(@RequestBody User user) {
		return this.userService.add(user);
	}
}
