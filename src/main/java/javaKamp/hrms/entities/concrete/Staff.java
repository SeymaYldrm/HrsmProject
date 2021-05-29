package javaKamp.hrms.entities.concrete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "staff")
@Data
public class Staff {
	@Id
	@GeneratedValue
	@Column(name = "Id")
	private int Id;

	@Column(name = "firs_name")
	private String firsName;

	@Column(name = "last_name")
	private String lastName;

	public Staff() {

	}
}
