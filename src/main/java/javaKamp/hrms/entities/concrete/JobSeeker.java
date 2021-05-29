package javaKamp.hrms.entities.concrete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "jobSeeker")
@Data
public class JobSeeker {
	@Id
	@GeneratedValue
	@Column(name = "Id")
	private int Id;

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;

	@Column(name = "tc_no")
	private String tcNo;

	@Column(name = "date_time")
	private String dateTime;

	
	public JobSeeker() {

	}
}
