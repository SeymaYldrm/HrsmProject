package javaKamp.hrms.entities.concrete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "verifacition_codes")
@Data
public class VerificitionCode {
	@Id
	@GeneratedValue
	@Column(name = "Id")
	private int Id;

	@Column(name = "code")
	private String code;

	@Column(name = "is_verified")
	private String isVerified;

	public VerificitionCode() {

	}
}
