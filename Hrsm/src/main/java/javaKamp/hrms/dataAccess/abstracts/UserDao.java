package javaKamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javaKamp.hrms.entities.concrete.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	List<User> findAllByEmail(String email);
}
