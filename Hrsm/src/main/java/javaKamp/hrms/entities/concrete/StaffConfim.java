package javaKamp.hrms.entities.concrete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "staff_confims")
@Data
public class StaffConfim {
	@Id
	@GeneratedValue
	@Column(name = "Id")
	private int Id;

	@Column(name = "staff_Id")
	private String staffId;

	@Column(name = "is_confirmed")
	private String isConfirmed;

	public StaffConfim() {

	}
}
