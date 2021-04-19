package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Qualification")
public class Qualification {

	@Column(name = "TYPE")
	private String type;

	@Column(name = "START_DATE")
	private Date startDate;

	@Column(name = "END_DATE")
	private Date endDate;

	@Column(name = "INSTITUTION")
	private String institution;

	@Column(name = "ADDRESS")
	private String address;
	
	@ManyToOne
	@JoinColumn(name = "emp_id", nullable = false)
	private Employee employee;
}
