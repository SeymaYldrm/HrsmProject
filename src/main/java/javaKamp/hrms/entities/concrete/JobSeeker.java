package javaKamp.hrms.entities.concrete;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "job_seeker")
public class JobSeeker extends User {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "identity_number")
	private String identificationNumber;

	@Column(name = "birth_date")
	private Date birthDate;
}
