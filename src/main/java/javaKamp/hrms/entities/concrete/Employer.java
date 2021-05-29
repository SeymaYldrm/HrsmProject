package javaKamp.hrms.entities.concrete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "employers")
@Data
public class Employer {
	@Id
	@GeneratedValue
	@Column(name = "Id")
	private int Id;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "email")
	private String email;

	@Column(name = "tel_no")
	private String telNo;

	@Column(name = "address")
	private String address;

	@Column(name = "web_site")
	private String webSite;

	public Employer() {

	}
}
