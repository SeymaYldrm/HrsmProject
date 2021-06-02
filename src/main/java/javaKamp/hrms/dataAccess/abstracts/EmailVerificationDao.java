package javaKamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javaKamp.hrms.entities.concrete.EmailVerification;

public interface EmailVerificationDao extends JpaRepository<EmailVerification, Integer> {

	List<EmailVerification> findByUserId(Integer userId);
}
