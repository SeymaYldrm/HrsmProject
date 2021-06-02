package javaKamp.hrms.entities.concrete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "staff_confims_employers")
@Data
public class StaffConfimsEmployer {
	@Id
	@GeneratedValue
	@Column(name = "Id")
	private int Id;

	@Column(name = "employer_Id")
	private String employerId;

	public StaffConfimsEmployer() {

	}
}
