package javaKamp.hrms.entities.concrete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "User")
@Data
public class User {
	@Id
	@GeneratedValue
	@Column(name = "Id")
	private int Id;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;


	public User() {

	}
}
