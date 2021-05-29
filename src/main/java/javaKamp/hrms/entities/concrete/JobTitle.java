package javaKamp.hrms.entities.concrete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "job_titles")
@Data
public class JobTitle {
	@Id
	@GeneratedValue
	@Column(name = "Id")
	private int Id;

	@Column(name = "job_seeker_Id")
	private int jobSeekerId;

	public JobTitle() {

	}
}
